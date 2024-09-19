package es.ies.puerto;

import java.io.IOException;

/**
 * Escribe un programa que ejecute tres comandos diferentes de forma secuencial (por ejemplo, ping, ls o dir, y echo).
 * Cada proceso debe esperar a que el anterior termine antes de iniciarse.
 */
public class Exercise02 {
    public static final String COMMAND_PING = "ping -c 3 google.com";
    public static final String COMMAND_LS = "ls -l ./";
    public static final String COMMAND_ECHO = "echo \"Test echo\"";


    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder(COMMAND_PING.split(" "));
        ProcessBuilder processBuilder2 = new ProcessBuilder(COMMAND_LS.split(" "));
        ProcessBuilder processBuilder3 = new ProcessBuilder(COMMAND_ECHO.split(" "));

        try{
            Process process = processBuilder.start();
            Process process2 = processBuilder2.start();
            Process process3 = processBuilder3.start();

            int exitCode = process.waitFor();
            int exitCode2 = process2.waitFor();
            int exitCode3 = process3.waitFor();

            System.out.println("exitCode: " + exitCode);
            System.out.println("exitCode: " + exitCode2);
            System.out.println("exitCode: " + exitCode3);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
