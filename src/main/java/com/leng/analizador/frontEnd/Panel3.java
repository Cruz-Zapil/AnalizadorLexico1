package com.leng.analizador.frontEnd;


import javax.swing.JPanel;

import com.leng.analizador.backEnd.frontEnd2.AccionBoton;
import com.leng.analizador.frontEnd.compnents.ConstructorBotton;


import java.awt.Color;


    public class Panel3 extends JPanel {

        private ConstructorBotton[] botones = new ConstructorBotton[6];
        private String[] etiquetas = {"Archivo", "Grafico", "Play", "Limpiar", "Acerca", "Ayuda"};
        private AccionBoton accionBoton = new AccionBoton();
    
        public Panel3( Color textColor, Color buttonColor) {
            this.setLayout(null);
            this.setBounds(0, 0, 600, 40);
    
            setComponentes(textColor, buttonColor);
            this.setVisible(true);
        }
    
        public void setComponentes(Color textColor, Color buttonColor) {
            for (int i = 0; i < botones.length; i++) {
                botones[i] = new ConstructorBotton(etiquetas[i], textColor, buttonColor, Color.BLACK, 0 + (i * 100), 0, accionBoton);
                this.add(botones[i]);
            }
            revalidate();
            repaint();
        }
    }
    
