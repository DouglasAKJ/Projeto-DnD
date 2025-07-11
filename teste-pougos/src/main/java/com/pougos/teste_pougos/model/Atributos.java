package com.pougos.teste_pougos.model;


import jakarta.persistence.*;

import java.util.EnumMap;
@Embeddable
public class Atributos {

    private Integer destreza = 10;
    private Integer forca = 10;
    private Integer inteligencia = 10;
    private Integer constituicao = 10;
    private Integer carisma = 10;
    private Integer sabedoria = 10;

    private int destrezaMod = 0;
    private int forcaMod = 0;
    private int inteligenciaMod = 0;
    private int constituicaoMod = 0;
    private int carismaMod = 0;
    private int sabedoriaMod = 0;

    public Atributos() {
    }

    public int getDestrezaMod() {
        return destrezaMod;
    }

    public void setDestrezaMod() {
        this.destrezaMod = (getDestreza() - 10) / 2;
    }



    public int getForcaMod() {
        return forcaMod;
    }

    public void setForcaMod() {
        this.forcaMod = (getForca() - 10) / 2;
    }

    public int getInteligenciaMod() {
        return inteligenciaMod;
    }

    public void setInteligenciaMod() {
        this.inteligenciaMod = (getInteligencia() - 10) / 2;
    }

    public int getConstituicaoMod() {
        return constituicaoMod;
    }

    public void setConstituicaoMod() {
        this.constituicaoMod = (getConstituicao() - 10) / 2;
    }

    public int getCarismaMod() {
        return carismaMod;
    }

    public void setCarismaMod() {
        this.carismaMod = (getCarisma() - 10) / 2;
    }

    public int getSabedoriaMod() {
        return sabedoriaMod;
    }

    public void setSabedoriaMod() {
        this.sabedoriaMod = (getSabedoria() - 10) / 2;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;

        setDestrezaMod();
    }

    public int getForca() {

        return forca;
    }

    public void setForca(int forca) {
        this.forca = forca;
        setForcaMod();
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
        setInteligenciaMod();
    }

    public int getConstituicao() {

        return constituicao;
    }

    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
        setConstituicaoMod();
    }

    public int getCarisma() {
        return carisma;
    }

    public void setCarisma(int carisma) {
        this.carisma = carisma;
        setCarismaMod();
    }

    public int getSabedoria() {
        return sabedoria;
    }

    public void setSabedoria(int sabedoria) {

        this.sabedoria = sabedoria;
        setSabedoriaMod();
    }

    public int getValor(TipoAtributo tipo){
       return switch (tipo){
            case FORCA -> forca;
            case CARISMA -> carisma;
            case DESTREZA -> destreza;
            case SABEDORIA -> sabedoria;
            case CONSTITUICAO -> constituicao;
            case INTELIGENCIA -> inteligencia;
        };
    }

    public void setValor(TipoAtributo tipo, int valor){
        switch (tipo){
            case FORCA -> forca = valor;
            case CARISMA -> carisma = valor;
            case DESTREZA -> destreza = valor;
            case SABEDORIA -> sabedoria = valor;
            case CONSTITUICAO -> constituicao = valor;
            case INTELIGENCIA -> inteligencia = valor;
        }
    }

    public void setValorModificador(TipoAtributo tipo, int valor){
        switch (tipo){
            case FORCA -> forca = valor;
            case CARISMA -> carisma = valor;
            case DESTREZA -> destreza = valor;
            case SABEDORIA -> sabedoria = valor;
            case CONSTITUICAO -> constituicao = valor;
            case INTELIGENCIA -> inteligencia = valor;
        }
    }


    public int getModificador(TipoAtributo tipo){
        int valor = getValor(tipo);
        return (valor - 10) / 2;
    }


    //
//    private Long id;
//    private EnumMap<TipoAtributo, Integer> valores;
//    private EnumMap<TipoAtributo, Integer> modificadores;
//
//    public EnumMap<TipoAtributo, Integer> getModificadores() {
//        return modificadores;
//    }
//
//    public void setModificadores(EnumMap<TipoAtributo, Integer> modificadores) {
//        this.modificadores = modificadores;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public EnumMap<TipoAtributo, Integer> getValores() {
//        return valores;
//    }
//
//    public void setValores(EnumMap<TipoAtributo, Integer> valores) {
//        this.valores = valores;
//    }
//
//    public Atributos() {
//        valores = new EnumMap<>(TipoAtributo.class);
//        modificadores = new EnumMap<>(TipoAtributo.class);
//        // Inicializa todos com 10 como padrão (modificador +0)
//        for (TipoAtributo tipo : TipoAtributo.values()) {
//            valores.put(tipo, 10);
//            modificadores.put(tipo, 0);
//
//        }
//    }
//
//    public void setValor(TipoAtributo tipo, int valor){
//        valores.put(tipo, valor);
//        setModificador(tipo, valor);
//    }
//
//    public int getValor(TipoAtributo tipo){
//        return valores.getOrDefault(tipo, 10);
//    }
//
//    public void setModificador(TipoAtributo tipo, int valor){
//        modificadores.put(tipo, (valor-10) / 2);
//    }
//
//    public int getModificador(TipoAtributo tipo){
//        return modificadores.getOrDefault(tipo, 0);
//    }
//
//
//
//
//    public void imprimirAtributos() {
//        for (TipoAtributo tipo : TipoAtributo.values()) {
//            int valor = getValor(tipo);
//            int mod = getModificador(tipo);
//            System.out.printf("%s: %d (mod %+d)%n", tipo.name(), valor, mod);
//        }
//    }
}
