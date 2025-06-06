package br.com.inatel.batalha.model;

import br.com.inatel.batalha.strategy.EstrategiaDeAtaque;

public class Pokemon implements Participante {

    private String nome;
    private String tipo;
    private int hp;
    private int ataque;
    private EstrategiaDeAtaque ataqueStrategy;
    private boolean defendendo;

    public Pokemon() {
    }

    public Pokemon(String nome, String tipo, int hp, int ataque, EstrategiaDeAtaque ataqueStrategy) {
        this.nome = nome;
        this.tipo = tipo;
        this.hp = hp;
        this.ataque = ataque;
        this.ataqueStrategy = ataqueStrategy;
    }

    @Override
    public void escolherAcao(Batalha contexto) {
        System.out.println("Pokémon " + nome + " escolhe sua ação no contexto da batalha.");
    }

    public void atacar(Pokemon oponente) {
        if (ataqueStrategy != null) {
            ataqueStrategy.executar(this, oponente);
        } else {
            System.out.println(nome + " não tem estratégia de ataque definida.");
        }
    }

    public void defender() {
        System.out.println(nome + " se defendeu! Reduzirá o dano no próximo turno.");
        this.defendendo = true;
    }

    public boolean isDefendendo() {
        return defendendo;
    }

    public void setDefendendo(boolean defendendo) {
        this.defendendo = defendendo;
    }


    public boolean estaVivo() {
        return this.hp > 0;
    }

    public void receberDano(int dano) {
        if (defendendo) {
            dano /= 2;
            System.out.println(nome + " defendeu! Dano reduzido para " + dano);
            defendendo = false;
        }

        this.hp -= dano;
        if (this.hp < 0) this.hp = 0;
        System.out.println(nome + " agora tem " + this.hp + " de HP.");
    }


    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public EstrategiaDeAtaque getAtaqueStrategy() {
        return ataqueStrategy;
    }

    public void setAtaqueStrategy(EstrategiaDeAtaque ataqueStrategy) {
        this.ataqueStrategy = ataqueStrategy;
    }
}
