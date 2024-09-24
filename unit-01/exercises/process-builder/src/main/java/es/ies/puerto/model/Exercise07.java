package es.ies.puerto.model;

import java.io.*;

public class Exercise07 {
    public static final String EXECUTABLE = "java";
    public static final String CLASS_PRODUCER = "src/main/java/es/ies/puerto/model/DataProducer.java";
    public static final String CLASS_CONSUMER = "src/main/java/es/ies/puerto/model/DataConsumer.java";
    public static final String CLASSPATH = "-cp";  // Agrega el parámetro de classpath
    public static final String CLASSPATH_DIR = "bin";

    public static void main(String[] args) {
        ProcessBuilder pbProducer = new ProcessBuilder(EXECUTABLE, CLASSPATH, CLASSPATH_DIR, CLASS_PRODUCER);
        ProcessBuilder pbConsumer = new ProcessBuilder(EXECUTABLE, CLASSPATH, CLASSPATH_DIR, CLASS_CONSUMER);

        pbProducer.redirectErrorStream(true);
        pbConsumer.redirectErrorStream(true);

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

            producerInputStream.close();
            consumerOutputStream.close();

            int exitCodeProducer = processProducer.waitFor();
            int exitCodeConsumer = processConsumer.waitFor();

            System.out.println("Código de salida del Productor: " + exitCodeProducer);
            System.out.println("Código de salida del Consumidor: " + exitCodeConsumer);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
