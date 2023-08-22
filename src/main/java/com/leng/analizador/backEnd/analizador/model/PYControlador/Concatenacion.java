package com.leng.analizador.backEnd.analizador.model.PYControlador;

public class Concatenacion {

    private int estadoAnterior = 0, estadoEnvio;

    private int comillaSimple = 0, comillaDoble = 0;

    ///// estado enviado: ****
    private int estadoGuardado = 0;
    private int[] estadosConctenable = { 1, 2, 3, 9, 15, 16, 17, 18, 19, 20 };

    /*********************************
     * 
     * @param estadoActual
     * @return
     */
    //// analiza si la variable es concatenable
    public boolean esConcatenable(int estadoActual) {

        for (int estados : estadosConctenable) {
            if (estadoActual == estados) {
                return true;
            }
        }
        return false;
    }

    public boolean esEstadoConcatenable(int estadoEnvio) {

        //// compara el estado envio si es concatenable con el estado guardado
        switch (estadoEnvio) {
            case 0:
                return false;

            case 1:
                return validarEstadoPrincipal(new int[] { 1, 3 });
            case 2:
                return validarEstadoPrincipal(new int[] { 1, 2, 3, 4 });

            case 3:
                return validarEstadoPrincipal(new int[] { 1, 3 });

            case 9:
                return validarEstadoPrincipal(9);

            case 15:
                return validarEstadoPrincipal(9);

            case 16:
                return validarEstadoPrincipal(9, 16);

            case 17:
                return validarEstadoPrincipal(9, 17);

            case 18:
                return validarEstadoPrincipal(9, 18);

            case 19:
                return validarEstadoPrincipal(9);
            case 20:
                return validarEstadoPrincipal(9);

            default:
                System.out.println(" *****cambio de estado ***** ");
                return false;
        }

    }

    private boolean validarEstadoPrincipal(int... estadosPermitidos) {
        for (int estado : estadosPermitidos) {
            if (estadoGuardado == estado) {
                return true;
            }
        }
        return false;

    }

    public void setEstadoGuardado(int estadoGuardado) {
        this.estadoGuardado = estadoGuardado;
    }

    public boolean comillas(int estado) {
        if (estado == 7) {
            comillaDoble++;
            System.out.println("comilla doble: " + comillaDoble);

        } else if (estado == 8) {
            comillaSimple++;
            System.out.println("comilla simple: " + comillaSimple);

        }

        if (comillaDoble == 1) {
            // System.out.println(" estamos en comilla doble_: se seguira la concatenancion
            // ");
            return true;
        } else if (comillaSimple == 1) {
            // System.out.println(" estamos en comilla simple_: se seguira la concatenancion
            // ");
            return true;
        } else if (comillaDoble == 2) {
            comillaDoble = 0;
            // System.out.println(" ya no se seguira la concatenancion cierre de comilla
            // doble");
            return true;

        } else if (comillaSimple == 2) {
            comillaSimple = 0;
            // System.out.println(" ya no se seguira la concatenancion cierre de comilla
            // simple ");
            return true;
        }
        return false;
    }
}
