package org.iesalandalus.programacion.procesos.basicos.creacionprocesos;

import java.io.IOException;

public class Ejemplo3 {
    public static void main(String[] args) {
        Runtime r=Runtime.getRuntime();

        //String comando="NOTEPAD";
        String[] comando1={"CMD", "/C", "DIR"};
        String[] comando2 = {"cmd", "/c", "dir", "/o"};
        // 3ª forma: usando una cadena y dividiéndola para convertirla en una lista
        String[] comando3 =  {"c:/windows/system32/cmd c:\\dir"};
        String[] comando4 =  {"c:/windows/system32/shutdown -s -t 0"};
        try
        {
            Process proceso1=r.exec(comando1);
            System.out.println("PID del nuevo proceso: " + proceso1.pid());

            ProcessHandle.Info proceso1Info=proceso1.info();

            // Mostrar información del proceso
            System.out.println("Información Proceso 1:");
            System.out.println("======================");
            informacionProceso(proceso1Info);


            ProcessBuilder pb = new ProcessBuilder(comando2);
            Process proceso2=pb.start();

            ProcessHandle.Info proceso2Info=proceso2.info();

            // Mostrar información del proceso
            System.out.println("\nInformación Proceso 2:");
            System.out.println("======================");
            informacionProceso(proceso2Info);

            // La expresión regular \s significa partir por los espacios en blanco
            pb = new ProcessBuilder(comando3[0].split("\\s"));
            ProcessHandle.Info proceso3Info=proceso2.info();

            // Mostrar información del proceso
            System.out.println("\nInformación Proceso 3:");
            System.out.println("======================");
            informacionProceso(proceso3Info);

        }
        catch (IOException | SecurityException | NullPointerException | IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        }

    }

    private static void informacionProceso(ProcessHandle.Info info) {
        System.out.println("Sistema Operativo      : " + System.getProperty("os.name"));
        System.out.println("Comando                : " + info.command());
        System.out.println("Argumentos             : " + info.arguments());
        System.out.println("Instante de inicio     : " + info.startInstant());
        System.out.println("Total duración         : " + info.totalCpuDuration());
        System.out.println("Usuario                : " + info.user());
    }
}
