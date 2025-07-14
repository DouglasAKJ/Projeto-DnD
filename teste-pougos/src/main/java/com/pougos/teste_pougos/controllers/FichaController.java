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

    @Transactional
    @PatchMapping("/alteraForca/{id}")
    public Ficha alteraForca(@AuthenticationPrincipal Usuario usuario, @RequestBody Ficha ficha,@PathVariable("id") Long id) throws InvocationTargetException, IllegalAccessException {
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.getAtributos().setForca(ficha.getAtributos().getForca());
        int mod = fichaAtual.getAtributos().getModificador(TipoAtributo.FORCA);
        int bonusProf = fichaAtual.getProficiencia();

        fichaAtual.getPericias().stream()
                .filter(p -> p.getTipoAtributo() == TipoAtributo.FORCA)
                .forEach(p -> p.calculaMod(mod, bonusProf));
        fichaService.criaFicha(fichaAtual);
        //beanUtilsBean.copyProperties(fichaAtual, ficha);
        return fichaService.criaFicha(fichaAtual);
    }

    @Transactional
    @PatchMapping("/alteraDex/{id}")
    public ResponseEntity alteraDex(@AuthenticationPrincipal Usuario usuario,@RequestBody Ficha ficha,@PathVariable("id") Long id) throws InvocationTargetException, IllegalAccessException {
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.getAtributos().setDestreza(ficha.getAtributos().getDestreza());
        int mod = fichaAtual.getAtributos().getModificador(TipoAtributo.DESTREZA);
        int bonusProf = fichaAtual.getProficiencia();

        fichaAtual.getPericias().stream()
                .filter(p -> p.getTipoAtributo() == TipoAtributo.DESTREZA)
                .forEach(p -> p.calculaMod(mod, bonusProf));
        fichaService.criaFicha(fichaAtual);


        //beanUtilsBean.copyProperties(fichaAtual, ficha);
        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/alteraCons/{id}")
    public ResponseEntity alteraCons(@AuthenticationPrincipal Usuario usuario, @RequestBody Ficha ficha,@PathVariable("id") Long id) throws InvocationTargetException, IllegalAccessException {
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.getAtributos().setConstituicao(ficha.getAtributos().getConstituicao());
        int mod = fichaAtual.getAtributos().getModificador(TipoAtributo.CONSTITUICAO);
        int bonusProf = fichaAtual.getProficiencia();

        fichaAtual.getPericias().stream()
                .filter(p -> p.getTipoAtributo() == TipoAtributo.CONSTITUICAO)
                .forEach(p -> p.calculaMod(mod, bonusProf));
        //beanUtilsBean.copyProperties(fichaAtual, ficha);
        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/alteraInteligencia/{id}")
    public ResponseEntity alteraInteligencia(@AuthenticationPrincipal Usuario usuario, @RequestBody Ficha ficha,@PathVariable("id") Long id) throws InvocationTargetException, IllegalAccessException {
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.getAtributos().setInteligencia(ficha.getAtributos().getInteligencia());
        int mod = fichaAtual.getAtributos().getModificador(TipoAtributo.INTELIGENCIA);
        int bonusProf = fichaAtual.getProficiencia();

        fichaAtual.getPericias().stream()
                .filter(p -> p.getTipoAtributo() == TipoAtributo.INTELIGENCIA)
                .forEach(p -> p.calculaMod(mod, bonusProf));
        //beanUtilsBean.copyProperties(fichaAtual, ficha);
        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/alteraSab/{id}")
    public ResponseEntity alteraSab(@AuthenticationPrincipal Usuario usuario, @RequestBody Ficha ficha,@PathVariable("id") Long id) throws InvocationTargetException, IllegalAccessException {
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.getAtributos().setSabedoria(ficha.getAtributos().getSabedoria());
        int mod = fichaAtual.getAtributos().getModificador(TipoAtributo.SABEDORIA);
        int bonusProf = fichaAtual.getProficiencia();

        fichaAtual.getPericias().stream()
                .filter(p -> p.getTipoAtributo() == TipoAtributo.SABEDORIA)
                .forEach(p -> p.calculaMod(mod, bonusProf));
        //beanUtilsBean.copyProperties(fichaAtual, ficha);
        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/alteraCarisma/{id}")
    public ResponseEntity alteraCarisma(@AuthenticationPrincipal Usuario usuario, @RequestBody Ficha ficha,@PathVariable("id") Long id) throws InvocationTargetException, IllegalAccessException {
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.getAtributos().setCarisma(ficha.getAtributos().getCarisma());
        int mod = fichaAtual.getAtributos().getModificador(TipoAtributo.CARISMA);
        int bonusProf = fichaAtual.getProficiencia();

        fichaAtual.getPericias().stream()
                .filter(p -> p.getTipoAtributo() == TipoAtributo.CARISMA)
                .forEach(p -> p.calculaMod(mod, bonusProf));

        fichaService.criaFicha(fichaAtual);
        //beanUtilsBean.copyProperties(fichaAtual, ficha);
        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/profForca/{id}")
    public ResponseEntity alteraProficienciaForca(@AuthenticationPrincipal Usuario usuario, @RequestBody Ficha ficha, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.getAtributos().setForcaProf(ficha.getAtributos().isForcaProf());
        if (fichaAtual.getAtributos().isForcaProf()){
            fichaAtual.getAtributos().setForcaSave(fichaAtual.getAtributos().getForcaMod(), fichaAtual.getProficiencia());
        } else {
            fichaAtual.getAtributos().setForcaSave(fichaAtual.getAtributos().getForcaMod(), 0);
        }
        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/profDestreza/{id}")
    public ResponseEntity alteraProficienciaDestreza(@AuthenticationPrincipal Usuario usuario, @RequestBody Ficha ficha, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.getAtributos().setDestrezaProf((ficha.getAtributos().isDestrezaProf()));
        if (fichaAtual.getAtributos().isDestrezaProf()){
            fichaAtual.getAtributos().setDestrezaSave(fichaAtual.getAtributos().getDestrezaMod(), fichaAtual.getProficiencia());
        } else {
            fichaAtual.getAtributos().setDestrezaSave(fichaAtual.getAtributos().getDestrezaMod(), 0);
        }
        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/profCons/{id}")
    public ResponseEntity alteraProficienciaCons(@AuthenticationPrincipal Usuario usuario, @RequestBody Ficha ficha, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.getAtributos().setConstituicaoProf(ficha.getAtributos().isConstituicaoProf());
        if (fichaAtual.getAtributos().isConstituicaoProf()){
            fichaAtual.getAtributos().setConstituicaoSave(fichaAtual.getAtributos().getConstituicaoMod(), fichaAtual.getProficiencia());
        } else {
            fichaAtual.getAtributos().setConstituicaoSave(fichaAtual.getAtributos().getConstituicaoMod(), 0);
        }
        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/profCarisma/{id}")
    public ResponseEntity alteraProficienciaCarisma(@AuthenticationPrincipal Usuario usuario, @RequestBody Ficha ficha, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.getAtributos().setCarismaProf(ficha.getAtributos().isCarismaProf());
        if (fichaAtual.getAtributos().isCarismaProf()){
            fichaAtual.getAtributos().setCarismaSave(fichaAtual.getAtributos().getCarismaMod(), fichaAtual.getProficiencia());
        } else {
            fichaAtual.getAtributos().setCarismaSave(fichaAtual.getAtributos().getCarismaMod(), 0);
        }
        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/profInteligencia/{id}")
    public ResponseEntity alteraProficienciaInteligencia(@AuthenticationPrincipal Usuario usuario, @RequestBody Ficha ficha, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.getAtributos().setInteligenciaProf(ficha.getAtributos().isInteligenciaProf());
        if (fichaAtual.getAtributos().isInteligenciaProf()){
            fichaAtual.getAtributos().setInteligenciaSave(fichaAtual.getAtributos().getInteligenciaMod(), fichaAtual.getProficiencia());
        } else {
            fichaAtual.getAtributos().setInteligenciaSave(fichaAtual.getAtributos().getInteligenciaMod(), 0);
        }
        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/profSabedoria/{id}")
    public ResponseEntity alteraProficienciaSabedoria(@AuthenticationPrincipal Usuario usuario, @RequestBody Ficha ficha, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.getAtributos().setSabedoriaProf(ficha.getAtributos().isSabedoriaProf());
        if (fichaAtual.getAtributos().isSabedoriaProf()){
            fichaAtual.getAtributos().setSabedoriaSave(fichaAtual.getAtributos().getSabedoriaMod(), fichaAtual.getProficiencia());
        } else {
            fichaAtual.getAtributos().setSabedoriaSave(fichaAtual.getAtributos().getSabedoriaMod(), 0);
        }
        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
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
