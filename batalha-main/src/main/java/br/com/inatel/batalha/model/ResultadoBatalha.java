package br.com.inatel.batalha.model;

public class ResultadoBatalha {
    private final String vencedor;
    private final String perdedor;

    public ResultadoBatalha(String vencedor, String perdedor) {
        this.vencedor = vencedor;
        this.perdedor = perdedor;
    }

    @Override
    public String toString() {
        return "Vencedor: " + vencedor + " | Perdedor: " + perdedor;
    }
}
