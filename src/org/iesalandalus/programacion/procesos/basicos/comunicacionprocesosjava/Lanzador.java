package org.iesalandalus.programacion.procesos.basicos.comunicacionprocesosjava;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lanzador {
    public static void main(String[] args) {
        try {
            // Nombre de la clase que queremos ejecutar como subproceso

            // Construimos el comando: "java ProcesoHijo argumento1 argumento2"
            ProcessBuilder pb = new ProcessBuilder(
                    "java", "org.iesalandalus.programacion.procesos.basicos.comunicacionprocesosjava.Lanzado", "arg1", "hola", "240");

            System.out.println("Variable user.dir: " + System.getProperty("user.dir"));
            pb.directory(new File(System.getProperty("user.dir")+ File.separator + "out" + File.separator + "production" + File.separator + "Ejemplo1"));
            System.out.println("Directorio de trabajo: " + pb.directory());

            // Iniciamos el proceso
            Process proceso = pb.start();

            // Capturamos la salida estándar del proceso hijo
            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream()));

            String linea;
            System.out.println("=== Salida del proceso hijo ===");
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }

            // Esperamos que termine
            int codigoSalida = proceso.waitFor();
            System.out.println("=== Proceso hijo terminó con código: " + codigoSalida);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
