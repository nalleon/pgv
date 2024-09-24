package es.ies.puerto.model;

import java.io.File;
import java.io.IOException;

/**
 * Crea un programa que use ProcessBuilder para ejecutar otro programa Java,
 * pasando diferentes argumentos. Por ejemplo, ejecuta un programa que toma
 * como entrada el nombre de un archivo y escribe "Hola Mundo" en él.
 */
public class Exercise04 {

    public static final String[] EXEC_INFO = {
            "java",
            "-cp", System.getProperty("java.class.path"),
            "es.ies.puerto.model.WorkerClass",
            "exercise04.txt"
    };

    public static void main(String[] args) {
        System.out.println(executeAnotherClass(EXEC_INFO));
    }

    public static boolean executeAnotherClass(String [] execInfo){

            try {
                ProcessBuilder processBuilder = new ProcessBuilder(execInfo);
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
