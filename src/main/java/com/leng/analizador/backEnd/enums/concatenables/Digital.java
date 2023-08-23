package com.leng.analizador.backEnd.enums.concatenables;

import java.awt.Color;

import com.leng.analizador.backEnd.analizador.controlador.analizador.PYControlador.PyAnalizable;
import com.leng.analizador.frontEnd.Panel1;

public class Digital {

    public static boolean esDigito(String cadena) {
        if (!cadena.isEmpty()) {

            if (digital(cadena)) {

                String cadenaCompa = "[ TK,\" " + cadena + " \" , int ," + " Patron, (" + PyAnalizable.linea + " , "
                        + PyAnalizable.columna + ") ]";
                Panel1.setTextReport(cadenaCompa, new Color(243, 156, 18));
                return true;

            }
        }
        return false;

    }

    private static boolean digital(String cadena) {

        for (char c : cadena.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;

    }

}
