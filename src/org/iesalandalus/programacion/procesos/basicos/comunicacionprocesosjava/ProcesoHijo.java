package org.iesalandalus.programacion.procesos.basicos.comunicacionprocesosjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcesoHijo {
    public static void main(String[] args)
    {
        String texto;
        //Esperamos una lectura desde la entrada estandar asociando un flujo
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(in);

        try
        {
            System.out.println("Introduce una cadena...");
            texto=br.readLine();
            System.out.println("Cadena introducida: " + texto);
            in.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
