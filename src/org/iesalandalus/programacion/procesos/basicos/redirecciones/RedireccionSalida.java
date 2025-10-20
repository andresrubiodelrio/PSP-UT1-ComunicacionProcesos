package org.iesalandalus.programacion.procesos.basicos.redirecciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;

public class RedireccionSalida {
    public static void main(String[] args) {
        try {

            ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "DIR");

            File fLog = new File("salidas/salida.log");
            File fError = new File("errores/error.log");
            pb.redirectOutput(fLog);
            //pb.redirectOutput(ProcessBuilder.Redirect.appendTo(fLog));
            pb.redirectError(fError);

            // Iniciamos el proceso
            Process proceso = pb.start();


            // Esperamos que termine
            int codigoSalida = proceso.waitFor();
            System.out.println("=== Proceso hijo terminó con código: " + codigoSalida);


        }
        catch (IOException | InterruptedException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
