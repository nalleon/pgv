package es.ies.puerto.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Crea un programa que lance 5 instancias de una clase Java llamada WorkerClass. Cada instancia debe realizar
 * una tarea sencilla, como escribir en un archivo o mostrar un mensaje en consola.
 * Objetivos:
 *     Lanzar múltiples instancias de un proceso Java desde otro proceso Java.
 *     Usar ProcessBuilder para ejecutar una clase Java.
 */
public class Exercise06 {
    public static final String EXECUTABLE = "java";
    public static final String CLASS = "es.ies.puerto.model.WorkerClass";
    public static final int NUM_PROCESS = 5;
    public static final String CLASS_PATH = System.getProperty("java.class.path");
    public static void main(String[] args) {
        System.out.println(runInstances(NUM_PROCESS,EXECUTABLE,CLASS_PATH,CLASS));
    }


    public static boolean runInstances(int numInstances, String executable, String classPath, String className){
        List<Integer> result = new ArrayList<>();
        for (int i=1; i <= numInstances; i++) {
            try {
                ProcessBuilder processBuilder = new ProcessBuilder(executable, "-cp", classPath, className,
                        String.valueOf(i));

                Process process = processBuilder.start();

                int exitCode = process.waitFor();
                result.add(exitCode);


            } catch (IOException | InterruptedException e) {
                return false;
            }
        }

        int counter = 0;
        for (Integer exitCode : result) {
            if (exitCode == 0) {
                counter++;
            }
        }
        return result.size() == counter;
    }
}
