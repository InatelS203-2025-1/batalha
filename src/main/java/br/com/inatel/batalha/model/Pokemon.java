package br.com.inatel.batalha.model;

import br.com.inatel.batalha.strategy.EstrategiaDeAtaque;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Pokemon implements Participante {

    private String nome;
    private String tipo;
    private int hp;
    private int ataque;

    // Novo campo para controle do modo defensivo
    private boolean defesaAtiva = false;

    public Pokemon() {
    }

    public void atacar(Pokemon oponente, EstrategiaDeAtaque estrategia) {
        System.out.println(nome + " está atacando " + oponente.getNome() + " usando " + estrategia.getClass().getSimpleName());
        estrategia.executar(this, oponente);
    }

    // Metodo para receber dano que respeita o estado defensivo
    public void receberDano(int dano) {
        if (defesaAtiva) {
            dano = dano / 2;  // dano reduzido pela metade
            defesaAtiva = false;  // defesa consumida
            System.out.println(nome + " estava em defesa! Dano reduzido para " + dano);
        }
        this.hp -= dano;
        if (this.hp < 0) this.hp = 0;
        System.out.println(nome + " agora tem " + hp + " HP.");
    }

    @Override
    public void escolherAcao() {
        System.out.println(nome + " está pronto para lutar!");
    }
}