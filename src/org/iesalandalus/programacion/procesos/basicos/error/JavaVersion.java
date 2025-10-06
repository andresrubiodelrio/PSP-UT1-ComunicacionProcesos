package org.iesalandalus.programacion.procesos.basicos.error;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JavaVersion {

    public static void main(String[] args)
    {
        try
        {
            // ejecutamos java -version
            ProcessBuilder pb = new ProcessBuilder("java", "-version");
            Process p= pb.start();

            InputStream err=p.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(err));

            String linea;
            while ((linea=br.readLine())!=null)
            {
                System.out.println(linea);
            }

            br.close();
            err.close();
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }

    }
}
