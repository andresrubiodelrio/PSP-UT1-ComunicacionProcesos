package org.iesalandalus.programacion.procesos.basicos.creacionprocesos;

import java.io.IOException;

public class Ejemplo1 {
    public static void main(String[] args) {

        creaProcesoNotePadProcessBuilder();
        creaProcesoNotePadRuntime();
    }

    private static void creaProcesoNotePadProcessBuilder()
    {
        ProcessBuilder pb=new ProcessBuilder("NOTEPAD");
        try
        {
            Process proceso1=pb.start();
            System.out.println("PID del nuevo proceso: " + proceso1.pid());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }

    private static void creaProcesoNotePadRuntime()
    {
        try
        {
            Process proceso1=Runtime.getRuntime().exec("NOTEPAD");
            System.out.println("PID del nuevo proceso: " + proceso1.pid());
        }
        catch (IOException | SecurityException e)
        {
            System.out.println(e.getMessage());
        }
        catch (NullPointerException | IllegalArgumentException e)
        {
            System.out.println("ERROR: El comando especificado como parámetro es nulo o vacío.");
        }

    }
}
