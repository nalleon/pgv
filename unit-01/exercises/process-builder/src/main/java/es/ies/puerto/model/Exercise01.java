package es.ies.puerto.model;

import java.io.IOException;

/**
 * Escribe un programa que use ProcessBuilder para ejecutar el comando ping a una dirección IP o un dominio
 * (por ejemplo, google.com). El programa debe capturar y mostrar la salida del
 * proceso en la consola.
 */
public class Exercise01 {

    public static final String COMMAND = "ping -c 3 google.com";

    /**
     * Default cosntructor of the class
     */
    public Exercise01() {}


    public static void main(String[] args) {
        processPing(COMMAND);
    }


    public static boolean processPing(String command){
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        try{
            Process process = processBuilder.start();
            int exitCode = process.waitFor();

            if (exitCode == 0){
                return true;
            }

        } catch (IOException | InterruptedException e) {
             return false;
        }
        return false;
    }
}
