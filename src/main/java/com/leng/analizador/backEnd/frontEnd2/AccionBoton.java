package com.leng.analizador.backEnd.frontEnd2;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import com.leng.analizador.backEnd.analizador.controlador.analizador.Analizable;
import com.leng.analizador.backEnd.frontEnd2.utils.LogicaArchivos;
import com.leng.analizador.frontEnd.Panel1;
import com.leng.analizador.frontEnd.Panel1Escritura;
import com.leng.analizador.frontEnd.VentanPrincipal;
import com.leng.analizador.frontEnd.compnents.ConstructorBotton;

public class AccionBoton implements java.awt.event.ActionListener {

    private Panel1 panel1 = new Panel1();

    @Override
    public void actionPerformed(ActionEvent event) {

        Object fuente = event.getSource();

        if (fuente instanceof ConstructorBotton) {

            ConstructorBotton botones = (ConstructorBotton) event.getSource();

            if (botones.getText().equals("Archivo")) {
                // messaje
                message();

            } else if (botones.getText().equals("Grafico")) {
                System.out.println("Grafico ");
                VentanPrincipal.addPanel(panel1);

            } else if (botones.getText().equals("Play")) {
                /// boton para obtener texto en TextPane
                new Analizable().analizar(Panel1Escritura.getText());

            } else if (botones.getText().equals("Limpiar")) {
                /// limpiar
                Panel1Escritura.setText("");
            } else if (botones.getText().equals("Ayuda")) {

                System.out.println(" help");
            } else if (botones.getText().equals("Acerca")) {
                System.out.println(" acerda de");

            }
        }
    }

    public void message() {
        String[] options = { "Abrir Archivo", "Nuevo", "Cancelar" };
        int choice = JOptionPane.showOptionDialog(
                null,
                "Attencion: ",
                "Seleccione una opción",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                options,
                options[0]);

        if (choice == 0) {
            // Acción para "Abrir Archivo"
            VentanPrincipal.addPanel(panel1);
            Panel1Escritura.setText(new LogicaArchivos().fileChoser());
        } else if (choice == 1) {
            // Acción para "Nuevo"
            VentanPrincipal.addPanel(panel1);
        }
    }
}
