package com.leng.analizador.backEnd.enums;

public enum Constantes {

    ENTERO("int"),
    DECIMAL("double"),
    CADENA("String"),
    CARACTER("char"),
    BOOLEANO("boolean");

    private String simbolo;

    private Constantes(String simbolo) {
        this.simbolo = simbolo;
    }   

    public String getSimbolo() {
        return this.simbolo;
    }

    public static Constantes getConstante(String simbolo) {
        for (Constantes a : Constantes.values()) {
            if (a.getSimbolo().equals(simbolo)) {
                return a;
            }
        }
        return null;
    }

    
    
}
