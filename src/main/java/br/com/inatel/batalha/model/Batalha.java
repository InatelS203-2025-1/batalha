package br.com.inatel.batalha.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Batalha {

    private Jogador jogador1;
    private Jogador jogador2;

    private int vitoriasJogador1 = 0;
    private int vitoriasJogador2 = 0;

    public Batalha(Jogador j1, Jogador j2) {
        this.jogador1 = j1;
        this.jogador2 = j2;
    }

    public void iniciarBatalha() {
        for (int rodada = 1; rodada <= 5; rodada++) {
            System.out.println("Rodada " + rodada);

            // Jogadores escolhem ação / pokémon e estratégia
            jogador1.escolherAcao();
            jogador2.escolherAcao();

            Pokemon p1 = jogador1.getPokemonAtual();
            Pokemon p2 = jogador2.getPokemonAtual();

            // Simulação do combate até um Pokémon cair
            while (p1.getHp() > 0 && p2.getHp() > 0) {
                jogador1.atacar(p2);
                if (p2.getHp() > 0) {
                    jogador2.atacar(p1);
                }
            }

            // Determina vencedor da rodada e contabiliza
            int resultado = calcularVencedor(p1, p2);
            if (resultado == 1) {
                vitoriasJogador1++;
                jogador1.setPokemonAtual(p1);
                jogador2.setPokemonAtual(null);
            } else if (resultado == 2) {
                vitoriasJogador2++;
                jogador2.setPokemonAtual(p2);
                jogador1.setPokemonAtual(null);
            } else {
                System.out.println("Empate na rodada!");
            }
        }

        registrarResultado();
    }

    public int calcularVencedor(Pokemon p1, Pokemon p2) {
        if (p1.getHp() > 0 && p2.getHp() <= 0) {
            System.out.println(p1.getNome() + " venceu a rodada!");
            return 1;
        } else if (p2.getHp() > 0 && p1.getHp() <= 0) {
            System.out.println(p2.getNome() + " venceu a rodada!");
            return 2;
        } else {
            System.out.println("Empate!");
            return 0;
        }
    }

    public void registrarResultado() {
        System.out.println(">> Resultado final da batalha:");
        System.out.println("Jogador 1 venceu " + vitoriasJogador1 + " rodadas");
        System.out.println("Jogador 2 venceu " + vitoriasJogador2 + " rodadas");

        if (vitoriasJogador1 > vitoriasJogador2) {
            System.out.println("Jogador 1 venceu a batalha!");
        } else if (vitoriasJogador2 > vitoriasJogador1) {
            System.out.println("Jogador 2 venceu a batalha!");
        } else {
            System.out.println("Batalha empatada!");
        }
    }
}