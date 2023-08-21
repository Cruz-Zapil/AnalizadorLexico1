package com.leng.analizador.backEnd.analizador.controlador.analizador.PYControlador;

import com.leng.analizador.backEnd.enums.concatenables.ArtimeticosC;
import com.leng.analizador.backEnd.enums.concatenables.AsignacionC;
import com.leng.analizador.backEnd.enums.concatenables.ComparacionC;
import com.leng.analizador.backEnd.enums.concatenables.SimboloC;
import com.leng.analizador.backEnd.enums.simples.AritmeticosSim;
import com.leng.analizador.backEnd.enums.simples.SimboloSim;

public class ControlFuncionTransicion {

    private int estadoPrincipal = 0;

    private AsignacionEstados asignaEstados = new AsignacionEstados();
    private Concatenacion concatenacion = new Concatenacion();
    private String cadenaPrincipa = "";
    private boolean cabioEstadoAnterior = true;
    private boolean estadoFinal = false;

    public ControlFuncionTransicion() {
    }

    private boolean validarEstadoPrincipal(int... estadosPermitidos) {
        for (int estado : estadosPermitidos) {
            if (estadoPrincipal == estado) {
                return true;
            }
        }
        System.out.println(" ***** error lexico ******:  " + cadenaPrincipa);
        return false;
    }

    public void analizar(char caracter) {

        asignaEstados.asignaEstadosEnviado(caracter);
        estadoPrincipal = asignaEstados.getEstadoEnvio();

        if (concatenacion.comillas(estadoPrincipal)) {

            cadenaPrincipa += caracter;
            cabioEstadoAnterior = false;

        } else {

            //// analiza si es concatenable

            if (concatenacion.esConcatenable(estadoPrincipal) || caracter == ' ' || caracter == '\n') {
                /// es concatenble
                /// analizar si el estado anterior es cambio de estado

                if (cabioEstadoAnterior) {
                    cadenaPrincipa += caracter;
                    cabioEstadoAnterior = false;
                } else {

                    if (concatenacion.esEstadoConcatenable(estadoPrincipal)) {
                        //// si es concatenable se va concatenar:
                        cadenaPrincipa += caracter;
                        cabioEstadoAnterior = false;
                        System.out.println(" se va concatenar: " + cadenaPrincipa);

                    } else {
                        //// es concatenable pero no se puede concatenar con el estado anterior
                        //// entonces es un cambio de estado
                        System.out.println(" cambio de estado: ");
                        if (new Conector().conectar(cadenaPrincipa)) {
                            cadenaPrincipa = "";
                        } else if (ArtimeticosC.obteArit(cadenaPrincipa) != null) {
                            cadenaPrincipa = "";
                        } else if (AsignacionC.getAsignacion(cadenaPrincipa) != null) {
                            cadenaPrincipa = "";
                        } else if (ComparacionC.getComparation(cadenaPrincipa) != null) {
                            cadenaPrincipa = "";
                        }
                        cabioEstadoAnterior = true;
                    }

                }

            } else {
                //// no, no es concatenable
                /// son enums simples no necesitan concatencaion
                System.out.println(" no es concatenable: " + caracter);
                if (SimboloSim.obtenerSimboloEnum(caracter) != null) {
                    cadenaPrincipa = "";
                    cabioEstadoAnterior = true;

                } else if (AritmeticosSim.obtenerArit(caracter) != null) {
                    cadenaPrincipa = "";
                    cabioEstadoAnterior = true;
                }
            }
        }
        concatenacion.setEstadoGuardado(estadoPrincipal);

    }

    public String cadenaPrincipal() {
        return cadenaPrincipa;
    }

    public void setEstadoFinal() {
        estadoFinal = true;
    }
}
