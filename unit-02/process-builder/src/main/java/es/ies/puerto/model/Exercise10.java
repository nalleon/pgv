package es.ies.puerto.model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
        System.out.println(consumerReadProducer(COMMAND_LINUX, COMMAND_FILTER));
    }

    public static boolean consumerReadProducer(String commandProducer, String commandConsumer) {
        //Process processConsumer = pbConsumer.start();

        ProcessBuilder pbProducer = new ProcessBuilder(commandProducer.split(" "));

        List<String> result = new ArrayList<>();
        InputStream producerInputStream;
        int exitCodeProducer;
        try {
            Process processProducer = pbProducer.start();

            producerInputStream = processProducer.getInputStream();
            BufferedReader lector = new BufferedReader(new InputStreamReader(producerInputStream));

            String line;
            while ((line = lector.readLine()) != null) {
                result.add(line);
            }

             exitCodeProducer = processProducer.waitFor();

            } catch (IOException | InterruptedException ex) {
            throw new RuntimeException(ex);
        }

        ProcessBuilder pbConsumer = new ProcessBuilder(commandConsumer.split(" "));
        try {
            Process processConsumer = pbConsumer.start();


        }  catch (IOException e) {
            throw new RuntimeException(e);
        }


        /**
        Process processConsumer = pbConsumer.start();



        OutputStream outputStream = processConsumer.getOutputStream();

            int exitCodeConsumer = processConsumer.waitFor();

            if (exitCodeConsumer == 0 && exitCodeProducer == 0){
                return true;
            }
*/
        return false;
    }
}
