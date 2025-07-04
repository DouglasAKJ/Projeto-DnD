package com.pougos.teste_pougos.model;

import jakarta.persistence.*;

import java.util.EnumMap;
import java.util.List;
@Entity
@Table(name = "fichas")
public class Ficha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //Informações do Usuário
    private String nome;
    @Column(nullable = true)
    private int level;
    private String classe;
    private String raca;
    @Column(nullable = true)
    private int proficiencia;
    private Atributos atributos;
    private Pericia pericias;
    @Column(nullable = true)
    private int classeArmadura;
    @Column(nullable = true)
    private int iniciativa;
    @Column(nullable = true)
    private int deslocamento;
    @Column(nullable = true)
    private int vida;
    @Column(nullable = true)
    private int vidaTemp;



    public Ficha(){
        this.atributos = new Atributos();
        this.pericias = new Pericia();
        this.iniciativa = atributos.getModificador(TipoAtributo.DESTREZA);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getClasseArmadura() {
        return classeArmadura;
    }

    public void setClasseArmadura(int classeArmadura) {
        this.classeArmadura = classeArmadura;
    }

    public int getIniciativa() {
        return atributos.getModificador(TipoAtributo.DESTREZA);
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLevel() {
        return defProficiencia(level);
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


    public Pericia getPericias() {
        return pericias;
    }

    public void setPericias(Pericia pericias){
        this.pericias = pericias;
    }

    public void setValorAtributo(TipoAtributo tipo, int valor){
        atributos.setValor(tipo, valor);

    }

    public int defProficiencia(int level){
        if (level <= 4){
            proficiencia = 2;
        } else if(level <= 8){
            proficiencia = 3;
        } else if(level <= 12){
            proficiencia = 4;
        } else if(level <= 16){
            proficiencia = 5;
        } else {
            proficiencia = 6;
        }
        return proficiencia;
    }

    //Informações de perícias



}
