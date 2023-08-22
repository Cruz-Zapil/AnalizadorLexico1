package com.leng.analizador.backEnd.enums.simples;

import java.awt.Color;

import com.leng.analizador.frontEnd.Panel1;

public enum SimboloSim {

    //ESPACIO(' ', new int[] { 0, 1, 2, 3, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 }),
    COMILLA_DOBLE('"', new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 }),
    COMILLA_SIMPLE('\'', new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 }),
    SALTO_LINEA('\n', new int[] { 0, 1, 3, 6, 7, 8, 9, 11, 13, 14 }),
    GUION_BAJOS('_', new int[] { 0, 1, 3, 7, 8, 13, 14 }),
    PARENTESIS_ABIERTO('(', new int[] { 1, 2, 5, 6, 7, 8 }),
    PARENTESIS_CIERRE(')', new int[] { 1, 2, 3, 5, 6, 7, 8, 12, 13 }),
    LLAVE_ABIERTA('{', new int[] { 0 }),
    LLAVE_CIERRE('}', new int[] { 0 }),
    CORCHETE_ABIERTO('[', new int[] { 1, 2, 5, 6, 7, 8, 9 }),
    CORCHETE_CIERRE(']', new int[] { 6, 7, 8, 10, 11, 14 }),
    PUNTO_COMA(';', new int[] { 0 }),
    DOS_PUNTOS(':', new int[] { 1, 3, 6, 7, 8, 14 }),
    PUNTO('.', new int[] { 1, 3, 6, 7, 8, 14 }),
    COMA(',', new int[] { 0 });

    private char caracter;
    private int[] estadosPermitidos;

    private SimboloSim(char caracter, int[] estadosPermitidos) {
        this.caracter = caracter;
        this.estadosPermitidos = estadosPermitidos;
    }

    public static SimboloSim obtenerSimboloEnum(char caracter) {
        for (SimboloSim simboloEnum : SimboloSim.values()) {
            if (simboloEnum.caracter == caracter) {
                generarToken(caracter);
                return simboloEnum;
            }
        }
        return null;
    }

    public static void generarToken(char caracter){
        Panel1.setTextReport("[ TK, "+ caracter+" Simbolo]" , new Color(0, 191, 255));
    }

    public int[] obtenerEstadosPermitidos() {
        return estadosPermitidos;
    }
}
