package br.com.inatel.batalha.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Pokemon implements Participante {
    @Override
    public void escolherAcao() {
        // Implementação do método escolherAcao
        System.out.println("Escolhendo ação para o Pokémon: " + nome);
    }
    private String nome;
    private String tipo;
    private int hp;
    private int ataque;

    public void atacar(Pokemon oponente) {
        if (this.hp > 0) {
            System.out.println(this.nome + " ataca " + oponente.getNome() + " causando " + this.ataque + " de dano!");
            oponente.setHp(oponente.getHp() - this.ataque);
            if (oponente.getHp() <= 0) {
                System.out.println(oponente.getNome() + " foi derrotado!");
            }
        } else {
            System.out.println(this.nome + " não pode atacar porque está fora de combate!");
        }
    }

    public boolean estaVivo() {
        return this.hp > 0;
    }

    public void receberDano(int dano) {
        this.hp -= dano;
        if (this.hp < 0) {
            this.hp = 0;
        }
        System.out.println(this.nome + " recebeu " + dano + " de dano. HP restante: " + this.hp);
    }
}
