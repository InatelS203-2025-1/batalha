package br.com.inatel.batalha.strategy;

import br.com.inatel.batalha.model.Pokemon;

import java.util.Random;

public class AtaqueRapido implements EstrategiaDeAtaque {
    @Override
    public void executar(Pokemon atacante, Pokemon defensor) {
        int chance = new Random().nextInt(100);
        if (chance < 90) { // mais fácil acertar
            int dano = atacante.getAtaque() - 5;
            if (dano < 0) dano = 1;
            System.out.println(atacante.getNome() + " usou Ataque Rápido e causou " + dano + " de dano!");
            defensor.receberDano(dano);
        } else {
            System.out.println(atacante.getNome() + " usou Ataque Rápido, mas errou!");
        }
    }
}