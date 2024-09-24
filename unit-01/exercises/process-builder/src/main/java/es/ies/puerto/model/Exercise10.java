package es.ies.puerto.model;

import java.io.*;

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
    public static final String COMMAND_FILTER = "grep \".txt\"";
    public static void main(String[] args) {
        ProcessBuilder pbProducer = new ProcessBuilder(COMMAND_LINUX.split(" "));
        ProcessBuilder pbConsumer = new ProcessBuilder(COMMAND_FILTER.split(" "));

        try {
            Process processProducer = pbProducer.start();
            Process processConsumer = pbConsumer.start();


            InputStream producerInputStream = processProducer.getInputStream();
            OutputStream consumerOutputStream = processConsumer.getOutputStream();


            byte[] tmp = new byte[1024];
            int bytesRead;

            while ((bytesRead = producerInputStream.read(tmp)) != -1) {
                consumerOutputStream.write(tmp, 0, bytesRead);
                consumerOutputStream.flush();
            }


            consumerOutputStream.close();
            producerInputStream.close();


            int exitCodeProducer = processProducer.waitFor();
            int exitCodeConsumer = processConsumer.waitFor();

            System.out.println("Código de salida del Productor: " + exitCodeProducer);
            System.out.println("Código de salida del Consumidor: " + exitCodeConsumer);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}