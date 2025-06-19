package br.com.inatel.batalha.service;

import br.com.inatel.batalha.client.PokeApiClient;
import br.com.inatel.batalha.dto.PokemonDTO;
import br.com.inatel.batalha.factory.PokemonFactory;
import br.com.inatel.batalha.model.Batalha;
import br.com.inatel.batalha.model.Jogador;
import br.com.inatel.batalha.model.Pokemon;
import br.com.inatel.batalha.model.ResultadoBatalha;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import org.springframework.stereotype.Service;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class BatalhaService {

    private final PokeApiClient pokeApiClient;
    private final List<ResultadoBatalha> historicoBatalhas = new ArrayList<>();

    private static final String ARQUIVO_HISTORICO = System.getProperty("user.dir") + File.separator + "historico_batalhas.json";

    private final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new TypeAdapter<LocalDateTime>() {
                private final DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

                @Override
                public void write(JsonWriter out, LocalDateTime value) throws IOException {
                    out.value(value.format(formatter));
                }

                @Override
                public LocalDateTime read(JsonReader in) throws IOException {
                    return LocalDateTime.parse(in.nextString(), formatter);
                }
            })
            .setPrettyPrinting()
            .create();

    public BatalhaService(PokeApiClient pokeApiClient) {
        this.pokeApiClient = pokeApiClient;
    }

    public void iniciarBatalha(String nomeJogador1, String nomeJogador2) {
        Jogador jogador1 = criarJogador(nomeJogador1);
        Jogador jogador2 = criarJogador(nomeJogador2);

        Batalha batalha = new Batalha(jogador1, jogador2);
        batalha.iniciarBatalha();

        ResultadoBatalha resultado = new ResultadoBatalha(
                jogador1.getNome(),
                jogador2.getNome(),
                batalha.getVitoriasJogador1(),
                batalha.getVitoriasJogador2()
        );

        historicoBatalhas.add(resultado);
        System.out.println("Batalha finalizada! Resultado registrado.");

        salvarHistoricoNoArquivo();
    }

    private void salvarHistoricoNoArquivo() {
        try {
            File file = new File(ARQUIVO_HISTORICO);
            System.out.println("Salvando histórico em: " + file.getAbsolutePath());

            try (Writer writer = new FileWriter(file)) {
                gson.toJson(historicoBatalhas, writer);
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar histórico: " + e.getMessage());
        }
    }

    private void carregarHistoricoDoArquivo() {
        File file = new File(ARQUIVO_HISTORICO);

        if (!file.exists()) {
            System.out.println("Arquivo de histórico não encontrado, iniciando com histórico vazio.");
            return;
        }

        try (Reader reader = new FileReader(file)) {
            Type listaTipo = new TypeToken<ArrayList<ResultadoBatalha>>() {}.getType();
            List<ResultadoBatalha> lista = gson.fromJson(reader, listaTipo);
            if (lista != null) {
                historicoBatalhas.clear();
                historicoBatalhas.addAll(lista);
                System.out.println("Histórico carregado com sucesso.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar histórico: " + e.getMessage());
        }
    }

    public List<ResultadoBatalha> obterHistorico() {
        carregarHistoricoDoArquivo();
        return new ArrayList<>(historicoBatalhas);
    }

    private Jogador criarJogador(String nome) {
        Scanner scanner = new Scanner(System.in);
        List<Pokemon> pokemons = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            System.out.print("Digite o nome do Pokémon " + (i + 1) + " para o jogador " + nome + ": ");
            String nomePokemon = scanner.nextLine().toLowerCase();

            try {
                PokemonDTO dto = pokeApiClient.buscarPokemon(nomePokemon);
                Pokemon pokemon = PokemonFactory.converter(dto);
                pokemons.add(pokemon);
            } catch (Exception e) {
                System.out.println("Erro ao buscar Pokémon: " + nomePokemon + ". Tente novamente.");
                i--; // repete a tentativa
            }
        }

        return new Jogador(nome, pokemons);
    }
}