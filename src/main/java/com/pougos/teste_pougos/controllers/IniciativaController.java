package com.pougos.teste_pougos.controllers;

import com.pougos.teste_pougos.dto.IniciativaDTO;
import com.pougos.teste_pougos.dto.IniciativaService;
import com.pougos.teste_pougos.model.Iniciativa;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/iniciativa")
public class IniciativaController {
    private final IniciativaService iniciativaService;

    public IniciativaController(IniciativaService iniciativaService) {
        this.iniciativaService = iniciativaService;
    }

    @PostMapping
    public ResponseEntity adicionaIniciativa(@RequestBody Iniciativa iniciativa){
        iniciativaService.criaIniciativa(iniciativa);

        return ResponseEntity.ok(iniciativa);
    }

    @GetMapping
    public ResponseEntity listaIniciativas(){
        List<Iniciativa> iniciativas = iniciativaService.listaIniciativa();
        return ResponseEntity.ok(iniciativas);
    }

    @PatchMapping("/{id}")
    public ResponseEntity alteraHP(@RequestBody IniciativaDTO iniciativaDTO, @PathVariable Long id){
        Iniciativa iniciativa = iniciativaService.buscaPorId(id);
        iniciativa.setHp(iniciativaDTO.hp());
        iniciativaService.criaIniciativa(iniciativa);
        return ResponseEntity.ok(iniciativa);
    }

    @PostMapping("/deleta")
    public ResponseEntity deletaIniciativa(){
        iniciativaService.apagaIniciativa();
        return ResponseEntity.ok(iniciativaService.listaIniciativa());
    }
}
