package br.com.inatel.batalha.model;

import java.util.Scanner;
import java.util.Random;

import br.com.inatel.batalha.strategy.AtaqueForte;
import br.com.inatel.batalha.strategy.AtaqueNormal;
import br.com.inatel.batalha.strategy.AtaqueRapido;
import br.com.inatel.batalha.model.Pokemon;


public class Batalha {

    private final Scanner scanner = new Scanner(System.in);
    private final Random random = new Random();

    public void iniciar(Pokemon jogador, Pokemon inimigo) {
        System.out.println("\n Iniciando batalha entre " + jogador.getNome() + " e " + inimigo.getNome());

        boolean turnoDoJogador = true;

        while (jogador.estaVivo() && inimigo.estaVivo()) {
            if (turnoDoJogador) {
                System.out.println("\n🎮 Seu turno! Escolha a ação:");
                System.out.println("1 - Ataque Rápido\n2 - Ataque Normal\n3 - Ataque Forte\n4 - Defender");
                System.out.print("--> ");
                int escolha = scanner.nextInt();

                switch (escolha) {
                    case 1 -> jogador.setAtaqueStrategy(new AtaqueRapido());
                    case 2 -> jogador.setAtaqueStrategy(new AtaqueNormal());
                    case 3 -> jogador.setAtaqueStrategy(new AtaqueForte());
                    case 4 -> {
                        jogador.defender();
                        turnoDoJogador = false;
                        continue;
                    }
                    default -> {
                        System.out.println("Ação inválida. Perdeu o turno.");
                        turnoDoJogador = false;
                        continue;
                    }
                }

                jogador.atacar(inimigo);
            } else {
                System.out.println("\n Turno do inimigo!");
                int acao = random.nextInt(100);
                if (acao < 20) {
                    inimigo.defender();
                } else {
                    int tipo = random.nextInt(3);
                    switch (tipo) {
                        case 0 -> inimigo.setAtaqueStrategy(new AtaqueRapido());
                        case 1 -> inimigo.setAtaqueStrategy(new AtaqueNormal());
                        case 2 -> inimigo.setAtaqueStrategy(new AtaqueForte());
                    }
                    inimigo.atacar(jogador);
                }
            }
            turnoDoJogador = !turnoDoJogador;
        }

        System.out.println("\n🏁 Batalha finalizada!");
        if (jogador.estaVivo()) {
            System.out.println("🏆 Você venceu!");
        } else {
            System.out.println("💀 Você perdeu!");
        }
    }
}
