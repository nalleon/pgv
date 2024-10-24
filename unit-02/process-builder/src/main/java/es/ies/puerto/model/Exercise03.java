package es.ies.puerto.model;

import java.io.*;

/**
 * Escribe un programa que ejecute un comando del sistema (por ejemplo, ls o dir),
 * capture su salida y la redirija a un archivo de texto.
 */
public class Exercise03 {
    public static final String COMMAND_LINUX = "ls -l";

    public static void main(String[] args) {
        System.out.println(redirectToFile(COMMAND_LINUX));
    }

    public static boolean redirectToFile(String command){
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));

        File outputFile = new File("exercise03.txt");

        processBuilder.redirectOutput(outputFile);
        processBuilder.redirectErrorStream(true);

        try {
            Process process = processBuilder.start();

            int exitCode = process.waitFor();
            if (exitCode == 0){
                return true;
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return false;
    }


}
