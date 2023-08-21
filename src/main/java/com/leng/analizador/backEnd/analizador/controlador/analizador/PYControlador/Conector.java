package com.leng.analizador.backEnd.analizador.controlador.analizador.PYControlador;

import java.awt.Color;

import com.leng.analizador.backEnd.enums.concatenables.Keywords;
import com.leng.analizador.frontEnd.Panel1;

public class Conector {

    public boolean conectar(String cadenaPrincipal) {

        if (!cadenaPrincipal.isEmpty()) {

            if (kW(cadenaPrincipal)) {

                if (Keywords.probandoKW(cadenaPrincipal)) {

                    String cadenaKW = "[ KW  " + cadenaPrincipal + " ]";
                    Panel1.setTextReport(cadenaKW, new Color(128, 0, 128));
                    return true;                    
                  //  Panel1Escritura.setTextColor(cadenaPrincipal, new Color(128, 0, 128));
                } else {

                    String cadenaID = "[ ID " + cadenaPrincipal + " ]";
                    Panel1.setTextReport(cadenaID, Color.WHITE);
                    return true;

                 //   Panel1Escritura.setTextColor(cadenaPrincipal, new Color(0, 0, 0));

                }
            } else {
                System.out.println(" otro");
                return false;
            
            }

        }
        return false;

    }

    public boolean kW(String cadena) {

        boolean contineLetter = false;
        for (int i = 0; i < cadena.length(); i++) {
            if (Character.isLetter(cadena.charAt(i)) || cadena.charAt(i) == '_') {
                // Si encuentra un carácter no letra, retorna falso.
                contineLetter = true;

            }
        }
        return contineLetter;

    }
}