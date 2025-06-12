package br.com.inatel.batalha.menu;

import br.com.inatel.batalha.model.ResultadoBatalha;
import br.com.inatel.batalha.service.BatalhaService;

import java.util.List;
import java.util.Scanner;

public class TerminalMenu {

    private final BatalhaService batalhaService;
    private final Scanner scanner = new Scanner(System.in);

    public TerminalMenu(BatalhaService batalhaService) {
        this.batalhaService = batalhaService;
    }

    public void exibirMenu() {
        while (true) {
            System.out.println("=== MENU ===");
            System.out.println("1. Iniciar nova batalha");
            System.out.println("2. Ver histórico de batalhas");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    iniciarBatalhaTerminal();
                    break;
                case 2:
                    List<ResultadoBatalha> historico = batalhaService.obterHistorico();
                    if (historico.isEmpty()) {
                        System.out.println("Nenhuma batalha registrada ainda.");
                    } else {
                        historico.forEach(System.out::println);
                    }
                    break;
                case 0:
                    System.out.println("Encerrando...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void iniciarBatalhaTerminal() {
        System.out.print("Digite o nome do Jogador 1: ");
        String jogador1 = scanner.nextLine();

        System.out.print("Digite o nome do Jogador 2: ");
        String jogador2 = scanner.nextLine();

        // Chama o service que vai cuidar do input dos Pokémons
        batalhaService.iniciarBatalha(jogador1, jogador2);
    }
}