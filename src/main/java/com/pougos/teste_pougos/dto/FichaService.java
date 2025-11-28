package com.pougos.teste_pougos.dto;

import com.pougos.teste_pougos.model.Ficha;
import com.pougos.teste_pougos.repository.FichaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FichaService {

    private final FichaRepository fichaRepository;


    public FichaService(FichaRepository fichaRepository) {
        this.fichaRepository = fichaRepository;

    }
    @Transactional
    public Ficha criaFicha(Ficha ficha){
        return fichaRepository.save(ficha);
    }

    public List<Ficha> retornaFicha(){
        return fichaRepository.findAll();
    }

    public void deletarFichas(){
        List<Ficha> lista = retornaFicha();
        for(Ficha ficha : lista){
            fichaRepository.delete(ficha);

        }

    }

    public Ficha buscaPorId(Long id){
        return fichaRepository.findById(id).orElseThrow(() -> new RuntimeException("ID não encontrado"));
    }

    public void deletaFicha(Ficha ficha){
        fichaRepository.delete(ficha);
    }


}

