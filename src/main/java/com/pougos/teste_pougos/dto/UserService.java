package com.pougos.teste_pougos.dto;

import com.pougos.teste_pougos.model.Usuario;
import com.pougos.teste_pougos.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Usuario saveUsuario(Usuario usuario){
        if(userRepository.existsByEmail(usuario.getEmail())){
            throw new IllegalArgumentException("Email já cadastrado");
        }
        return userRepository.save(usuario);
    }

    public List<Usuario> listaUsuarios(){
        return userRepository.findAll();
    }

    public Optional<Usuario> buscaPorEmail(Usuario usuario){
       return userRepository.findByEmail(usuario.getEmail());
    }

    public void deletaUsuarios(){
        userRepository.deleteAll();
    }

    public boolean  verificaLogin(Usuario usuario){
        if(!userRepository.existsByEmailAndSenha(usuario.getEmail(), usuario.getSenha())){
            throw new IllegalArgumentException("Conta inválida");
        } else {
            return true;
        }
    }


}
