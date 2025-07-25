package com.pougos.teste_pougos.dto;

import com.pougos.teste_pougos.model.*;
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
    private int vidaMax;
    private int vidaTemp;
    private int cdMagia;
    private String idiomas;
    private String aparencia;
    private String caracteristicas;
    private String background;
    private UsuarioDTO usuario;
    private List<Pericia> pericias;
    private List<Ataque> ataques;
    private List<Spell> spells;

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
        this.cdMagia = ficha.getCdMagia();
        this.vidaTemp = ficha.getVidaTemp();
        this.vidaMax = ficha.getVidaMax();
        this.background = ficha.getBackgrounds();
        this.aparencia = ficha.getAparencia();
        this.idiomas = ficha.getIdiomas();
        this.caracteristicas = ficha.getCaracteristicas();

        this.usuario = new UsuarioDTO(ficha.getUsuario());
        this.pericias = ficha.getPericias();
        this.ataques = ficha.getAtaques();
        this.spells = ficha.getSpells();
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public String getAparencia() {
        return aparencia;
    }

    public void setAparencia(String aparencia) {
        this.aparencia = aparencia;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public int getCdMagia() {
        return cdMagia;
    }

    public void setCdMagia(int cdMagia) {
        this.cdMagia = cdMagia;
    }

    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }

    public List<Spell> getSpells() {
        return spells;
    }

    public void setSpells(List<Spell> spells) {
        this.spells = spells;
    }

    public List<Ataque> getAtaques() {
        return ataques;
    }

    public void setAtaques(List<Ataque> ataques) {
        this.ataques = ataques;
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
