package br.com.inatel.batalha.strategy;

import br.com.inatel.batalha.model.Pokemon;
import br.com.inatel.batalha.strategy.EstrategiaDeAtaque;

import java.util.Random;

public class AtaqueNormal implements EstrategiaDeAtaque {
    @Override
    public void executar(Pokemon atacante, Pokemon defensor) {
        int chance = new Random().nextInt(100);
        if (chance < 70) { // 70% de chance de acerto
            int dano = atacante.getAtaque();
            System.out.println(atacante.getNome() + " usou Ataque Normal e causou " + dano + " de dano!");
            defensor.receberDano(dano);
        } else {
            System.out.println(atacante.getNome() + " usou Ataque Normal, mas errou!");
        }
    }
}

