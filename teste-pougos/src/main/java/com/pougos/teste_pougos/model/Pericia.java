package com.pougos.teste_pougos.model;

import jakarta.persistence.Embeddable;

import java.util.EnumMap;

@Embeddable
public class Pericia {

    private int acrobacia = 0;
    private int arcanismo = 0;
    private int atletismo = 0;
    private int atuacao = 0;
    private int enganacao = 0;
    private int furtividade = 0;
    private int historia = 0;
    private int intimidacao = 0;
    private int intuicao = 0;
    private int investigacao = 0;
    private int lidarAnimais = 0;
    private int medicina = 0;
    private int natureza = 0;
    private int percepcao = 0;
    private int persuasao = 0;
    private int prestidigitacao = 0;
    private int religiao = 0;
    private int sobrevivencia = 0;

    public int getAcrobacia() {
        return acrobacia;
    }

    public void setAcrobacia(int acrobacia) {
        this.acrobacia = acrobacia;
    }

    public int getArcanismo() {
        return arcanismo;
    }

    public void setArcanismo(int arcanismo) {
        this.arcanismo = arcanismo;
    }

    public int getAtletismo() {
        return atletismo;
    }

    public void setAtletismo(int atletismo) {
        this.atletismo = atletismo;
    }

    public int getAtuacao() {
        return atuacao;
    }

    public void setAtuacao(int atuacao) {
        this.atuacao = atuacao;
    }

    public int getEnganacao() {
        return enganacao;
    }

    public void setEnganacao(int enganacao) {
        this.enganacao = enganacao;
    }

    public int getFurtividade() {
        return furtividade;
    }

    public void setFurtividade(int furtividade) {
        this.furtividade = furtividade;
    }

    public int getHistoria() {
        return historia;
    }

    public void setHistoria(int historia) {
        this.historia = historia;
    }

    public int getIntimidacao() {
        return intimidacao;
    }

    public void setIntimidacao(int intimidacao) {
        this.intimidacao = intimidacao;
    }

    public int getInvestigacao() {
        return investigacao;
    }

    public void setInvestigacao(int investigacao) {
        this.investigacao = investigacao;
    }

    public int getLidarAnimais() {
        return lidarAnimais;
    }

    public void setLidarAnimais(int lidarAnimais) {
        this.lidarAnimais = lidarAnimais;
    }

    public int getMedicina() {
        return medicina;
    }

    public void setMedicina(int medicina) {
        this.medicina = medicina;
    }

    public int getNatureza() {
        return natureza;
    }

    public void setNatureza(int natureza) {
        this.natureza = natureza;
    }

    public int getIntuicao() {
        return intuicao;
    }

    public void setIntuicao(int intuicao) {
        this.intuicao = intuicao;
    }

    public int getPercepcao() {
        return percepcao;
    }

    public void setPercepcao(int percepcao) {
        this.percepcao = percepcao;
    }

    public int getPersuasao() {
        return persuasao;
    }

    public void setPersuasao(int persuasao) {
        this.persuasao = persuasao;
    }

    public int getPrestidigitacao() {
        return prestidigitacao;
    }

    public void setPrestidigitacao(int prestidigitacao) {
        this.prestidigitacao = prestidigitacao;
    }

    public int getReligiao() {
        return religiao;
    }

    public void setReligiao(int religiao) {
        this.religiao = religiao;
    }

    public int getSobrevivencia() {
        return sobrevivencia;
    }

    public void setSobrevivencia(int sobrevivencia) {
        this.sobrevivencia = sobrevivencia;
    }

    public int getValor(TipoPericia tipo){
        return switch(tipo){
            case ACROBACIA -> acrobacia;
            case ARCANISMO -> arcanismo;
            case ATLETISMO -> atletismo;
            case ATUACAO -> atuacao;
            case ENGANACAO -> enganacao;
            case FURTIVIDADE -> furtividade;
            case HISTORIA -> historia;
            case INTIMIDACAO -> intimidacao;
            case INTUICAO -> intuicao;
            case INVESTIGACAO -> investigacao;
            case LIDAR_COM_ANIMAIS -> lidarAnimais;
            case MEDICINA -> medicina;
            case NATUREZA -> natureza;
            case PERCEPCAO -> percepcao;
            case PERSUASAO -> persuasao;
            case PRESTIDIGITACAO -> prestidigitacao;
            case RELIGIAO -> religiao;
            case SOBREVIVENCIA -> sobrevivencia;
        };
    }

    public void setValor(TipoPericia tipo, int valor, boolean isProficiente, int proficiencia){
        if(isProficiente){
            switch(tipo){
                case ACROBACIA -> acrobacia = valor;
                case ARCANISMO -> arcanismo = valor;
                case ATLETISMO -> atletismo = valor;
                case ATUACAO -> atuacao = valor;
                case ENGANACAO -> enganacao = valor;
                case FURTIVIDADE -> furtividade = valor;
                case HISTORIA -> historia = valor;
                case INTIMIDACAO -> intimidacao = valor;
                case INTUICAO -> intuicao = valor;
                case INVESTIGACAO -> investigacao = valor;
                case LIDAR_COM_ANIMAIS -> lidarAnimais = valor;
                case MEDICINA -> medicina = valor;
                case NATUREZA -> natureza = valor;
                case PERCEPCAO -> percepcao = valor;
                case PERSUASAO -> persuasao = valor;
                case PRESTIDIGITACAO -> prestidigitacao = valor;
                case RELIGIAO -> religiao = valor;
                case SOBREVIVENCIA -> sobrevivencia = valor;
            }
        }
    }

    //    private boolean isProficiente = false;
//
//    private EnumMap<TipoPericia, Integer> valores;
//
//    public EnumMap<TipoPericia, Integer> getValores() {
//        return valores;
//    }
//
//    public boolean isProficiente() {
//        return isProficiente;
//    }
//
//
//    public Pericia(){
//        valores = new EnumMap<>(TipoPericia.class);
//        for (TipoPericia tipo: TipoPericia.values()){
//            valores.put(tipo, 0);
//        }
//    }
//
//    public void setValor(TipoPericia tipo, int valor, boolean isProficiente, int proficiencia){
//        this.isProficiente = isProficiente;
//        if(this.isProficiente){
//            valores.put(tipo, valor + proficiencia);
//        } else {
//            valores.put(tipo, valor);
//        }
//    }
//
//    public int getValor(TipoPericia tipo){
//        return valores.getOrDefault(tipo, 0);
//    }
//
//    public void imprimirPericias(){
//        for(TipoPericia tipo : TipoPericia.values()){
//            int valor = getValor(tipo);
//            System.out.printf("%s : %d %n", tipo.name(), valor);
//        }
//
//    }
//
}
