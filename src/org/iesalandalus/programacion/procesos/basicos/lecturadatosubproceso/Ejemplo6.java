package org.iesalandalus.programacion.procesos.basicos.lecturadatosubproceso;

public class Ejemplo6 {
    public static void main(String[] args) throws Exception {
        // Ejecutamos el proceso DIR
        // Hereda entrada/salida/error del proceso padre
        ProcessBuilder pb =  new ProcessBuilder("CMD", "/C", "DIR");
        Process p = pb.inheritIO().start();

        pb =  new ProcessBuilder("ping", "google.com");
        p = pb.inheritIO().start();

        System.out.println("El subproceso finalizó con valor de salida: " + p.waitFor());

    }
}
