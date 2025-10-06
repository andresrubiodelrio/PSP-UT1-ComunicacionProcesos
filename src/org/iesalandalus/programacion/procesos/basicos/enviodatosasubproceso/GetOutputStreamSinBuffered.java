package org.iesalandalus.programacion.procesos.basicos.enviodatosasubproceso;

import java.io.*;

public class GetOutputStreamSinBuffered {
    public static void main(String[] args) {
        try {
            String palabraABuscar = "ejemplo";

            String comandoWindows = "cmd.exe /c findstr /i \"" + palabraABuscar + "\"";

            ProcessBuilder pb = new ProcessBuilder(comandoWindows.split(" "));
            Process proceso = pb.start();

            // Escribimos en la entrada del proceso
            OutputStream os = proceso.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(os), true);

            writer.println("Hola desde Java!");
            writer.println("Esto es un mensaje enviado al proceso.");
            writer.println("Hola Windows!");
            writer.println("Esta es una línea de texto de ejemplo.\n");
            writer.println("Aquí hay otra línea.");
            writer.println("Buscamos la palabra 'ejemplo' en esta entrada.\n");
            writer.println("Probando getOutputStream() con PrintWriter");

            writer.close(); // cerramos para que cat sepa que no hay más entrada

            //Gestionamos los posibles errores
            InputStream error=proceso.getErrorStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(error));
            String linea=null;
            while ((linea=br.readLine())!=null)
            {
                System.out.println("ERROR: " + linea);
            }

            // Ahora leemos la salida (stdout) del proceso
            BufferedReader lector = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream()));

            System.out.println("=== SALIDA DEL PROCESO ===");
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }

            int exitValue=proceso.waitFor();
            System.out.println("Proceso finalizó con código: " + exitValue);

        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
