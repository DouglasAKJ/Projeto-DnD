package com.pougos.teste_pougos.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pougos.teste_pougos.dto.*;
import com.pougos.teste_pougos.helper.NullCopyProperties;
import com.pougos.teste_pougos.model.Atributos;
import com.pougos.teste_pougos.model.Ficha;
import com.pougos.teste_pougos.model.TipoAtributo;
import com.pougos.teste_pougos.model.Usuario;
import com.pougos.teste_pougos.repository.FichaRepository;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.coyote.Request;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@RestController
@RequestMapping("/ficha")
public class FichaController {
    private final FichaService fichaService;
    private final NullCopyProperties beanUtilsBean;

    public FichaController(FichaService fichaService, NullCopyProperties beanUtilsBean) {
        this.fichaService = fichaService;
        this.beanUtilsBean = beanUtilsBean;
    }
    @PostMapping("/{id}")
    public ResponseEntity valorProficiencia(@AuthenticationPrincipal Usuario usuario, @RequestBody FichaDTO fichaDTO, @PathVariable Long id){
        Ficha ficha = new Ficha();
        fichaDTO.setProficiencia(ficha.defProficiencia(fichaDTO.getLevel()));
       int valorProf = fichaDTO.getProficiencia();
       int deslocamento = fichaDTO.getDeslocamento();
       int classeArmadura = fichaDTO.getClasseArmadura();
       Ficha fichaAtual = fichaService.buscaPorId(id);
       fichaAtual.setLevel(fichaDTO.getLevel());
       fichaAtual.setProficiencia(valorProf);
       int valorVida = fichaDTO.getVida();
       fichaAtual.setVida(valorVida);
       fichaAtual.setClasseArmadura(classeArmadura);
       fichaAtual.setDeslocamento(deslocamento);
       fichaService.criaFicha(fichaAtual);
       return ResponseEntity.ok(new FichaDTO(fichaAtual));

    }

   // @PostMapping("/alteraVida/{id}")
    //public void alteraVida(@RequestBody Ficha ficha, @PathVariable Long id){
        //fichaService.criaFicha(fichaAtual);
   // }

    @GetMapping("/{id}")
    public ResponseEntity getFicha(@AuthenticationPrincipal Usuario usuario, @PathVariable Long id){
        Ficha ficha = fichaService.buscaPorId(id);
        return ResponseEntity.ok(new FichaDTO(ficha));
    }

    @PostMapping("/criaficha")
    public ResponseEntity<FichaDTO> criaFicha(@AuthenticationPrincipal Usuario usuario,@RequestBody FichaDTO fichaDTO){
        Ficha ficha = new Ficha(usuario);
        ficha.setNome(fichaDTO.getNome());
        ficha.setClasse(fichaDTO.getClasse());

        ficha = fichaService.criaFicha(ficha);
        return ResponseEntity.ok(new FichaDTO(ficha));
    }

    @PostMapping("/deletarFichas")
    public void deletaFichas(){
        fichaService.deletarFichas();
    }

    @PatchMapping("/alteraForca/{id}")
    public Ficha alteraForca(@AuthenticationPrincipal Usuario usuario, @RequestBody Ficha ficha,@PathVariable("id") Long id) throws InvocationTargetException, IllegalAccessException {
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.getAtributos().setForca(ficha.getAtributos().getForca());
        //beanUtilsBean.copyProperties(fichaAtual, ficha);
        return fichaService.criaFicha(fichaAtual);
    }

    @Transactional
    @PatchMapping("/alteraDex/{id}")
    public Ficha alteraDex(@AuthenticationPrincipal Usuario usuario,@RequestBody Ficha ficha,@PathVariable("id") Long id) throws InvocationTargetException, IllegalAccessException {
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.getAtributos().setDestreza(ficha.getAtributos().getDestreza());
        int mod = fichaAtual.getAtributos().getModificador(TipoAtributo.DESTREZA);
        int bonusProf = fichaAtual.getProficiencia();

        fichaAtual.getPericias().stream()
                .filter(p -> p.getTipoAtributo() == TipoAtributo.DESTREZA)
                .forEach(p -> p.calculaMod(mod, bonusProf));


        //beanUtilsBean.copyProperties(fichaAtual, ficha);
        return fichaService.criaFicha(fichaAtual);
    }

    @PatchMapping("/alteraCons/{id}")
    public Ficha alteraCons(@AuthenticationPrincipal Usuario usuario, @RequestBody Ficha ficha,@PathVariable("id") Long id) throws InvocationTargetException, IllegalAccessException {
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.getAtributos().setConstituicao(ficha.getAtributos().getConstituicao());
        //beanUtilsBean.copyProperties(fichaAtual, ficha);
        return fichaService.criaFicha(fichaAtual);
    }

    @PatchMapping("/alteraInteligencia/{id}")
    public Ficha alteraInteligencia(@AuthenticationPrincipal Usuario usuario, @RequestBody Ficha ficha,@PathVariable("id") Long id) throws InvocationTargetException, IllegalAccessException {
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.getAtributos().setInteligencia(ficha.getAtributos().getInteligencia());
        //beanUtilsBean.copyProperties(fichaAtual, ficha);
        return fichaService.criaFicha(fichaAtual);
    }

    @PatchMapping("/alteraSab/{id}")
    public Ficha alteraSab(@AuthenticationPrincipal Usuario usuario, @RequestBody Ficha ficha,@PathVariable("id") Long id) throws InvocationTargetException, IllegalAccessException {
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.getAtributos().setSabedoria(ficha.getAtributos().getSabedoria());
        //beanUtilsBean.copyProperties(fichaAtual, ficha);
        return fichaService.criaFicha(fichaAtual);
    }

    @PatchMapping("/alteraCarisma/{id}")
    public Ficha alteraCarisma(@AuthenticationPrincipal Usuario usuario, @RequestBody Ficha ficha,@PathVariable("id") Long id) throws InvocationTargetException, IllegalAccessException {
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.getAtributos().setCarisma(ficha.getAtributos().getCarisma());
        //beanUtilsBean.copyProperties(fichaAtual, ficha);
        return fichaService.criaFicha(fichaAtual);
    }




//    @GetMapping
//    public Ficha criaFicha(){
//        ficha.setValorAtributo(TipoAtributo.DESTREZA, 8);
//        ficha.setValorAtributo(TipoAtributo.FORCA, 20);
//        return ficha;
//    }
//

//
//    @PostMapping("/altera-valor")
//    public int alteraValores(@RequestBody AtributoRequest atributo){
//        TipoAtributo tipo = TipoAtributo.valueOf(atributo.getNome().toUpperCase());
//        ficha.setValorAtributo(tipo, atributo.getValor());
//        return ficha.getAtributos().getValor(tipo);
//    }



}
