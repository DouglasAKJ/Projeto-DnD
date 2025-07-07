package com.pougos.teste_pougos.controllers;

import com.pougos.teste_pougos.dto.AtributoRequest;
import com.pougos.teste_pougos.dto.FichaService;
import com.pougos.teste_pougos.dto.NivelRequest;
import com.pougos.teste_pougos.helper.NullCopyProperties;
import com.pougos.teste_pougos.model.Ficha;
import com.pougos.teste_pougos.model.TipoAtributo;
import com.pougos.teste_pougos.repository.FichaRepository;
import org.apache.coyote.Request;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/ficha")
public class FichaController {
    private final FichaService fichaService;
    private final NullCopyProperties beanUtilsBean;

    public FichaController(FichaService fichaService, NullCopyProperties beanUtilsBean) {
        this.fichaService = fichaService;
        this.beanUtilsBean = beanUtilsBean;
    }

    @GetMapping
    public List<Ficha> listaFichas(){
        return fichaService.retornaFicha();
    }

    @GetMapping("/{id}")
    public Ficha getFicha(@PathVariable Long id){
        return fichaService.buscaPorId(id);
    }

    @PostMapping("/criaficha")
    public Ficha criaFicha(){
        Ficha ficha = new Ficha();
        return fichaService.criaFicha(ficha);
    }

    @PostMapping("/deletarFichas")
    public void deletaFichas(){
        fichaService.deletarFichas();
    }

    @PatchMapping("/alteraFicha/{id}")
    public void alteraValor(@RequestBody Ficha ficha,@PathVariable("id") Long id) throws InvocationTargetException, IllegalAccessException {
        Ficha fichaAtual = fichaService.buscaPorId(id);

        beanUtilsBean.copyProperties(fichaAtual, ficha);
        fichaService.criaFicha(fichaAtual);

    }




//    @GetMapping
//    public Ficha criaFicha(){
//        ficha.setValorAtributo(TipoAtributo.DESTREZA, 8);
//        ficha.setValorAtributo(TipoAtributo.FORCA, 20);
//        return ficha;
//    }
//
//    @PostMapping
//    public int testeValores(@RequestBody NivelRequest request){
//        return ficha.defProficiencia(request.getNivel());
//    }
//
//    @PostMapping("/altera-valor")
//    public int alteraValores(@RequestBody AtributoRequest atributo){
//        TipoAtributo tipo = TipoAtributo.valueOf(atributo.getNome().toUpperCase());
//        ficha.setValorAtributo(tipo, atributo.getValor());
//        return ficha.getAtributos().getValor(tipo);
//    }



}
