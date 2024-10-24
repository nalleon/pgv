package es.ies.puerto.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Escribe un programa que ejecute tres comandos diferentes de forma secuencial (por ejemplo, ping, ls o dir, y echo).
 * Cada proceso debe esperar a que el anterior termine antes de iniciarse.
 */
public class Exercise02 {

    public static final String[] COMMANDS = {
            "ping -c 3 google.com",
            "ls -l ./",
            "echo \"Test echo\""
    };


    public static void main(String[] args) {
        System.out.println(executeCommand(COMMANDS));
    }


    public static boolean executeCommand(String [] commands){
        List<Integer> result = new ArrayList<>();
        for (String str : commands){
            result.add(runProcesses(str));
        }

        for (int exitCode : result) {
            if (exitCode != 0) {
                return false;
            }
        }
        return true;

    }

    public static int runProcesses(String command){
        try{
            ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
            Process process = processBuilder.start();

            return process.waitFor();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
