package com.leng.analizador.backEnd.enums.concatenables;

import java.awt.Color;

import com.leng.analizador.frontEnd.Panel1;

public enum AsignacionC {

    IGUAL("="),
    SUMA("+="),
    RESTA("-="),
    MULTIPLICACION("*="),
    DIVISION("/="),
    DECREMENTO("--");

    private String simbolo;

    private AsignacionC(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return this.simbolo;
    }

    public static AsignacionC getAsignacion(String cadena) {
        for (AsignacionC a : AsignacionC.values()) {
            if (a.getSimbolo().equals(cadena)) {
                generarToken(cadena);
                return a;
            }
        }
        return null;
    }

    private static void generarToken(String cadena) {
        String cadenaAsig = "[ TK, " + cadena + " ]";
        Panel1.setTextReport(cadenaAsig, new Color(0, 191, 255));

    }

}
