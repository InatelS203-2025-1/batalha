package br.com.inatel.batalha.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor

public class Jogador implements Participante {
    @Override
    public void escolherAcao() {
        // Implementação do método escolherAcao
        System.out.println("Escolhendo ação para o jogador: " + nome);
    }
    private String nome;
    private List<Pokemon> pokemons;

    public void escolherPokemon(int indice) {
        if (indice >= 0 && indice < pokemons.size()) {
            Pokemon pokemonEscolhido = pokemons.get(indice);
            System.out.println(nome + " escolheu o Pokémon: " + pokemonEscolhido.getNome());
        } else {
            System.out.println("Índice inválido. Por favor, escolha um Pokémon válido.");
        }
    }
    
}
