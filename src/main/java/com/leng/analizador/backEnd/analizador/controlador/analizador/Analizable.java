package com.leng.analizador.backEnd.analizador.controlador.analizador;


import com.leng.analizador.backEnd.analizador.controlador.analizador.PYControlador.PyAnalizable;

public class Analizable {

    /*** leer archivos y enviar */
    public void analizar(String envio) {           

        if(!envio.isBlank()){
            new PyAnalizable(envio).avanzar();
        }
        
    }

}
