package org.iesalandalus.programacion.procesos.basicos.error;

public class SubprocesoErroneoSinFlujo {
    public static void main(String[] args) throws Exception {
        // Ejecutamos el proceso DIR
        // Hereda entrada/salida/error del proceso padre
        ProcessBuilder pb =  new ProcessBuilder("CMD", "/C", "DIRf");
        Process p = pb.inheritIO().start();

        System.out.println("El subproceso finalizó con valor de salida: " + p.waitFor());

    }
}
