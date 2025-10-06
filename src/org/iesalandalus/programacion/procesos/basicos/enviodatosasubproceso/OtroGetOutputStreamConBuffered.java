package org.iesalandalus.programacion.procesos.basicos.enviodatosasubproceso;

import java.io.*;

public class OtroGetOutputStreamConBuffered
{
    public static void main(String[] args)
    {
        Process proceso = null;

        try{

            proceso = new ProcessBuilder("CMD", "/C", "DATE").start();

            //enviar datos a DATE
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(proceso.getOutputStream()));
            bw.write("12-03-25");
            bw.flush(); //vacia el buf
            bw.close(); // Cerramos la escritura para indicar que no hay más datos


            // Ahora leemos la salida del proceso
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream()));

            String linea;
            System.out.println("=== SALIDA DEL PROCESO ===");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();

            // COMPROBACION DE ERROR - 0 bien - 1 mal
            int exitVal = proceso.waitFor();
            System.out.println("Proceso finalizó con código: " + exitVal);


            // OBTENER LOS POSIBLES ERRORES
            InputStream er = proceso.getErrorStream();
            BufferedReader brer = new BufferedReader(new InputStreamReader(er));
            String liner = null;
            while ((liner = brer.readLine()) != null)
                System.out.println("ERROR >" + liner);

        }
        catch (IOException | InterruptedException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
