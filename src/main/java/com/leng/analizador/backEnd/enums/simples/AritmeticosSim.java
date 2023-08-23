package com.leng.analizador.backEnd.enums.simples;

import java.awt.Color;

import com.leng.analizador.backEnd.analizador.controlador.analizador.PYControlador.PyAnalizable;
import com.leng.analizador.frontEnd.Panel1;

public enum AritmeticosSim {

    SUMA('+'),
    RESTA('-'),
    EXPONENTE('^'),
    MODULO('%'),
    MULTIPLICACION('*'),
    DIVISION('/');

    private char simbolo;
    private int[] estadosPermitidos = new int[] { 0, 1, 3, 6, 7, 8, 9, 11, 13, 14 };

    private AritmeticosSim(char simbolo) {
        this.simbolo = simbolo;
    }

    public static AritmeticosSim obtenerArit(char simboloEnvio) {

        for (AritmeticosSim aritmeticosEnum : AritmeticosSim.values()) {

            if (aritmeticosEnum.simbolo == simboloEnvio) {
                generarToken(String.valueOf(simboloEnvio));
                return aritmeticosEnum;
            }
        }
        return null;
    }

   private static void generarToken(String cadena) {
        String cadenaCompa = "[ TK,\" " + cadena + " \" , Aritmeticos " + "Patron, (" + PyAnalizable.linea + " , "
                + PyAnalizable.columna + ") ]";
        Panel1.setTextReport(cadenaCompa, new Color(31, 97, 141));
    }
    public char getSimbolo() {
        return this.simbolo;
    }

}
