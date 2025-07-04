package com.pougos.teste_pougos.model;

public class Teste {

    public static void main(String[] args) {
        Ficha ficha1 = new Ficha();

        ficha1.getAtributos().setValor(TipoAtributo.FORCA, 20);
        ficha1.getAtributos().setValor(TipoAtributo.DESTREZA, 20);




        //ficha1.getPericias().setValor(TipoPericia.FURTIVIDADE, ficha1.getAtributos().getModificador(TipoAtributo.DESTREZA), true, 2);

        //ficha1.getPericias().imprimirPericias();

       //System.out.println(ficha1.getAtributos().getModificador(TipoAtributo.FORCA));

    }

}
