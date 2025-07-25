package com.pougos.teste_pougos.dto;

import com.pougos.teste_pougos.model.Iniciativa;
import com.pougos.teste_pougos.repository.IniciativaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IniciativaService {
        private final IniciativaRepository iniciativaRepository;

        public IniciativaService(IniciativaRepository iniciativaRepository){
            this.iniciativaRepository = iniciativaRepository;
        }

        public List<Iniciativa> listaIniciativa() {return iniciativaRepository.findAll();}

        public Iniciativa criaIniciativa(Iniciativa iniciativa){return iniciativaRepository.save(iniciativa);}

        public Iniciativa buscaPorId(Long id){
                return iniciativaRepository.findById(id).orElseThrow(() -> new RuntimeException("ID não encontrado"));
        }

        public void apagaIniciativa(){
                iniciativaRepository.deleteAll();
        }

}
