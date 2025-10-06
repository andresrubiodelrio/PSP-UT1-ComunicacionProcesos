package org.iesalandalus.programacion.procesos.basicos.comunicacionprocesosjava;

public class Lanzado {
    public static void main(String[] args)
    {

        System.out.println("Hola, soy el proceso hijo.");
        System.out.println("Recibí " + args.length + " argumentos:");

        for (String arg : args)
        {
            System.out.println(" - " + arg);
        }

        System.out.println("Proceso hijo finalizó correctamente.");
    }
}
