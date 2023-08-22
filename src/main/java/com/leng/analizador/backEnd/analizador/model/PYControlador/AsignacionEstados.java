package com.leng.analizador.backEnd.analizador.model.PYControlador;

import java.util.HashMap;
import java.util.Map;

public class AsignacionEstados {

    private Map<Character, Integer> estadosPorCaracter = new HashMap<>();
    private int estadoEnvio;
    private boolean estdoIde = false;

    public AsignacionEstados() {
        estadosPorCaracter.put('\n', 0);
        estadosPorCaracter.put('_', 3);
        estadosPorCaracter.put('.', 4);
        estadosPorCaracter.put('(', 5);
        estadosPorCaracter.put(')', 6);
        estadosPorCaracter.put('\"', 7);
        estadosPorCaracter.put('\'', 8);
        estadosPorCaracter.put('=', 9);
        estadosPorCaracter.put('[', 10);
        estadosPorCaracter.put(']', 11);
        estadosPorCaracter.put(':', 13);
        estadosPorCaracter.put(' ', 14);
        estadosPorCaracter.put('!', 15);
        estadosPorCaracter.put('+', 16);
        estadosPorCaracter.put('-', 17);
        estadosPorCaracter.put('*', 18);
        estadosPorCaracter.put('<', 19);
        estadosPorCaracter.put('>', 20);

        for (char c : "/%".toCharArray()) {
            estadosPorCaracter.put(c, 12);
        }
    }

    public void asignaEstadosEnviado(char caracter) {
        estadoEnvio = Character.isLetter(caracter) ? 1
                : Character.isDigit(caracter) ? 2
                        : estadosPorCaracter.getOrDefault(caracter, -1);

    }

    public Map<Character, Integer> getEstadosPorCaracter() {
        return estadosPorCaracter;
    }

    public void setEstadosPorCaracter(Map<Character, Integer> estadosPorCaracter) {
        this.estadosPorCaracter = estadosPorCaracter;
    }

    public int getEstadoEnvio() {
        return estadoEnvio;
    }

    public void setEstadoEnvio(int estadoEnvio) {
        this.estadoEnvio = estadoEnvio;
    }

}
