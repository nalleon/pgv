package es.ies.puerto.model;

import java.io.File;
import java.io.IOException;

/**
 * Crea un programa que use ProcessBuilder para ejecutar otro programa Java,
 * pasando diferentes argumentos. Por ejemplo, ejecuta un programa que toma
 * como entrada el nombre de un archivo y escribe "Hola Mundo" en él.
 */
public class Exercise04 {
    public static final String EXECUTABLE = "java";
    public static final String CLASS = "es.ies.puerto.model.WorkerClass";
    public static final String FILE_NAME = "exercise04.txt";

    public static void main(String[] args) {
        String classPath = System.getProperty("java.class.path");


        try {
            ProcessBuilder processBuilder = new ProcessBuilder(EXECUTABLE, "-cp", classPath, CLASS, FILE_NAME);
            Process process = processBuilder.start();

            int exitCode = process.waitFor();
            System.out.println("exitCode: " + exitCode);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
