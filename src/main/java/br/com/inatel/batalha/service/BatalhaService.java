package br.com.inatel.batalha.service;

import br.com.inatel.batalha.client.PokeApiClient;
import br.com.inatel.batalha.dto.PokemonDTO;
import br.com.inatel.batalha.factory.PokemonFactory;
import br.com.inatel.batalha.model.Batalha;
import br.com.inatel.batalha.model.Jogador;
import br.com.inatel.batalha.model.Pokemon;
import br.com.inatel.batalha.model.ResultadoBatalha;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@Service
public class BatalhaService {

    private final PokeApiClient pokeApiClient;

    // Histórico simples em memória
    private final List<ResultadoBatalha> historicoBatalhas = new ArrayList<>();
    private static final String ARQUIVO_HISTORICO = "historico_batalhas.json";
    private final Gson gson = new Gson();

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
        try (Writer writer = new FileWriter(ARQUIVO_HISTORICO)) {
            gson.toJson(historicoBatalhas, writer);
        } catch (IOException e) {
            System.out.println("Erro ao salvar histórico: " + e.getMessage());
        }
    }

    @PostConstruct
    public void carregarHistoricoDoArquivo() {
        InputStream input = getClass().getClassLoader().getResourceAsStream(ARQUIVO_HISTORICO);
        if (input == null) {
            System.out.println("Arquivo de histórico não encontrado, iniciando com histórico vazio.");
            return;
        }
        try (Reader reader = new InputStreamReader(input)) {
            Type listaTipo = new TypeToken<ArrayList<ResultadoBatalha>>(){}.getType();
            List<ResultadoBatalha> lista = gson.fromJson(reader, listaTipo);
            if (lista != null) {
                historicoBatalhas.clear();
                historicoBatalhas.addAll(lista);
            }
        } catch (Exception e) {
            System.out.println("Erro ao carregar histórico: " + e.getMessage());
        }
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
                i--; // Repetir a iteração
            }
        }

        return new Jogador(nome, pokemons);
    }


    public List<ResultadoBatalha> obterHistorico() {
        return new ArrayList<>(historicoBatalhas);
    }

}