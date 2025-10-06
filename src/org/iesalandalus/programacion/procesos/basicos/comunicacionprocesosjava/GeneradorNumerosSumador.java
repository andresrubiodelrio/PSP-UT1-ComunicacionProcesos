package org.iesalandalus.programacion.procesos.basicos.comunicacionprocesosjava;

import java.io.*;

public class GeneradorNumerosSumador {
    public static void main(String[] args) {
        try {
            // Nombre de la clase que queremos ejecutar como subproceso

            // Construimos el comando: "java ProcesoHijo argumento1 argumento2"
            ProcessBuilder pb = new ProcessBuilder(
                    "java", "org.iesalandalus.programacion.procesos.basicos.comunicacionprocesosjava.Sumador");

            System.out.println("Variable user.dir: " + System.getProperty("user.dir"));
            pb.directory(new File(System.getProperty("user.dir")+ File.separator + "out" + File.separator + "production" + File.separator + "Ejemplo1"));
            System.out.println("Directorio de trabajo: " + pb.directory());

            // Iniciamos el proceso
            Process proceso = pb.start();

            //Enviamos datos al subproceso
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(proceso.getOutputStream()));

            bw.write("3\n4\nj\n0\n7");
            bw.flush();
            bw.close();

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
