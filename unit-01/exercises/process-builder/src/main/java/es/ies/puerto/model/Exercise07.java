package es.ies.puerto.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Escribe un programa que inicie dos procesos: uno que genere datos y otro que los consuma. Usa un canal
 * de entrada/salida para enviar datos desde un proceso a otro.
 * Objetivos:
 *     Enviar datos desde un proceso a otro.
 *     Usar getOutputStream() y getInputStream() para manejar la comunicación entre procesos.
 *     usar BufferedReader(new InputStreamReader(proceso.getInputStream())
 */
public class Exercise07 {
    public static final String EXECUTABLE = "java";
    public static final String CLASS_PRODUCER = "es.ies.puerto.model.DataProducer";
    public static final String CLASS_CONSUMER = "es.ies.puerto.model.DataConsumer";

    public static void main(String[] args) {
        ProcessBuilder pbProducer = new ProcessBuilder(EXECUTABLE, CLASS_PRODUCER);
        ProcessBuilder pbConsumer = new ProcessBuilder(EXECUTABLE, CLASS_CONSUMER);

        pbProducer.redirectErrorStream(true);
        pbConsumer.redirectErrorStream(true);

        try{
            Process processProducer = pbProducer.start();
            Process processConsumer = pbConsumer.start();

            InputStream producerInputStream = processProducer.getInputStream();
            OutputStream producerOutputStream = processProducer.getOutputStream();

            InputStream consumerInputStream = processProducer.getInputStream();
            OutputStream consumerOutputStream = processConsumer.getOutputStream();


            int exitCodeConsumer = processConsumer.waitFor();
            int exitCodeProducer = processProducer.waitFor();

            System.out.println("exitCode Consumer: " + exitCodeConsumer);
            System.out.println("exitCode Producer: " + exitCodeProducer);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}