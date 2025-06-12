package br.com.inatel.batalha.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonDTO {
    private String name;
    private int base_experience;
    private int height;
    private int weight;
    private List<TypeSlot> types;
    private List<StatSlot> stats;
}