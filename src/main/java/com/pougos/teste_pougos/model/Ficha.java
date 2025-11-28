package com.pougos.teste_pougos.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
    @Embedded
    private Atributos atributos;
    @OneToMany(mappedBy = "ficha", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pericia> pericias = new ArrayList<>();
    @Column(nullable = true)
    private int classeArmadura;
    @Column(nullable = true)
    private int iniciativa;
    @Column(nullable = true)
    private int deslocamento;
    @Column(nullable = true)
    private int vida;
    @Column(nullable = true)
    private int vidaMax;
    @Column(nullable = true)
    private int vidaTemp;
    @Column(nullable = true)
    private int cdMagia;
    @Column(nullable = true)
    private String aparencia = "Aparência...";
    @Column(nullable = true)
    private String backgrounds = "Background...";
    @Column(nullable = true)
    private String caracteristicas = "Características...";
    @Column(nullable = true)
    private String idiomas = "Idiomas...";
    @OneToMany(mappedBy = "ficha", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ataque> ataques;
    @OneToMany(mappedBy = "ficha", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Spell> spells;

    @ManyToOne
    private Usuario usuario;

    public Ficha() {
    }

    public Ficha(Usuario usuario){

        this.atributos = new Atributos();
        this.usuario = usuario;
        this.pericias.add(new Pericia("Acrobacia", TipoAtributo.DESTREZA, this));
        this.pericias.add(new Pericia("Arcanismo", TipoAtributo.INTELIGENCIA, this));
        this.pericias.add(new Pericia("Atletismo", TipoAtributo.FORCA, this));
        this.pericias.add(new Pericia("Atuação", TipoAtributo.CARISMA, this));
        this.pericias.add(new Pericia("Enganação", TipoAtributo.CARISMA, this));
        this.pericias.add(new Pericia("Furtividade", TipoAtributo.DESTREZA, this));
        this.pericias.add(new Pericia("História", TipoAtributo.INTELIGENCIA, this));
        this.pericias.add(new Pericia("Intimidação", TipoAtributo.CARISMA, this));
        this.pericias.add(new Pericia("Intuição", TipoAtributo.SABEDORIA, this));
        this.pericias.add(new Pericia("Investigação", TipoAtributo.INTELIGENCIA, this));
        this.pericias.add(new Pericia("Lidar com Animais", TipoAtributo.SABEDORIA, this));
        this.pericias.add(new Pericia("Medicina", TipoAtributo.INTELIGENCIA, this));
        this.pericias.add(new Pericia("Natureza", TipoAtributo.INTELIGENCIA, this));
        this.pericias.add(new Pericia("Percepção", TipoAtributo.SABEDORIA, this));
        this.pericias.add(new Pericia("Persuasão", TipoAtributo.CARISMA, this));
        this.pericias.add(new Pericia("Prestidigição", TipoAtributo.DESTREZA, this));
        this.pericias.add(new Pericia("Religião", TipoAtributo.INTELIGENCIA, this));
        this.pericias.add(new Pericia("Sobrevivência", TipoAtributo.SABEDORIA, this));
        this.ataques = new ArrayList<>();
        this.spells = new ArrayList<>();


    }

    public String getAparencia() {
        return aparencia;
    }

    public void setAparencia(String aparencia) {
        this.aparencia = aparencia;
    }

    public String getBackgrounds() {
        return backgrounds;
    }

    public void setBackgrounds(String backgrounds) {
        this.backgrounds = backgrounds;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public String getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(String idiomas) {
        this.idiomas = idiomas;
    }

    public int getCdMagia() {
        return cdMagia;
    }

    public void setCdMagia(int cdMagia) {
        this.cdMagia = cdMagia;
    }

    public int getVidaMax() {
        return vidaMax;
    }

    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }

    public List<Ataque> getAtaques() {
        return ataques;
    }

    public void setAtaques(List<Ataque> ataques) {
        this.ataques = ataques;
    }

    public List<Spell> getSpells() {
        return spells;
    }

    public void setSpells(List<Spell> spells) {
        this.spells = spells;
    }

    public void addAtaque(String nome, String bonus, String dano){
        Ataque novoAtaque = new Ataque(nome, bonus, dano);
        novoAtaque.setFicha(this);
        ataques.add(novoAtaque);

    }

    public void deletaAtaque(String nome, String bonus, String dano){
        Ataque ataqueParaRemover = null;
        for (Ataque a: ataques){
            if(a.getNome().equalsIgnoreCase(nome) &&
            a.getBonus().equalsIgnoreCase(bonus) &&
            a.getDano().equalsIgnoreCase(dano)){
                ataqueParaRemover = a;
                break;
            }
        }
        if (ataqueParaRemover != null){
            ataques.remove(ataqueParaRemover);
            ataqueParaRemover.setFicha(null);
        }
    }

    public void addSpell(String nome, String desc, String time ,String range, int nivel){
        Spell novoSpell = new Spell(nome, desc, time, range, nivel);
        novoSpell.setFicha(this);
        spells.add(novoSpell);
    }

    public void deleteSpell(String nome, String desc, String time, String range, int nivel){
        Spell spellParaRemover = null;
        for (Spell s : spells) {
            if (s.getNome().equals(nome) &&
                    s.getDesc().equals(desc) &&
                    s.getTime().equals(time) &&
                    s.getRange().equals(range) &&
                    s.getNivel() == nivel) {
                spellParaRemover = s;
                break;
            }
        }

        if (spellParaRemover != null) {
            spells.remove(spellParaRemover);
            spellParaRemover.setFicha(null); // importante para relacionamento JPA
        }
    }

    public List<Pericia> getPericias() {
        return pericias;
    }

    public void setPericias(List<Pericia> pericias) {
        this.pericias = pericias;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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


    public void setValorAtributo(TipoAtributo tipo, int valor){
        atributos.setValor(tipo, valor);
        atributos.setValorModificador(tipo, atributos.getModificador(tipo));

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
