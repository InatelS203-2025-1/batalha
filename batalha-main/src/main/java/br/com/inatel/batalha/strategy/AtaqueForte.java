package br.com.inatel.batalha.strategy;

import br.com.inatel.batalha.model.Pokemon;
import java.util.Random;

public class AtaqueForte implements EstrategiaDeAtaque {
    @Override
    public void executar(Pokemon atacante, Pokemon defensor) {
        int chance = new Random().nextInt(100);
        if (chance < 50) {
            int dano = atacante.getAtaque() + 10;
            System.out.println(atacante.getNome() + " usou Ataque Forte e causou " + dano + " de dano!");
            defensor.receberDano(dano);
        } else {
            System.out.println(atacante.getNome() + " usou Ataque Forte, mas errou!");
        }
    }
}

