package br.com.inatel.batalha.model;

import java.util.List;

public class Jogador implements Participante {

    private String nome;
    private List<Pokemon> pokemons;

    public Jogador() {
    }

    public Jogador(String nome, List<Pokemon> pokemons) {
        this.nome = nome;
        this.pokemons = pokemons;
    }

    @Override
    public void escolherAcao(Batalha contexto) {
        System.out.println("Jogador " + nome + " escolhe sua ação.");
    }

    public void escolherPokemon(int indice) {
        if (indice >= 0 && indice < pokemons.size()) {
            Pokemon pokemonEscolhido = pokemons.get(indice);
            System.out.println(nome + " escolheu o Pokémon: " + pokemonEscolhido.getNome());
        } else {
            System.out.println("Índice inválido.");
        }
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
