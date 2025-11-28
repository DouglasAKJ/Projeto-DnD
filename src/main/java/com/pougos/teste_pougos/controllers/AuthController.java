package com.pougos.teste_pougos.controllers;

import com.pougos.teste_pougos.dto.LoginRequestDTO;
import com.pougos.teste_pougos.dto.RegisterDTO;
import com.pougos.teste_pougos.dto.ResponseDTO;
import com.pougos.teste_pougos.dto.UserService;
import com.pougos.teste_pougos.helper.NullCopyProperties;
import com.pougos.teste_pougos.infra.security.TokenService;
import com.pougos.teste_pougos.model.Usuario;
import com.pougos.teste_pougos.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://127.0.0.1:5500")
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    private final NullCopyProperties nullCopyProperties;
    private final UserRepository userRepository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService, NullCopyProperties nullCopyProperties, UserRepository userRepository, TokenService tokenService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.nullCopyProperties = nullCopyProperties;
        this.userRepository = userRepository;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<?> logaUsuario(@RequestBody LoginRequestDTO body){
        Usuario usuario = userRepository.findByEmail(body.email()).orElseThrow(() -> new RuntimeException("Erro"));
        if(passwordEncoder.matches(body.senha(), usuario.getSenha())){
            String token = this.tokenService.generateToken(usuario);
            return ResponseEntity.ok(new ResponseDTO(usuario.getEmail(), token));
        }
        return ResponseEntity.badRequest().build();
    }

    @PostMapping("/cadastro")
    public ResponseEntity<?> criaUsuario(@RequestBody RegisterDTO body){
        Optional<Usuario> usuario = userRepository.findByEmail(body.email());
        if(usuario.isEmpty()){
            Usuario novoUsuario = new Usuario();
            novoUsuario.setSenha(passwordEncoder.encode(body.senha()));
            novoUsuario.setNome(body.name());
            novoUsuario.setEmail(body.email());
            userRepository.save(novoUsuario);
            String token = this.tokenService.generateToken(novoUsuario);
            return ResponseEntity.ok(new ResponseDTO(novoUsuario.getEmail(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
