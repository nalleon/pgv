package es.ies.puerto;

import java.io.IOException;

/**
 * Escribe un programa que ejecute un comando del sistema (por ejemplo, ls o dir),
 * capture su salida y la redirija a un archivo de texto.
 */
public class Exercise03 {
    public static final String COMMAND = "ls -l";

    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder(COMMAND.split(" "));

        try {
            Process process = processBuilder.start();
            int exitCode = process.waitFor();
            System.out.println("exitCode: " + exitCode);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
