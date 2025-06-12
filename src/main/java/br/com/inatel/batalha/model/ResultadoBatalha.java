package br.com.inatel.batalha.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResultadoBatalha {

    private String jogador1Nome;
    private String jogador2Nome;
    private int vitoriasJogador1;
    private int vitoriasJogador2;
    private LocalDateTime dataBatalha;

    public ResultadoBatalha(String jogador1Nome, String jogador2Nome, int vitoriasJogador1, int vitoriasJogador2) {
        this.jogador1Nome = jogador1Nome;
        this.jogador2Nome = jogador2Nome;
        this.vitoriasJogador1 = vitoriasJogador1;
        this.vitoriasJogador2 = vitoriasJogador2;
        this.dataBatalha = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "ResultadoBatalha{" +
                "jogador1='" + jogador1Nome + '\'' +
                ", jogador2='" + jogador2Nome + '\'' +
                ", vitoriasJogador1=" + vitoriasJogador1 +
                ", vitoriasJogador2=" + vitoriasJogador2 +
                ", dataBatalha=" + dataBatalha +
                '}';
    }
}