package org.iesalandalus.programacion.procesos.basicos.lectorescritor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Escritor {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        try
        {
            InputStreamReader isr=new InputStreamReader(System.in);
            BufferedReader bf=new BufferedReader(isr);
            System.out.println("PROCESO HIJO- RECIBIDO VALOR DE ENTRADA");
            String line;

            line=bf.readLine();
            System.out.println("PROCESO HIJO- VALOR DE ENTRADA: " + line);
            int number=Integer.parseInt(line);

            for(int i=number;i<number+10;i++)
            {
                System.out.println("Número: "+i);
            }
            bf.close();
        }
        catch(IOException e)
        {
            System.out.println("ERROR: Error de I/O");
            e.printStackTrace();
        }
    }
}
