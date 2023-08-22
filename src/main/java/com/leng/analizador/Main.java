package com.leng.analizador;

import com.leng.analizador.frontEnd.VentanPrincipal;
import com.leng.analizador.frontEnd.graficos.InicioGrafico;

/**
 * Hello world!
 *
 */
public class Main 
{
    public static void main( String[] args )
    {
        new InicioGrafico().insertar("!hola");
           System.out.println( "Hello World!" );
          new VentanPrincipal();
       
    }
}
