package com.leng.analizador.frontEnd.graficos;

import com.leng.analizador.backEnd.frontEnd2.utils.LogicaArchivos;

public class InicioGrafico {
    private Nodos nodoInicial = new Nodos(); 

    public void insertar(String cadena) {
        
        Nodos nodoActual = nodoInicial;

        char[] caracteres = cadena.toCharArray();

        for (char caracter : caracteres) {
            Nodos nuevoNodo = new Nodos();
            nuevoNodo.pasarCaracter(caracter);
            
            nodoActual.setSiguiente(nuevoNodo);
            nodoActual = nuevoNodo;
        }

        nodoActual.setDobleElipse(true);
        
        nodoInicial.graficar( LogicaArchivos.lecturaGraficos+"/"+cadena+".jpg");
    }
}