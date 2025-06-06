package br.com.inatel.batalha.service;

import br.com.inatel.batalha.model.Jogador;

public class BatalhaService {
    public void iniciarBatalha(Jogador jogador1, Jogador jogador2) {
       // System.out.println("Iniciando batalha entre " + jogador1.getNome() + " e " + jogador2.getNome());
        
        // Lógica de batalha aqui
        // Exemplo: escolher Pokémon, atacar, etc.
        
        System.out.println("Batalha iniciada!");
    }

    public String calcularVencedor(Jogador jogador1, Jogador jogador2) {
        // Lógica para calcular o vencedor da batalha
        // Exemplo: comparar pontos de vida dos Pokémon, etc.
        
        // Retorna o nome do vencedor
        return "Vencedor: " + jogador1.getNome(); // Exemplo fixo, deve ser implementado corretamente
    }

    public void registrarResultado(Jogador vencedor, Jogador perdedor) {
        System.out.println("Resultado da batalha:");
        System.out.println("Vencedor: " + vencedor.getNome());
        System.out.println("Perdedor: " + perdedor.getNome());
        
        // Lógica para registrar o resultado em um banco de dados ou arquivo
        // Enviar para API externa via REST (SOA)
    }


}