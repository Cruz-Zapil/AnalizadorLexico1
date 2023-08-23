package com.leng.analizador.backEnd.enums.concatenables;

import java.awt.Color;

import com.leng.analizador.backEnd.analizador.controlador.analizador.PYControlador.PyAnalizable;
import com.leng.analizador.frontEnd.Panel1;

public enum ComparacionC {

    IGUAL("=="),
    DIFERENTE("!="),
    MAYOR(">"),
    MENOR("<"),
    MAYOR_IGUAL(">="),
    MENOR_IGUAL("<=");

    private String simbolo;

    private ComparacionC(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return this.simbolo;
    }

    public static ComparacionC getComparation(String cadena) {
        for (ComparacionC a : ComparacionC.values()) {
            if (a.getSimbolo().equals(cadena)) {
                generarToken(cadena);
                return a;
            }
        }
        return null;
    }

   private static void generarToken(String cadena) {
        String cadenaCompa = "[ TK,\" " + cadena + " \" , Comparacion " + "Patron, (" + PyAnalizable.linea + " , "
                + PyAnalizable.columna + ") ]";
        Panel1.setTextReport(cadenaCompa, new Color(31, 97, 141));
    }

}
