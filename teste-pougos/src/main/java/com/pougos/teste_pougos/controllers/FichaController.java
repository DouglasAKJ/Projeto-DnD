package com.pougos.teste_pougos.controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pougos.teste_pougos.dto.*;
import com.pougos.teste_pougos.helper.NullCopyProperties;
import com.pougos.teste_pougos.model.*;
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

    @PostMapping("/deletaAtaque/{id}")
    public ResponseEntity deletaAtaque(@AuthenticationPrincipal Usuario usuario, @RequestBody Ataque ataque, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.deletaAtaque(ataque.getNome(), ataque.getBonus(), ataque.getDano());
        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/alteraCD/{id}")
    public ResponseEntity alteraCD(@AuthenticationPrincipal Usuario usuario, @RequestBody FichaDTO ficha, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.setCdMagia(ficha.getCdMagia());
        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/alteraHp/{id}")
    public ResponseEntity alteraHP(@AuthenticationPrincipal Usuario usuario, @RequestBody FichaDTO ficha, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.setVida(ficha.getVida());
        if (fichaAtual.getVida() < 0){
            fichaAtual.setVida(0);
        }
        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/alteraHpMax/{id}")
    public ResponseEntity alteraHPMax(@AuthenticationPrincipal Usuario usuario, @RequestBody FichaDTO ficha, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.setVidaMax(ficha.getVidaMax());
        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/alteraHpTemp/{id}")
    public ResponseEntity alteraHPTemp(@AuthenticationPrincipal Usuario usuario, @RequestBody FichaDTO ficha, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.setVidaTemp(ficha.getVidaTemp());
        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/cura/{id}")
    public ResponseEntity aplicaCura(@AuthenticationPrincipal Usuario usuario, @RequestBody Integer cura ,@PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.setVida(fichaAtual.getVida() + cura);
        if(fichaAtual.getVida() > fichaAtual.getVidaMax()){
            fichaAtual.setVida(fichaAtual.getVidaMax());
        }
        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);

    }

    @PatchMapping("/dano/{id}")
    public ResponseEntity aplicaDano(@AuthenticationPrincipal Usuario usuario, @RequestBody Integer dano ,@PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.setVida(fichaAtual.getVida() - dano);
        if(fichaAtual.getVida() < 0){
            fichaAtual.setVida(0);
        }
        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);

    }

    @PatchMapping("/alteraDeslocamento/{id}")
    public ResponseEntity alteraDeslocamento(@AuthenticationPrincipal Usuario usuario, @RequestBody FichaDTO ficha, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.setDeslocamento(ficha.getDeslocamento());
        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/alteraCA/{id}")
    public ResponseEntity alteraCA(@AuthenticationPrincipal Usuario usuario, @RequestBody FichaDTO ficha, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.setClasseArmadura(ficha.getClasseArmadura());
        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PostMapping("/caracteristicas/{id}")
    public ResponseEntity alteraCaracteristicas(@AuthenticationPrincipal Usuario usuario, @RequestBody FichaDTO fichaDTO, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.setCaracteristicas(fichaDTO.getCaracteristicas());
        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PostMapping("/aparencia/{id}")
    public ResponseEntity alteraAparencia(@AuthenticationPrincipal Usuario usuario, @RequestBody FichaDTO fichaDTO, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.setAparencia(fichaDTO.getAparencia());
        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/raca/{id}")
    public ResponseEntity alteraRaca(@AuthenticationPrincipal Usuario usuario, @RequestBody FichaDTO fichaDTO, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.setRaca(fichaDTO.getRaca());
        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PostMapping("/idiomas/{id}")
    public ResponseEntity alteraIdiomas(@AuthenticationPrincipal Usuario usuario, @RequestBody FichaDTO fichaDTO, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.setIdiomas(fichaDTO.getIdiomas());
        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PostMapping("/background/{id}")
    public ResponseEntity alteraBackground(@AuthenticationPrincipal Usuario usuario, @RequestBody FichaDTO fichaDTO, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.setBackgrounds(fichaDTO.getBackground());
        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PostMapping("/{id}")
    public ResponseEntity valorProficiencia(@AuthenticationPrincipal Usuario usuario, @RequestBody FichaDTO fichaDTO, @PathVariable Long id){
        Ficha ficha = new Ficha();
        fichaDTO.setProficiencia(ficha.defProficiencia(fichaDTO.getLevel()));
       int valorProf = fichaDTO.getProficiencia();
       Ficha fichaAtual = fichaService.buscaPorId(id);
       fichaAtual.setLevel(fichaDTO.getLevel());
       fichaAtual.setProficiencia(valorProf);


        if (fichaAtual.getAtributos().isForcaProf()){
            fichaAtual.getAtributos().setForcaSave(fichaAtual.getAtributos().getForcaMod(), fichaAtual.getProficiencia());
        } else {
            fichaAtual.getAtributos().setForcaSave(fichaAtual.getAtributos().getForcaMod(), 0);
        }

        if (fichaAtual.getAtributos().isDestrezaProf()){
            fichaAtual.getAtributos().setDestrezaSave(fichaAtual.getAtributos().getDestrezaMod(), fichaAtual.getProficiencia());
        } else {
            fichaAtual.getAtributos().setDestrezaSave(fichaAtual.getAtributos().getDestrezaMod(), 0);
        }

        if (fichaAtual.getAtributos().isConstituicaoProf()){
            fichaAtual.getAtributos().setConstituicaoSave(fichaAtual.getAtributos().getConstituicaoMod(), fichaAtual.getProficiencia());
        } else {
            fichaAtual.getAtributos().setConstituicaoSave(fichaAtual.getAtributos().getConstituicaoMod(), 0);
        }

        if (fichaAtual.getAtributos().isCarismaProf()){
            fichaAtual.getAtributos().setCarismaSave(fichaAtual.getAtributos().getCarismaMod(), fichaAtual.getProficiencia());
        } else {
            fichaAtual.getAtributos().setCarismaSave(fichaAtual.getAtributos().getCarismaMod(), 0);
        }

        if (fichaAtual.getAtributos().isInteligenciaProf()){
            fichaAtual.getAtributos().setInteligenciaSave(fichaAtual.getAtributos().getInteligenciaMod(), fichaAtual.getProficiencia());
        } else {
            fichaAtual.getAtributos().setInteligenciaSave(fichaAtual.getAtributos().getInteligenciaMod(), 0);
        }

        if (fichaAtual.getAtributos().isSabedoriaProf()){
            fichaAtual.getAtributos().setSabedoriaSave(fichaAtual.getAtributos().getSabedoriaMod(), fichaAtual.getProficiencia());
        } else {
            fichaAtual.getAtributos().setSabedoriaSave(fichaAtual.getAtributos().getSabedoriaMod(), 0);
        }

        Pericia periciaAcrobacia = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Acrobacia")).findFirst().get();

        if(periciaAcrobacia.isProficiente()){
            periciaAcrobacia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.DESTREZA), fichaAtual.getProficiencia());
        } else {
            periciaAcrobacia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.DESTREZA), 0);
        }

        Pericia periciaArcanismo = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Arcanismo")).findFirst().get();

        if(periciaArcanismo.isProficiente()){
            periciaArcanismo.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.INTELIGENCIA), fichaAtual.getProficiencia());
        } else {
            periciaArcanismo.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.INTELIGENCIA), 0);
        }

        Pericia periciaAtletismo = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Atletismo")).findFirst().get();

        if(periciaAtletismo.isProficiente()){
            periciaAtletismo.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.FORCA), fichaAtual.getProficiencia());
        } else {
            periciaAtletismo.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.FORCA), 0);
        }

        Pericia periciaAtuacao = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Atuação")).findFirst().get();

        if(periciaAtuacao.isProficiente()){
            periciaAtuacao.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.CARISMA), fichaAtual.getProficiencia());
        } else {
            periciaAtuacao.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.CARISMA), 0);
        }

        Pericia periciaEnganacao = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Enganação")).findFirst().get();

        if(periciaEnganacao.isProficiente()){
            periciaEnganacao.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.CARISMA), fichaAtual.getProficiencia());
        } else {
            periciaEnganacao.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.CARISMA), 0);
        }


        Pericia periciaFurtividade = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Furtividade")).findFirst().get();

        if(periciaFurtividade.isProficiente()){
            periciaFurtividade.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.DESTREZA), fichaAtual.getProficiencia());
        } else {
            periciaFurtividade.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.DESTREZA), 0);
        }

        Pericia periciaHistoria = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("História")).findFirst().get();

        if(periciaHistoria.isProficiente()){
            periciaHistoria.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.INTELIGENCIA), fichaAtual.getProficiencia());
        } else {
            periciaHistoria.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.INTELIGENCIA), 0);
        }

        Pericia periciaIntimidacao = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Intimidação")).findFirst().get();

        if(periciaIntimidacao.isProficiente()){
            periciaIntimidacao.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.CARISMA), fichaAtual.getProficiencia());
        } else {
            periciaIntimidacao.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.CARISMA), 0);
        }

        Pericia periciaIntuicao = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Intuição")).findFirst().get();

        if(periciaIntuicao.isProficiente()){
            periciaIntuicao.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.SABEDORIA), fichaAtual.getProficiencia());
        } else {
            periciaIntuicao.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.SABEDORIA), 0);
        }

        Pericia periciaInvestigacao = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Investigação")).findFirst().get();

        if(periciaInvestigacao.isProficiente()){
            periciaInvestigacao.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.INTELIGENCIA), fichaAtual.getProficiencia());
        } else {
            periciaInvestigacao.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.INTELIGENCIA), 0);
        }

        Pericia periciaLidarAnimais = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Lidar com Animais")).findFirst().get();

        if(periciaLidarAnimais.isProficiente()){
            periciaLidarAnimais.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.SABEDORIA), fichaAtual.getProficiencia());
        } else {
            periciaLidarAnimais.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.SABEDORIA), 0);
        }

        Pericia periciaMedicina = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Medicina")).findFirst().get();

        if(periciaMedicina.isProficiente()){
            periciaMedicina.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.INTELIGENCIA), fichaAtual.getProficiencia());
        } else {
            periciaMedicina.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.INTELIGENCIA), 0);
        }

        Pericia periciaNatureza = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Natureza")).findFirst().get();

        if(periciaNatureza.isProficiente()){
            periciaNatureza.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.INTELIGENCIA), fichaAtual.getProficiencia());
        } else {
            periciaNatureza.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.INTELIGENCIA), 0);
        }

        Pericia periciaPercepcao = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Percepção")).findFirst().get();

        if(periciaPercepcao.isProficiente()){
            periciaPercepcao.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.SABEDORIA), fichaAtual.getProficiencia());
        } else {
            periciaPercepcao.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.SABEDORIA), 0);
        }

        Pericia periciaPersuasao = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Persuasão")).findFirst().get();

        if(periciaPersuasao.isProficiente()){
            periciaPersuasao.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.CARISMA), fichaAtual.getProficiencia());
        } else {
            periciaPersuasao.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.CARISMA), 0);
        }

        Pericia periciaPrestidigitacao = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Prestidigição")).findFirst().get();

        if(periciaPrestidigitacao.isProficiente()){
            periciaPrestidigitacao.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.DESTREZA), fichaAtual.getProficiencia());
        } else {
            periciaPrestidigitacao.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.DESTREZA), 0);
        }

        Pericia periciaReligiao = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Religião")).findFirst().get();

        if(periciaReligiao.isProficiente()){
            periciaReligiao.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.INTELIGENCIA), fichaAtual.getProficiencia());
        } else {
            periciaReligiao.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.INTELIGENCIA), 0);
        }

        Pericia periciaSobrevivencia = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Sobrevivência")).findFirst().get();

        if(periciaSobrevivencia.isProficiente()){
            periciaSobrevivencia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.SABEDORIA), fichaAtual.getProficiencia());
        } else {
            periciaSobrevivencia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.SABEDORIA), 0);
        }


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

    @PostMapping("/adicionaAtaque/{id}")
    public ResponseEntity addAtaque(@AuthenticationPrincipal Usuario usuario,@RequestBody AtaqueDTO ataque ,@PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.addAtaque(ataque.nome(), ataque.bonus(), ataque.dano());
        fichaService.criaFicha(fichaAtual);

        System.out.println(fichaAtual.getAtaques());

        return ResponseEntity.ok(fichaAtual);
    }

    @GetMapping("/adicionaAtaque/{id}")
    public ResponseEntity addAtaqueGet(@AuthenticationPrincipal Usuario usuario, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PostMapping("/adicionaSpell/{id}")
    public ResponseEntity alteraSpell(@AuthenticationPrincipal Usuario usuario, @RequestBody Spell spell, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.addSpell(spell.getNome(), spell.getDesc(), spell.getTime(), spell.getRange(), spell.getNivel());
        fichaService.criaFicha(fichaAtual);
        return ResponseEntity.ok(fichaAtual);
    }

    @PostMapping("/deletaSpell/{id}")
    public ResponseEntity deletaSpell(@AuthenticationPrincipal Usuario usuario, @RequestBody Spell spell, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaAtual.deleteSpell(spell.getNome(), spell.getDesc(), spell.getTime(), spell.getRange(), spell.getNivel());
        fichaService.criaFicha(fichaAtual);
        return ResponseEntity.ok(fichaAtual);
    }

    @GetMapping("/adicionaSpell/{id}")
    public ResponseEntity getSpell(@AuthenticationPrincipal Usuario usuario, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        fichaService.criaFicha(fichaAtual);
        return ResponseEntity.ok(fichaAtual);
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
        fichaAtual.getAtributos().setForcaSave(mod, bonusProf);

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
        fichaAtual.getAtributos().setDestrezaSave(mod, bonusProf);

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
        fichaAtual.getAtributos().setConstituicaoSave(mod, bonusProf);

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
        fichaAtual.getAtributos().setInteligenciaSave(mod, bonusProf);

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
        fichaAtual.getAtributos().setSabedoriaSave(mod, bonusProf);

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
        fichaAtual.getAtributos().setCarismaSave(mod, bonusProf);

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

    @PatchMapping("/profAcrobacia/{id}")
    public ResponseEntity alteraProfAcrobacia(@AuthenticationPrincipal Usuario usuario, @RequestBody Boolean proficiente, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        Pericia pericia = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Acrobacia")).findFirst().get();
        pericia.setProficiente(proficiente);

        if(pericia.isProficiente()){
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.DESTREZA), fichaAtual.getProficiencia());
        } else {
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.DESTREZA), 0);
        }


        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/profArcanismo/{id}")
    public ResponseEntity alteraProfArcanismo(@AuthenticationPrincipal Usuario usuario, @RequestBody Boolean proficiente, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        Pericia pericia = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Arcanismo")).findFirst().get();
        pericia.setProficiente(proficiente);

        if(pericia.isProficiente()){
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.INTELIGENCIA), fichaAtual.getProficiencia());
        } else {
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.INTELIGENCIA), 0);
        }


        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/profAtletismo/{id}")
    public ResponseEntity alteraProfAtletismo(@AuthenticationPrincipal Usuario usuario, @RequestBody Boolean proficiente, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        Pericia pericia = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Atletismo")).findFirst().get();
        pericia.setProficiente(proficiente);

        if(pericia.isProficiente()){
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.FORCA), fichaAtual.getProficiencia());
        } else {
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.FORCA), 0);
        }


        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/profAtuacao/{id}")
    public ResponseEntity alteraProfAtuacao(@AuthenticationPrincipal Usuario usuario, @RequestBody Boolean proficiente, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        Pericia pericia = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Atuação")).findFirst().get();
        pericia.setProficiente(proficiente);

        if(pericia.isProficiente()){
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.CARISMA), fichaAtual.getProficiencia());
        } else {
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.CARISMA), 0);
        }


        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/profEnganacao/{id}")
    public ResponseEntity alteraProfEnganacao(@AuthenticationPrincipal Usuario usuario, @RequestBody Boolean proficiente, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        Pericia pericia = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Enganação")).findFirst().get();
        pericia.setProficiente(proficiente);

        if(pericia.isProficiente()){
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.CARISMA), fichaAtual.getProficiencia());
        } else {
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.CARISMA), 0);
        }


        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/profFurtividade/{id}")
    public ResponseEntity alteraProfFurtividade(@AuthenticationPrincipal Usuario usuario, @RequestBody Boolean proficiente, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        Pericia pericia = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Furtividade")).findFirst().get();
        pericia.setProficiente(proficiente);

        if(pericia.isProficiente()){
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.DESTREZA), fichaAtual.getProficiencia());
        } else {
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.DESTREZA), 0);
        }


        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/profHistoria/{id}")
    public ResponseEntity alteraProfHistoria(@AuthenticationPrincipal Usuario usuario, @RequestBody Boolean proficiente, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        Pericia pericia = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("História")).findFirst().get();
        pericia.setProficiente(proficiente);

        if(pericia.isProficiente()){
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.INTELIGENCIA), fichaAtual.getProficiencia());
        } else {
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.INTELIGENCIA), 0);
        }


        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/profIntimidacao/{id}")
    public ResponseEntity alteraProfIntimidacao(@AuthenticationPrincipal Usuario usuario, @RequestBody Boolean proficiente, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        Pericia pericia = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Intimidação")).findFirst().get();
        pericia.setProficiente(proficiente);

        if(pericia.isProficiente()){
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.CARISMA), fichaAtual.getProficiencia());
        } else {
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.CARISMA), 0);
        }


        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/profIntuicao/{id}")
    public ResponseEntity alteraProfIntuicao(@AuthenticationPrincipal Usuario usuario, @RequestBody Boolean proficiente, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        Pericia pericia = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Intuição")).findFirst().get();
        pericia.setProficiente(proficiente);

        if(pericia.isProficiente()){
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.SABEDORIA), fichaAtual.getProficiencia());
        } else {
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.SABEDORIA), 0);
        }


        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/profInvestigacao/{id}")
    public ResponseEntity alteraProfInvestigacao(@AuthenticationPrincipal Usuario usuario, @RequestBody Boolean proficiente, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        Pericia pericia = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Investigação")).findFirst().get();
        pericia.setProficiente(proficiente);

        if(pericia.isProficiente()){
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.INTELIGENCIA), fichaAtual.getProficiencia());
        } else {
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.INTELIGENCIA), 0);
        }


        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/profLidarAnimais/{id}")
    public ResponseEntity alteraProfLidarAnimais(@AuthenticationPrincipal Usuario usuario, @RequestBody Boolean proficiente, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        Pericia pericia = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Lidar com Animais")).findFirst().get();
        pericia.setProficiente(proficiente);

        if(pericia.isProficiente()){
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.SABEDORIA), fichaAtual.getProficiencia());
        } else {
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.SABEDORIA), 0);
        }


        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/profMedicina/{id}")
    public ResponseEntity alteraProfMedicina(@AuthenticationPrincipal Usuario usuario, @RequestBody Boolean proficiente, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        Pericia pericia = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Medicina")).findFirst().get();
        pericia.setProficiente(proficiente);

        if(pericia.isProficiente()){
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.INTELIGENCIA), fichaAtual.getProficiencia());
        } else {
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.INTELIGENCIA), 0);
        }


        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/profNatureza/{id}")
    public ResponseEntity alteraProfNatureza(@AuthenticationPrincipal Usuario usuario, @RequestBody Boolean proficiente, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        Pericia pericia = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Natureza")).findFirst().get();
        pericia.setProficiente(proficiente);

        if(pericia.isProficiente()){
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.INTELIGENCIA), fichaAtual.getProficiencia());
        } else {
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.INTELIGENCIA), 0);
        }


        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/profPercepcao/{id}")
    public ResponseEntity alteraProfPercepcao(@AuthenticationPrincipal Usuario usuario, @RequestBody Boolean proficiente, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        Pericia pericia = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Percepção")).findFirst().get();
        pericia.setProficiente(proficiente);

        if(pericia.isProficiente()){
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.SABEDORIA), fichaAtual.getProficiencia());
        } else {
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.SABEDORIA), 0);
        }


        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/profPersuasao/{id}")
    public ResponseEntity alteraProfPersuasao(@AuthenticationPrincipal Usuario usuario, @RequestBody Boolean proficiente, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        Pericia pericia = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Persuasão")).findFirst().get();
        pericia.setProficiente(proficiente);

        if(pericia.isProficiente()){
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.CARISMA), fichaAtual.getProficiencia());
        } else {
                pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.CARISMA), 0);
        }


        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/profPrestidigitacao/{id}")
    public ResponseEntity alteraProfPrestidigitacao(@AuthenticationPrincipal Usuario usuario, @RequestBody Boolean proficiente, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        Pericia pericia = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Prestidigição")).findFirst().get();
        pericia.setProficiente(proficiente);

        if(pericia.isProficiente()){
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.DESTREZA), fichaAtual.getProficiencia());
        } else {
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.DESTREZA), 0);
        }


        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/profReligiao/{id}")
    public ResponseEntity alteraProfReligiao(@AuthenticationPrincipal Usuario usuario, @RequestBody Boolean proficiente, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        Pericia pericia = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Religião")).findFirst().get();
        pericia.setProficiente(proficiente);

        if(pericia.isProficiente()){
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.INTELIGENCIA), fichaAtual.getProficiencia());
        } else {
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.INTELIGENCIA), 0);
        }


        fichaService.criaFicha(fichaAtual);

        return ResponseEntity.ok(fichaAtual);
    }

    @PatchMapping("/profSobrevivencia/{id}")
    public ResponseEntity alteraProfSobrevivencia(@AuthenticationPrincipal Usuario usuario, @RequestBody Boolean proficiente, @PathVariable Long id){
        Ficha fichaAtual = fichaService.buscaPorId(id);
        Pericia pericia = fichaAtual.getPericias().stream().filter(p -> p.getNome().equalsIgnoreCase("Sobrevivência")).findFirst().get();
        pericia.setProficiente(proficiente);

        if(pericia.isProficiente()){
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.SABEDORIA), fichaAtual.getProficiencia());
        } else {
            pericia.calculaMod(fichaAtual.getAtributos().getModificador(TipoAtributo.SABEDORIA), 0);
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
