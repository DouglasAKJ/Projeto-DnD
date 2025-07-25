package com.pougos.teste_pougos.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "spells")
public class Spell {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int nivel;
    private String nome;

    @Lob
    @Column
    private String desc;
    private String time;
    private String range;

    @JsonIgnore
    @ManyToOne
    private Ficha ficha;

    public Ficha getFicha() {
        return ficha;
    }

    public void setFicha(Ficha ficha) {
        this.ficha = ficha;
    }

    public Spell(String nome, String desc, String time, String range, int nivel) {
        this.nome = nome;
        this.desc = desc;
        this.time = time;
        this.range = range;
        this.nivel = nivel;
    }

    public Spell(int nivel, String nome, String desc, String range) {
        this.nivel = nivel;
        this.nome = nome;
        this.desc = desc;
        this.range = range;
    }

    public Spell() {
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }
}
