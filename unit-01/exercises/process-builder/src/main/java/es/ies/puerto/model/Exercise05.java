package es.ies.puerto.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Escribe un programa que ejecute un comando que tenga una alta probabilidad de fallar
 * (por ejemplo, un comando con un nombre incorrecto). Captura el error generado y muéstralo
 * en la consola. Objetivos:
 *     Capturar y mostrar la salida de error de un proceso.
 *     Usar redirectErrorStream() o getErrorStream() para manejar errores.
 */
public class Exercise05 {
    public static final String COMMAND = "cmd.exe /c dir /ff";
    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder(COMMAND.split(" "));
        processBuilder.redirectErrorStream(true);

        try {
            Process process = processBuilder.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String lineError;


            System.err.println("Command error output: ");
            while ((lineError = br.readLine()) != null) {
                System.out.println(lineError);
            }

            int exitCode = process.waitFor();
            System.err.println("exitCode: " + exitCode);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
