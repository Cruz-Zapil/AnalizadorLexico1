package com.leng.analizador.backEnd.enums.concatenables;

import java.awt.Color;

import com.leng.analizador.backEnd.analizador.controlador.analizador.PYControlador.PyAnalizable;
import com.leng.analizador.frontEnd.Panel1;

public enum ArtimeticosC {

    SUMA("+"),
    RESTA("-"),
    MULTIPLICACION("*"),
    EXPONENTE("**"),
    INCREMENTO("++"),
    DECREMENTO("--");

    private String simbolo;
    //private int[] estadosPermitidos = new int[] { 0, 1, 3, 6, 7, 8, 9, 11, 13, 14 };

    private ArtimeticosC(String simbolo) {
        this.simbolo = simbolo;
    }

    public static ArtimeticosC obteArit(String cadena) {

        for (ArtimeticosC aritme : ArtimeticosC.values()) {
            if (aritme.simbolo.equals(cadena)) {
                generarToken(cadena);
                return aritme;
            }
        }

        return null;

    }

    private static void generarToken(String cadena) {
        String cadenaCompa = "[ TK,\" " + cadena + " \" , Aritmeticos " + "Patron, (" + PyAnalizable.linea + " , "
                + PyAnalizable.columna + ") ]";
        Panel1.setTextReport(cadenaCompa, new Color(31, 97, 141));
    }

}
