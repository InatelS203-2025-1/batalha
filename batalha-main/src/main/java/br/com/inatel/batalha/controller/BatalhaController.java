package br.com.inatel.batalha.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import br.com.inatel.batalha.service.BatalhaService;


@RestController
@RequestMapping("/batalha")
public class BatalhaController {
    public BatalhaController(BatalhaService batalhaService) {
    }

    @PostMapping("/inicnar")
    public String iniciarBatalha(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    
    
}
