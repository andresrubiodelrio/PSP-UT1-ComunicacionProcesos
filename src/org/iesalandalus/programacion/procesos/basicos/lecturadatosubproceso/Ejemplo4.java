package org.iesalandalus.programacion.procesos.basicos.lecturadatosubproceso;

import java.io.IOException;
import java.io.InputStream;

public class Ejemplo4 {
    public static void main(String[] args) {
        // Ejecutamos el proceso DIR
        Process proceso1;
        int c;
        int exitVal;

        try
        {
            proceso1 = new ProcessBuilder("CMD", "/C", "DIR").start();

            // Mostramos carácter a carácter la salida generada por DIR
            InputStream is = proceso1.getInputStream();

            while ((c = is.read()) != -1)
                System.out.print((char) c);

            is.close();


            // COMPROBACIÓN DE ERROR - 0 bien - DISTINTO DE 0 mal
            exitVal = proceso1.waitFor(); // recoge la salida de System.exit()
            System.out.println("El subproceso finalizó con valor de Salida: " + exitVal);

        }
        catch (IOException | InterruptedException ex)
        {
            System.out.println(ex.getMessage());
        }





    }
}


