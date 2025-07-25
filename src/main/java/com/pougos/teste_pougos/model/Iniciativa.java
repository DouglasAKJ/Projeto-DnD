package com.pougos.teste_pougos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "iniciativa")
public class Iniciativa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int iniciativa;
    private String nome;
    private int hp;

    public Iniciativa() {
    }

    public Iniciativa(int iniciativa, String nome, int hp) {
        this.iniciativa = iniciativa;
        this.nome = nome;
        this.hp = hp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIniciativa() {
        return iniciativa;
    }

    public void setIniciativa(int iniciativa) {
        this.iniciativa = iniciativa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
