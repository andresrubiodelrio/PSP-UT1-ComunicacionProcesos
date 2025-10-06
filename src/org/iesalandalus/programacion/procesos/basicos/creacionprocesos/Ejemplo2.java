package org.iesalandalus.programacion.procesos.basicos.creacionprocesos;

import java.io.IOException;

public class Ejemplo2 {
    public static void main(String[] args) {
        Runtime r=Runtime.getRuntime();

        String [] comando={"NOTEPAD"};
        try
        {
            Process proceso1=r.exec(comando);
            ProcessHandle.Info proceso1Info=proceso1.info();

            // Mostrar información del proceso
            informacionProceso(proceso1Info);


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
