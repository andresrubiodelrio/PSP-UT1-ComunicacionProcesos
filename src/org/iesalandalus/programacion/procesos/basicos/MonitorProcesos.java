package org.iesalandalus.programacion.procesos.basicos;

import java.util.stream.Stream;

public class MonitorProcesos {
    public static void main(String[] args) {
        System.out.printf("%-10s %-20s %-30s%n",
                "PID", "USUARIO", "COMANDO");

        // Recorre todos los procesos disponibles
        Stream<ProcessHandle> listaProcesos = ProcessHandle.allProcesses();

        listaProcesos.forEach(proceso->{
                    ProcessHandle.Info info=proceso.info();
                    long pid=proceso.pid();
                    String usuario=info.user().orElse("Usuario desconocido");
                    String comando = info.command().orElse("N/A");
                    System.out.printf("%-10d %-20s %-30s%n", pid, usuario, comando);
                });
    }
}