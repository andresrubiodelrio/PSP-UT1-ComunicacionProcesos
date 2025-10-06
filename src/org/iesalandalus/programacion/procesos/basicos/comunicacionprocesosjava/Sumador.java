package org.iesalandalus.programacion.procesos.basicos.comunicacionprocesosjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sumador {

    public static void main(String[] args)
    {
        int resultado=0;
        try
        {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String texto;

            System.out.println("Introduce los números a sumar... ");
            while(!(texto=br.readLine()).equals("0"))
            //while ((texto = br.readLine()) != null )
            {
                System.out.println("Texto introducido: " + texto);
                if (isNumeric(texto))
                    resultado+=Integer.parseInt(texto);
                else
                    System.out.println("Error: El número introducido no tiene un formato válido");
            }

            System.out.println(resultado);
            //System.out.println("La suma de " +numero1 + " y " + numero2 + " es " + resultado);
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }


    }

    private static boolean isNumeric(String dato){
        try
        {
            Integer.parseInt(dato);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
}
