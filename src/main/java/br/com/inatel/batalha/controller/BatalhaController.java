package br.com.inatel.batalha.controller;

import br.com.inatel.batalha.model.ResultadoBatalha;
import br.com.inatel.batalha.service.BatalhaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/batalha")
public class BatalhaController {

    private final BatalhaService batalhaService;

    public BatalhaController(BatalhaService batalhaService) {
        this.batalhaService = batalhaService;
    }

    // Iniciar batalha via POST, com nomes dos jogadores no corpo
    @PostMapping("/iniciar")
    public String iniciarBatalha(@RequestParam String jogador1, @RequestParam String jogador2) {
        batalhaService.iniciarBatalha(jogador1, jogador2);
        return "Batalha iniciada entre " + jogador1 + " e " + jogador2;
    }


        // Retorna o histórico de batalhas
    @GetMapping("/historico")
    public List<ResultadoBatalha> getHistorico() {
        return batalhaService.obterHistorico();
    }
}