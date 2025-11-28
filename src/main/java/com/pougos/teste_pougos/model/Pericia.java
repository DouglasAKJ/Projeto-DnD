package com.pougos.teste_pougos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.EnumMap;

@Entity
public class Pericia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private boolean isProficiente;
    private boolean isExpertise;
    @Column
    private int valor;

    @Enumerated(EnumType.STRING)
    private TipoAtributo tipoAtributo;

    @JsonIgnore
    @ManyToOne
    private Ficha ficha;

    public Pericia(String nome, TipoAtributo tipoAtributo, Ficha ficha) {
        this.nome = nome;
        this.valor = 0;
        this.tipoAtributo = tipoAtributo;
        this.ficha = ficha;
    }

    public void calculaMod(int mod, int bonusProf){
        int novoValor = mod + (isProficiente ? bonusProf : 0);
        if (this.valor != novoValor) {
            this.valor = novoValor;
        }
    }

    public boolean isExpertise() {
        return isExpertise;
    }

    public void setExpertise(boolean expertise) {
        isExpertise = expertise;
    }

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public TipoAtributo getTipoAtributo() {
        return tipoAtributo;
    }

    public void setTipoAtributo(TipoAtributo tipoAtributo) {
        this.tipoAtributo = tipoAtributo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public boolean isProficiente() {
        return isProficiente;
    }

    public void setProficiente(boolean proficiente) {
        isProficiente = proficiente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pericia() {
    }

}
