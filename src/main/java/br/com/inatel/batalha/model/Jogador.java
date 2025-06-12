package br.com.inatel.batalha.model;

import br.com.inatel.batalha.strategy.AtaqueNormal;
import br.com.inatel.batalha.strategy.AtaqueForte;
import br.com.inatel.batalha.strategy.AtaqueRapido;
import br.com.inatel.batalha.strategy.AtaqueDefensivo;
import br.com.inatel.batalha.strategy.EstrategiaDeAtaque;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
public class Jogador implements Participante {

    private String nome;
    private List<Pokemon> pokemons;
    private Pokemon pokemonAtual;

    private EstrategiaDeAtaque estrategiaDeAtaque;

    public Jogador(String nome, List<Pokemon> pokemons) {
        this.nome = nome;
        this.pokemons = pokemons;
    }

    public void escolherPokemon() {
        System.out.println(nome + ", escolha um Pokémon:");
        for (int i = 0; i < pokemons.size(); i++) {
            System.out.println((i + 1) + ". " + pokemons.get(i).getNome());
        }

        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();
        this.pokemonAtual = pokemons.get(escolha - 1);
    }

    public void escolherEstrategia() {
        System.out.println(nome + ", escolha a estratégia de ataque:");
        System.out.println("1. Ataque Normal");
        System.out.println("2. Ataque Forte");
        System.out.println("3. Ataque Rápido");
        System.out.println("4. Ataque Defensivo");
        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();

        switch (escolha) {
            case 1:
                estrategiaDeAtaque = new AtaqueNormal();
                break;
            case 2:
                estrategiaDeAtaque = new AtaqueForte();
                break;
            case 3:
                estrategiaDeAtaque = new AtaqueRapido();
                break;
            case 4:
                estrategiaDeAtaque = new AtaqueDefensivo();
                break;
            default:
                System.out.println("Escolha inválida, usando ataque normal.");
                estrategiaDeAtaque = new AtaqueNormal();
                break;
        }
    }

    public void atacar(Pokemon oponente) {
        if (estrategiaDeAtaque != null && pokemonAtual != null) {
            estrategiaDeAtaque.executar(pokemonAtual, oponente);
        } else {
            System.out.println(nome + " não escolheu estratégia ou Pokémon!");
        }
    }

    @Override
    public void escolherAcao() {
        escolherPokemon();
        escolherEstrategia();
    }
}