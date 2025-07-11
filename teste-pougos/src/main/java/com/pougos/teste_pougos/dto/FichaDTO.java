package com.pougos.teste_pougos.dto;

import com.pougos.teste_pougos.model.Atributos;
import com.pougos.teste_pougos.model.Ficha;
import com.pougos.teste_pougos.model.Pericia;
import com.pougos.teste_pougos.model.Usuario;
import jakarta.persistence.*;

import java.util.List;

public class FichaDTO {
    private Long id;
    private String nome;
    private int level;
    private String classe;
    private String raca;
    private int proficiencia;
    private Atributos atributos;
    private int classeArmadura;
    private int iniciativa;
    private int deslocamento;
    private int vida;
    private int vidaTemp;
    private UsuarioDTO usuario;
    private List<Pericia> pericias;

    public FichaDTO() {
    }

    public FichaDTO(Ficha ficha) {
        this.id = ficha.getId();
        this.nome = ficha.getNome();
        this.level = ficha.getLevel();
        this.classe = ficha.getClasse();
        this.raca = ficha.getRaca();
        this.proficiencia = ficha.getProficiencia();
        this.atributos = ficha.getAtributos();
        this.classeArmadura = ficha.getClasseArmadura();
        this.iniciativa = ficha.getIniciativa();
        this.deslocamento = ficha.getDeslocamento();
        this.vida = ficha.getVida();
        this.vidaTemp = ficha.getVidaTemp();
        this.usuario = new UsuarioDTO(ficha.getUsuario());
        this.pericias = ficha.getPericias();
    }


    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioDTO usuario) {
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getProficiencia() {
        return proficiencia;
    }

    public void setProficiencia(int proficiencia) {
        this.proficiencia = proficiencia;
    }

    public Atributos getAtributos() {
        return atributos;
    }

    public void setAtributos(Atributos atributos) {
        this.atributos = atributos;
    }

    public List<Pericia> getPericias() {
        return pericias;
    }

    public void setPericias(List<Pericia> pericias) {
        this.pericias = pericias;
    }

    public int getClasseArmadura() {
        return classeArmadura;
    }

    public void setClasseArmadura(int classeArmadura) {
        this.classeArmadura = classeArmadura;
    }

    public int getIniciativa() {
        return iniciativa;
    }

    public void setIniciativa(int iniciativa) {
        this.iniciativa = iniciativa;
    }

    public int getDeslocamento() {
        return deslocamento;
    }

    public void setDeslocamento(int deslocamento) {
        this.deslocamento = deslocamento;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVidaTemp() {
        return vidaTemp;
    }

    public void setVidaTemp(int vidaTemp) {
        this.vidaTemp = vidaTemp;
    }
}
