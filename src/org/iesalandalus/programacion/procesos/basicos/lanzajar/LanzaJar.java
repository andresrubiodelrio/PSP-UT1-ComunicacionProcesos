package org.iesalandalus.programacion.procesos.basicos.lanzajar;

import java.io.*;

public class LanzaJar {

    public static void main(String[] args)
    {
        //String ficherojar = "c:" + File.separator + "tmp" + File.separator + "PintaDatos.jar";
        String ficherojar = "jars/PintaDatos.jar";

        //Establecemos el proceso a ejecutar
        ProcessBuilder pb = new ProcessBuilder("java","-jar",ficherojar,"uno","dos");

        //Redirigimos la salida estándar del subproceso a nuestra salida estándar.
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);

        //Redirigimos los errores a fichero
        pb.redirectError(new File("errores/JarError.txt"));

        Process p = null;
        try
        {
            p = pb.start();
            System.out.println("El proceso hijo terminó con salida: "+p.waitFor()); //esperar hasta que finalice

            //Lectura de errores usando un flujo
//            InputStream is=p.getErrorStream();
//            BufferedReader br=new BufferedReader(new InputStreamReader(is));
//
//            String lineaError;
//            while((lineaError=br.readLine())!=null)
//            {
//                System.out.println("ERROR: " + lineaError);
//            }
        }
        catch (IOException | InterruptedException e)
        {
            System.out.println(e.getMessage());
        }


    }

}
