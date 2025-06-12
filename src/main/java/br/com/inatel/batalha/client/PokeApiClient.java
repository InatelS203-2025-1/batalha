package br.com.inatel.batalha.client;

import br.com.inatel.batalha.dto.PokemonDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PokeApiClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "https://pokeapi.co/api/v2/pokemon/";

    public PokemonDTO buscarPokemon(String nome) {
        String url = BASE_URL + nome.toLowerCase();
        return restTemplate.getForObject(url, PokemonDTO.class);
    }
}