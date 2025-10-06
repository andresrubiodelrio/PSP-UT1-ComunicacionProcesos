package org.iesalandalus.programacion.procesos.basicos.configuraciones;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class DirectorioTrabajo {
    public static void main(String[] args) {
        try {
            // Ejecutamos el proceso DIR
            // Hereda entrada/salida/error del proceso padre
            ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "DIR");
            Process p = null;

            //Opción 1: Sin cambiar nada
            //En este caso el directorio de trabajo es el mismo que el valor de la variable user.dir
            //Por tanto, pb.directory nos devolverá null porque el proceso se ejecutará en el directorio actual
            System.out.println("Directorio de trabajo: " + pb.directory());
            System.out.println("user.dir variable: " + System.getProperty("user.dir"));
            System.out.println();
            p = pb.inheritIO().start();
            p.waitFor();

            //Opción 2: Se cambia el valor de la variable user.dir pero no el directorio de trabajo.
            System.setProperty("user.dir", System.getProperty("user.home"));
            //Por tanto, pb.directory nos devolverá null porque el proceso se ejecutará en el directorio actual
            System.out.println("Directorio de trabajo: " + pb.directory());
            System.out.println("user.dir variable: " + System.getProperty("user.dir"));
            System.out.println();
            p = pb.inheritIO().start();
            p.waitFor();

            //Opción 4: Se cambia el directorio de trabajo al home del usuario
            pb.directory(new File(System.getProperty("user.home")));
            System.out.println("Directorio de trabajo: " + pb.directory());
            System.out.println("user.dir variable: " + System.getProperty("user.dir"));
            System.out.println();
            p = pb.inheritIO().start();
            p.waitFor();

            //Opción 5: Se cambia el directorio de trabajo al directorio out
            pb.directory(new File("out"));
            System.out.println("Directorio de trabajo: " + pb.directory());
            //System.out.println("user.dir variable: " + System.getProperty("user.dir"));
            System.out.println();
            p = pb.inheritIO().start();
            p.waitFor();


            //Map<String, String> environment = pb.environment();

            // Mostramos la información de las variables de entorno
            Map variablesEntorno = pb.environment();
            System.out.println("Path: " + variablesEntorno.get("Path"));
            System.out.println(variablesEntorno);

            System.out.println("El subproceso finalizó con valor de salida: " + p.waitFor());
        }
        catch (IOException | InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
