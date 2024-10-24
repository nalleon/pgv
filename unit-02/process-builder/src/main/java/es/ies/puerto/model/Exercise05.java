package es.ies.puerto.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Escribe un programa que ejecute un comando que tenga una alta probabilidad de fallar
 * (por ejemplo, un comando con un nombre incorrecto). Captura el error generado y muéstralo
 * en la consola. Objetivos:
 *     Capturar y mostrar la salida de error de un proceso.
 *     Usar redirectErrorStream() o getErrorStream() para manejar errores.
 */
public class Exercise05 {

    public static final String COMMAND = "cat test.txt";

    public static void main(String[] args) {
        System.out.println(redirectErrors(COMMAND));
    }

    public static boolean redirectErrors(String command){
        ProcessBuilder processBuilder = new ProcessBuilder(command.split(" "));
        processBuilder.redirectErrorStream(true);

        try {
            Process process = processBuilder.start();
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String lineError;

            List<String> errorList = new ArrayList<>();
            while ((lineError = br.readLine()) != null) {
                errorList.add(lineError);
            }

            int exitCode = process.waitFor();
            if (exitCode == 1 && !errorList.isEmpty()){
                return true;
            }

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        return false;
    }
}
