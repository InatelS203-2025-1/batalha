package br.com.inatel.batalha.adapter;

import br.com.inatel.batalha.dto.PokemonDTO;
import br.com.inatel.batalha.dto.StatSlot;
import br.com.inatel.batalha.model.Pokemon;

public class PokemonAdapter {

    public static Pokemon converterParaPokemon(PokemonDTO dto) {
        Pokemon pokemon = new Pokemon();

        pokemon.setNome(dto.getName());

        // Tipo primário do Pokémon
        if (dto.getTypes() != null && !dto.getTypes().isEmpty()) {
            pokemon.setTipo(dto.getTypes().get(0).getType().getName());
        } else {
            pokemon.setTipo("normal"); // valor padrão
        }

        // Extrair valores de HP e Ataque dos stats
        int hp = obterStat(dto, "hp", 50);       // valor padrão se não encontrado
        int ataque = obterStat(dto, "attack", 50);

        pokemon.setHp(hp);
        pokemon.setAtaque(ataque);

        return pokemon;
    }

    private static int obterStat(PokemonDTO dto, String nomeStat, int valorPadrao) {
        if (dto.getStats() == null) {
            return valorPadrao;
        }
        return dto.getStats().stream()
                .filter(s -> s.getStat().getName().equalsIgnoreCase(nomeStat))
                .findFirst()
                .map(StatSlot::getBase_stat)
                .orElse(valorPadrao);
    }
}