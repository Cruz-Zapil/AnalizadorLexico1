package com.leng.analizador.backEnd.enums.concatenables;

public enum SimboloC {

    GUION_BAJOS('_', new int[] { 0, 1, 3, 7, 8, 13, 14 }),
    COMILLA_DOBLE('"', new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 }),
    COMILLA_SIMPLE('\'', new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 });

    private char caracter;
    private int[] estadosPermitidos;

    private SimboloC(char caracter, int[] estadosPermitidos) {
        this.caracter = caracter;
        this.estadosPermitidos = estadosPermitidos;
    }

    public static SimboloC obteSim(char caracter) {
        for (SimboloC simboloEnum : SimboloC.values()) {
            if (simboloEnum.caracter == caracter) {
                return simboloEnum;
            }
        }
        return null;
    }

    public int[] obteEstaPer() {
        return estadosPermitidos;
    }


}
