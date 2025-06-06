package br.com.inatel.batalha.simulador;

import java.util.Scanner;
import java.util.Random;

import br.com.inatel.batalha.factory.PokemonFactory;
import br.com.inatel.batalha.model.Batalha;
import br.com.inatel.batalha.model.Pokemon;



public class SimuladorDeBatalhas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha seu Pokémon:");
        System.out.println("1 - Pikachu\n2 - Charmander\n3 - Bulbasaur");
        System.out.print("--> ");
        int opcao = scanner.nextInt();

        Pokemon jogador = null;
        switch (opcao) {
            case 1 -> jogador = PokemonFactory.criar("pikachu");
            case 2 -> jogador = PokemonFactory.criar("charmander");
            case 3 -> jogador = PokemonFactory.criar("bulbasaur");
            default -> System.out.println("Opção inválida");
        }

        if (jogador == null) return;

        String[] nomes = {"pikachu", "charmander", "bulbasaur"};
        String aleatorio = nomes[new Random().nextInt(3)];
        Pokemon inimigo = PokemonFactory.criar(aleatorio);

        while (inimigo.getNome().equalsIgnoreCase(jogador.getNome())) {
            aleatorio = nomes[new Random().nextInt(3)];
            inimigo = PokemonFactory.criar(aleatorio);
        }

        Batalha batalha = new Batalha();
        batalha.iniciar(jogador, inimigo);
    }
}
