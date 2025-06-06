package br.com.inatel.batalha.factory;

import br.com.inatel.batalha.model.Pokemon;
import br.com.inatel.batalha.strategy.*;

public class PokemonFactory {
    public static Pokemon criar(String nome) {
        return switch (nome.toLowerCase()) {
            case "pikachu" -> new Pokemon("Pikachu", "elétrico", 80, 25, new AtaqueRapido());
            case "charmander" -> new Pokemon("Charmander", "fogo", 100, 30, new AtaqueForte());
            case "bulbasaur" -> new Pokemon("Bulbasaur", "grama", 90, 20, new AtaqueNormal());
            default -> throw new IllegalArgumentException("Pokémon desconhecido");
        };
    }
}
