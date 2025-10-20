package org.iesalandalus.programacion.procesos.basicos.tuberia;

import java.io.*;

/**
 *Ejecuta dos comandos, en el que el cada proceso hijo creado ejecutará uno de ellos con sus respectivos argumentos,
 * y en el que la salida estándar del primero sea la entrada estándar del segundo.
 * El proceso tuberia deberá mostrar por su salida estándar (pantalla) el resultado generado por el segundo proceso hijo,
 * tras lo cual debe mostrar el mensaje: “Finalizada la ejecución”
 * @author Andres
 *
 */
public class Tuberia {

    /**
     * Clase principal del proyecto que genera los procesos que ejecutan cada uno de los comandos
     * @param args No son usados
     */
    public static void main(String[] args)
    {
        try {
            //Comandos a ejecutar
            String comando1="CMD /C tasklist";
            String comando2="CMD /C find \"chrome.exe\"";

            //Runtime r=Runtime.getRuntime();
            //Process p1= r.exec(comando1);
            //Process p2= r.exec(comando2);

            //ProcessBuilder pb1=new ProcessBuilder("CMD", "/C", "tasklist");
            //ProcessBuilder pb2=new ProcessBuilder("CMD", "/C", "find \"chrome.exe\"");

            ProcessBuilder pb1=new ProcessBuilder(comando1.split(" "));
            ProcessBuilder pb2=new ProcessBuilder(comando2.split(" "));

            //Creamos los procesos
            Process p1= pb1.start();
            Process p2= pb2.start();

            //Obtenemos la salida del proceso p1
            InputStream is1=p1.getInputStream();
            InputStreamReader isr1=new InputStreamReader(is1);
            BufferedReader br1=new BufferedReader(isr1);

            //Obtenemos el canal del proceso p2 para escribir
            PrintStream pw=new PrintStream(p2.getOutputStream());

            //Usada para leer del proceso p1
            String linea;


            //Escribimos en el canal del proceso p2 cada línea leída del proceso p1
            while ((linea=br1.readLine())!=null)
            {
                pw.println(linea);
            }
            //Cerramos los buffers
            pw.close();
            br1.close();

            //Leemos el resultado del proceso 2 y lo escribimos en pantalla
            InputStream is2=p2.getInputStream();
            InputStreamReader isr2=new InputStreamReader(is2);
            BufferedReader br2=new BufferedReader(isr2);

            while ((linea=br2.readLine())!=null)
            {
                System.out.println(linea);
            }

            System.out.println("Finalizada la ejecución");


            //Control de errores de los procesos
            InputStream ise1=p1.getErrorStream();
            InputStreamReader isre1=new InputStreamReader(ise1);
            BufferedReader bre1=new BufferedReader(isre1);

            //Control de errores de los procesos
            InputStream ise2=p2.getErrorStream();
            InputStreamReader isre2=new InputStreamReader(ise2);
            BufferedReader bre2=new BufferedReader(isre2);

            //Para mostrar errores
            String line_error;

            while ((line_error=bre1.readLine())!=null)
            {
                System.out.println("ERROR Tuberia proceso 1: "+line_error);
            }

            while ((line_error=bre2.readLine())!=null)
            {
                System.out.println("ERROR Tuberia proceso 2: "+line_error);
            }


            //Cerramos buffer
            br2.close();
            /*bre1.close();
            bre2.close();*/
        }
        catch (IOException ex)
        {
            System.out.println("ERROR Tuberia: IO Exception");
        }

    }
}
