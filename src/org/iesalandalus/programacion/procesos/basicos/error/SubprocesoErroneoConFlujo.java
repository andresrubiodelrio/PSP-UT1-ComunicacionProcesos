package org.iesalandalus.programacion.procesos.basicos.error;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class SubprocesoErroneoConFlujo {
    public static void main(String[] args) {
        // Ejecutamos el proceso DIR
        Process proceso1;
        int c;
        int exitVal;

        try
        {
            proceso1 = new ProcessBuilder("CMD", "/C", "DIRf").start();

            // Mostramos carácter a carácter la salida generada por DIRf
            InputStream is = proceso1.getInputStream();

            while ((c = is.read()) != -1)
                System.out.print((char) c);

            InputStream error=proceso1.getErrorStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(error));
            String linea=null;
            while ((linea=br.readLine())!=null)
            {
                System.out.println("ERROR: " + linea);
            }

            is.close();
            br.close();

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


