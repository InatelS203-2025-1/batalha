package br.com.inatel.batalha.strategy;

import br.com.inatel.batalha.model.Pokemon;

public interface EstrategiaDeAtaque {
    void executar(Pokemon atacante, Pokemon defensor);
}
