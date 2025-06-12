package br.com.inatel.batalha.strategy;

import br.com.inatel.batalha.model.Pokemon;

public class AtaqueDefensivo implements EstrategiaDeAtaque {
    @Override
    public void executar(Pokemon atacante, Pokemon defensor) {
        System.out.println(atacante.getNome() + " usou Ataque Defensivo! Vai receber menos dano no próximo turno.");
        atacante.setDefesaAtiva(true);  // Você deve implementar esse campo e lógica no Pokemon
    }
}