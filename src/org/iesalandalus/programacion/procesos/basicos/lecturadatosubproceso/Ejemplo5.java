package org.iesalandalus.programacion.procesos.basicos.lecturadatosubproceso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejemplo5 {
    public static void main(String[] args) {
        int exitVal = 0;

        try
        {
            // Crear proceso con argumentos
            ProcessBuilder pb = new ProcessBuilder("ping", "google.com");
            //ProcessBuilder pb = new ProcessBuilder("ping", "-c", "3", "google.com");

            // Iniciar el proceso
            Process proceso = pb.start();

            // Leer la salida
            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream())
            );

            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }

            // Esperar fin del proceso
            exitVal = proceso.waitFor();
            System.out.println("El subproceso finalizó con valor de Salida: " + exitVal);

        }
        catch (IOException | InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
