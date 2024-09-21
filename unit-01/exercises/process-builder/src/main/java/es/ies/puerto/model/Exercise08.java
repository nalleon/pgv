package es.ies.puerto.model;

import java.io.IOException;

/**
 * Escribe un programa que ejecute un proceso del sistema (por ejemplo, ping) y
 * mida el tiempo que tarda en completarse. Muestra el tiempo de ejecución en la consola.
 * Objetivos:
 *     Medir el tiempo de ejecución de un proceso.
 *     Usar System.currentTimeMillis() o System.nanoTime() para medir tiempos.
 */
public class Exercise08 {
    public static final String COMMAND_LINUX = "ls -l";
    public static final String COMMAND_WINDOWS= "cmd.exe /c dir";

    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder(COMMAND_WINDOWS.split(" "));

        try{
            long startTime = System.currentTimeMillis();

            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            long endTime = System.currentTimeMillis();

            long  timePassed = endTime - startTime;

            System.out.println("exitCode: " + exitCode);
            System.out.println("Time passed: " + timePassed + "ms ");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
