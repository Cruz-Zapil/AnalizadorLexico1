package com.leng.analizador.backEnd.analizador.model.PYControlador;

import java.awt.Color;

import com.leng.analizador.frontEnd.Panel1Escritura;

public class PyAnalizable {

    public ControlFuncionTransicion controlFuncionTransicion = new ControlFuncionTransicion();

    // desminuzar cada cadena, saber la linea y la comuna de cada caracter
    private int linea;
    private int columna;
    private String contenido;
    private int indice; // Índice del caracter actual
    private String contenidoVacio;

    public PyAnalizable(String envio) {
        contenido = envio;
        linea = 1;
        columna = 1;
        indice = 0;
    }

    public void avanzar() {

        System.out.println("envio: " + contenido);


        for (indice = 0; indice < contenido.length(); indice++) {
            char caracterActual = contenido.charAt(indice);
            
            // Verificar si el carácter es una nueva línea
            if (caracterActual == '\n') {
                columna = 0; // Reiniciar la columna al comienzo de una nueva línea
                linea++;
            }
            
            // Verificar si el carácter es "#", en cuyo caso se ignora la línea
            if (caracterActual == '#') {

                while (indice < contenido.length() && contenido.charAt(indice) != '\n') {
                  
                    String comentario = contenido.charAt(indice)+"";
                    //// enviando comentarios a la interfaz
                    Panel1Escritura.setTextColor(comentario, new Color(128,128,128));
                  
                    indice++; // Avanzar hasta el final de la línea
                }
                linea++;
                columna = 0; // Reiniciar la columna al comienzo de la siguiente línea
                continue; // Saltar al siguiente caracter
            }
            
            // Incrementar la columna para otros caracteres que no sean '\n'
            columna++;
            
            // Enviar a la función de análisis de función de transición si no es "#"
            controlFuncionTransicion.analizar(caracterActual);
            
            // Verificar si se ha llegado al final del contenido
            if (indice == contenido.length() - 1) {
                controlFuncionTransicion.setEstadoFinal();
            }
        }
    }
    
    public int getLinea() {
        return linea;
    }

    public int getColumna() {
        return columna;
    }

    public String getContenido() {
        return contenido;
    }
}
