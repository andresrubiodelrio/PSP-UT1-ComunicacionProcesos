package org.iesalandalus.programacion.procesos.basicos.comunicacionprocesosjava;

import java.io.*;

public class ProcesoPadreProcessBuilderRedirect {
    public static void main(String[] args) {
        try {
            // Nombre de la clase que queremos ejecutar como subproceso

            ProcessBuilder pb = new ProcessBuilder(
                    "java", "org.iesalandalus.programacion.procesos.basicos.comunicacionprocesosjava.ProcesoHijo");

            System.out.println("Variable user.dir: " + System.getProperty("user.dir"));
            pb.directory(new File(System.getProperty("user.dir")+ File.separator + "out" + File.separator + "production" + File.separator + "Ejemplo1"));
            System.out.println("Directorio de trabajo: " + pb.directory());

            //los datos de entrada están en un fichero
            File entradaDeDatos=new File("datos/DatosEjemplo.txt");
            pb.redirectInput(ProcessBuilder.Redirect.from(entradaDeDatos));

            //salida a consola
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);

            //la salida de error a fichero
            File fError=new File("datos/errores.txt");
            pb.redirectError(ProcessBuilder.Redirect.to(fError));

            // Iniciamos el proceso
            Process proceso = pb.start();

            // Esperamos que termine
            int codigoSalida = proceso.waitFor();
            System.out.println("=== Proceso hijo terminó con código: " + codigoSalida);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
