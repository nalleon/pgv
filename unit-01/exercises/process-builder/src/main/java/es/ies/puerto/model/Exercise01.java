package es.ies.puerto.model;

import java.io.IOException;

/**
 * Escribe un programa que use ProcessBuilder para ejecutar el comando ping a una dirección IP o un dominio
 * (por ejemplo, google.com). El programa debe capturar y mostrar la salida del
 * proceso en la consola.
 */
public class Exercise01 {
    public static final String COMMAND = "ping -c 3 google.com";

    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder(COMMAND.split(" "));

        try{
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            System.out.println("exitCode: " + exitCode);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
