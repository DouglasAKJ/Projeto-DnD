package com.pougos.teste_pougos.dto;

public class AtributoRequest {
    private String nome;
    private int valor;
    private Integer destreza;
    private Integer forca;
    private Integer inteligencia;
    private Integer constituicao;
    private Integer carisma;
    private Integer sabedoria;

    private int destrezaMod = 0;
    private int forcaMod = 0;
    private int inteligenciaMod = 0;
    private int constituicaoMod = 0;
    private int carismaMod = 0;
    private int sabedoriaMod = 0;

    public AtributoRequest() {
    }

    public Integer getDestreza() {
        return destreza;
    }

    public void setDestreza(Integer destreza) {
        this.destreza = destreza;

    }

    public Integer getForca() {
        return forca;
    }

    public void setForca(Integer forca) {
        this.forca = forca;
    }

    public Integer getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(Integer inteligencia) {
        this.inteligencia = inteligencia;
    }

    public Integer getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(Integer constituicao) {
        this.constituicao = constituicao;
    }

    public Integer getCarisma() {
        return carisma;
    }

    public void setCarisma(Integer carisma) {
        this.carisma = carisma;
    }

    public Integer getSabedoria() {
        return sabedoria;
    }

    public void setSabedoria(Integer sabedoria) {
        this.sabedoria = sabedoria;
    }

    public int getDestrezaMod() {
        return destrezaMod;
    }

    public void setDestrezaMod(int destrezaMod) {
        this.destrezaMod = destrezaMod;
    }

    public int getForcaMod() {
        return forcaMod;
    }

    public void setForcaMod(int forcaMod) {
        this.forcaMod = forcaMod;
    }

    public int getInteligenciaMod() {
        return inteligenciaMod;
    }

    public void setInteligenciaMod(int inteligenciaMod) {
        this.inteligenciaMod = inteligenciaMod;
    }

    public int getConstituicaoMod() {
        return constituicaoMod;
    }

    public void setConstituicaoMod(int constituicaoMod) {
        this.constituicaoMod = constituicaoMod;
    }

    public int getCarismaMod() {
        return carismaMod;
    }

    public void setCarismaMod(int carismaMod) {
        this.carismaMod = carismaMod;
    }

    public int getSabedoriaMod() {
        return sabedoriaMod;
    }

    public void setSabedoriaMod(int sabedoriaMod) {
        this.sabedoriaMod = sabedoriaMod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
