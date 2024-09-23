package es.ies.puerto.model;

import java.io.*;

/**
 * Escribe un programa que ejecute un comando del sistema (por ejemplo, ls o dir),
 * capture su salida y la redirija a un archivo de texto.
 */
public class Exercise03 {
    public static final String COMMAND_LINUX = "ls -l";
    //public static final String COMMAND_WINDOWS = "cmd.exe /c dir";


    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder(COMMAND_LINUX.split(" "));

        File outputFile = new File("output.txt");

        processBuilder.redirectOutput(outputFile);
        processBuilder.redirectErrorStream(true);

        try {
            Process process = processBuilder.start();

            int exitCode = process.waitFor();
            System.out.println("exitCode: " + exitCode);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
