package com.leng.analizador.backEnd.enums.simples;

import java.awt.Color;

import com.leng.analizador.frontEnd.Panel1;

public enum AritmeticosSim {

    SUMA('+'),
    RESTA('-'),
    EXPONENTE('^'),
    MODULO('%'),
    MULTIPLICACION('*'),
    DIVISION('/');

    

    private char simbolo;
    private int [] estadosPermitidos = new int[] { 0, 1, 3, 6, 7, 8, 9, 11, 13, 14 };

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

    public static void generarToken(String cadena){
        
        String cadenaAritmetico = "[ TK, " + cadena + " Artimeticos ]";
        Panel1.setTextReport(cadenaAritmetico, new Color(0, 191, 255));

    }



        public char getSimbolo() {
        return this.simbolo;
    }

}
