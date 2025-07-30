package com.pougos.teste_pougos.controllers;


import com.pougos.teste_pougos.dto.*;
import com.pougos.teste_pougos.helper.NullCopyProperties;
import com.pougos.teste_pougos.infra.security.TokenService;
import com.pougos.teste_pougos.model.Ficha;
import com.pougos.teste_pougos.model.Usuario;
import com.pougos.teste_pougos.repository.FichaRepository;
import com.pougos.teste_pougos.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UserController {
    private final UserService userService;
    private final FichaRepository fichaRepository;
    private final FichaService fichaService;

    public UserController(UserService userService, FichaRepository fichaRepository, FichaService fichaService) {
        this.userService = userService;
        this.fichaRepository = fichaRepository;
        this.fichaService = fichaService;
    }

    @GetMapping
    public List<Usuario> listaUsuarios(){
        return userService.listaUsuarios();
    }

    @GetMapping("/return")
    public ResponseEntity testaUsuario(){
        return ResponseEntity.ok("sucesso");
    }

    @GetMapping("/returnUsuario")
    public ResponseEntity retornaUsuarioLogado(@AuthenticationPrincipal Usuario usuario){

        return ResponseEntity.ok(usuario);
    }

    @GetMapping("/returnFichas")
    public ResponseEntity retornaFichas(@AuthenticationPrincipal Usuario usuario){
        List<Ficha> fichas = fichaRepository.findByUsuario(usuario);
        return ResponseEntity.ok(fichas);
    }

    @PostMapping("/deletaFicha")
    public ResponseEntity deletaFicha(@AuthenticationPrincipal Usuario usuario, @RequestBody FichaDTO fichaDTO){
        Ficha ficha = fichaService.buscaPorId(fichaDTO.getId());
        fichaRepository.delete(ficha);
        List<Ficha> fichas = fichaRepository.findByUsuario(usuario);
        return ResponseEntity.ok(fichas);
    }
}
