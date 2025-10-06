package org.iesalandalus.programacion.procesos.basicos.enviodatosasubproceso;

import java.io.*;

public class GetOutputStreamConBuffered {
        public static void main(String[] args) {
            try {
                // Palabra a buscar
                String palabraABuscar = "ejemplo";

                // Comando a ejecutar en Windows. 'findstr' busca la palabra en la entrada.
                String comandoWindows = "cmd.exe /c findstr /i \"" + palabraABuscar + "\"";

                ProcessBuilder pb = new ProcessBuilder(comandoWindows.split(" "));
                Process proceso = pb.start();

                // Abrimos el OutputStream para enviarle datos al proceso
                OutputStream os = proceso.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os));

                // Escribimos algunas líneas
                writer.write("Hola Windows!");
                writer.newLine();
                writer.write("Esta es una línea de texto de ejemplo.\n");
                writer.write("Aquí hay otra línea.\n");
                writer.newLine();
                writer.write("Buscamos la palabra 'ejemplo' en esta entrada.\n");
                writer.newLine();
                writer.write("Probando getOutputStream() con BufferedWriter");
                writer.newLine();
                writer.flush(); // aseguramos que los datos viajen al proceso

                writer.close(); // cerramos para indicar que no hay más entrada

                //Gestionamos los posibles errores
                InputStream error=proceso.getErrorStream();
                BufferedReader br=new BufferedReader(new InputStreamReader(error));
                String linea=null;
                while ((linea=br.readLine())!=null)
                {
                    System.out.println("ERROR: " + linea);
                }

                // Ahora leemos la salida del proceso
                BufferedReader lector = new BufferedReader(
                        new InputStreamReader(proceso.getInputStream()));

                System.out.println("=== SALIDA DEL PROCESO ===");
                while ((linea = lector.readLine()) != null) {
                    System.out.println(linea);
                }

                proceso.waitFor();
                System.out.println("Proceso finalizó con código: " + proceso.exitValue());

            }
            catch (IOException | InterruptedException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }

