package es.ies.puerto.model;

import java.io.IOException;

/**
 * Escribe un programa que encadene la salida de un proceso como entrada de otro.
 * Por ejemplo, usa el comando ls (o dir) y pasa su salida a un comando grep (o find)
 * para filtrar resultados.
 * Objetivos:
 *     Encadenar la salida de un proceso para que sea la entrada de otro.
 *     Usar getOutputStream() y getInputStream() para conectar dos procesos.
 */
public class Exercise10 {

    public static final String COMMAND_LINUX = "ls -l";
    public static final String COMMAND_FILTER = "&& grep";

    public static void main(String[] args) {
        ProcessBuilder processBuilder = new ProcessBuilder(COMMAND_LINUX.split(" "));

        try{
            Process process = processBuilder.start();

            int exitCode = process.waitFor();
            System.out.println("exitCode: " + exitCode);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
