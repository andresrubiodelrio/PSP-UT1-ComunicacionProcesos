package org.iesalandalus.programacion.procesos.basicos.lanzajar;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LanzaJarDinamicoParametrosEnFichero {

    public static void main(String[] args) {
        String ficherojar = "jars/PintaDatos.jar";

        // Lee argumentos desde un fichero y los lleva a una lista
        List<String> parametros = new ArrayList<>();

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(new File("datos/FdatosJar.txt")));
            String linea;
            while ((linea = br.readLine()) != null)
                parametros.add(linea);

            br.close();

            //Establecemos el proceso a ejecutar
            ProcessBuilder pb = new ProcessBuilder("java","-jar",ficherojar);
            pb.command().addAll(parametros); // Agregar los argumentos leídos

            //Redirigimos la salida estándar del subproceso a nuestra salida estándar.
            pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            //Redirigimos los errores a fichero
            pb.redirectError(new File("errores/JarErrorDinamico.txt"));

            Process p = pb.start();
            System.out.println("Valor de salida: "+p.waitFor()); //esperar hasta que finalice

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
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
        catch (InterruptedException e)
        {
            System.out.println(e.getMessage());
        }



    }
}
