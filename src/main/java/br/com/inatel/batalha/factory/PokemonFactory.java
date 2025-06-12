package br.com.inatel.batalha.factory;

import br.com.inatel.batalha.dto.PokemonDTO;
import br.com.inatel.batalha.model.Pokemon;

public class PokemonFactory {

    public static Pokemon converter(PokemonDTO dto) {
        Pokemon pokemon = new Pokemon();
        pokemon.setNome(dto.getName());
        pokemon.setTipo(dto.getTypes().get(0).getType().getName()); // Primeiro tipo
        pokemon.setHp(dto.getStats().get(0).getBase_stat());         // HP
        pokemon.setAtaque(dto.getStats().get(1).getBase_stat());     // Ataque
        return pokemon;
    }
}