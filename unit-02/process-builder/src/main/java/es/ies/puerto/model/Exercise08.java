package es.ies.puerto.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Escribe un programa que ejecute un proceso del sistema (por ejemplo, ping) y
 * mida el tiempo que tarda en completarse. Muestra el tiempo de ejecución en la consola.
 * Objetivos:
 *     Medir el tiempo de ejecución de un proceso.
 *     Usar System.currentTimeMillis() o System.nanoTime() para medir tiempos.
 */
public class Exercise08 {
    public static final String COMMAND_LINUX = "ping -c 3 google.com";
    //public static final String COMMAND_WINDOWS= "cmd.exe /c dir";

    public static void main(String[] args) {
        System.out.println(commandTime(COMMAND_LINUX));
    }


    public static List<Integer> commandTime (String command){
        List<Integer> result;
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        try{
            long startTime = System.currentTimeMillis();

            Process process = processBuilder.start();

            result = new ArrayList<>();
            int exitCode = process.waitFor();
            result.add(exitCode);

            long endTime = System.currentTimeMillis();

            int timePassed = (int) (endTime - startTime);

            result.add(timePassed);

            return result;
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
