package es.ies.puerto.model;

import java.io.IOException;

/**
 * Escribe un programa que inicie un proceso largo (como ping -t en
 * sistemas Windows o un bucle infinito en Linux) y permita que el usuario lo
 * detenga manualmente después de un cierto tiempo (por ejemplo, 10 segundos).
 * Objetivos:
 *     Monitorizar la ejecución de un proceso.
 *     Terminar un proceso usando Process.destroy() después de un cierto tiempo o
 *     bajo una condición.
 */
public class Exercise09 {
    public static final String COMMAND_LINUX = "ping -t google.com";
    public static final int MAX_TIME = 10000;

    public static void main(String[] args) {
        System.out.println(stopProcessAfterTime(MAX_TIME, COMMAND_LINUX));
    }

    public static boolean stopProcessAfterTime(int timeBeforeStop,String command ){
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));

        try{
            long startTime = System.currentTimeMillis();
            Process process = processBuilder.start();

            boolean isRunning = true;

            while (isRunning) {
                long currentTime = System.currentTimeMillis();

                if ((currentTime - startTime) >= timeBeforeStop) {
                    process.destroy();
                    isRunning = false;
                }
            }

            int exitCode = process.waitFor();

            if (exitCode == 1){
                return true;
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

}
