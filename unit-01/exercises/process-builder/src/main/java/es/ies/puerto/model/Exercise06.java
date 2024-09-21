package es.ies.puerto.model;

import java.io.IOException;

/**
 * Crea un programa que lance 5 instancias de una clase Java llamada WorkerClass. Cada instancia debe realizar
 * una tarea sencilla, como escribir en un archivo o mostrar un mensaje en consola.
 * Objetivos:
 *     Lanzar múltiples instancias de un proceso Java desde otro proceso Java.
 *     Usar ProcessBuilder para ejecutar una clase Java.
 */
public class Exercise06 {
    public static final String EXECUTABLE = "java";
    public static final String CLASS = "es.ies.puerto.model.WorkerClass";
    public static final int NUM_PROCESS = 5;

    public static void main(String[] args) {
        String classPath = System.getProperty("java.class.path");

        for (int i=1; i <= NUM_PROCESS; i++) {
            try {
                ProcessBuilder processBuilder = new ProcessBuilder(EXECUTABLE, "-cp", classPath,
                        CLASS, String.valueOf(i));

                Process process = processBuilder.start();

                int exitCode = process.waitFor();
                System.out.println("exitCode of process " + (i)+ " : " + exitCode);

            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
