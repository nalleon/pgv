package es.ies.puerto.model;

import java.io.*;

public class Exercise07 {

    public static final String[] EXEC_INFO_CONSUMER = {
            "java",
            "-cp",
            "bin",
            "src/main/java/es/ies/puerto/model/DataConsumer.java"
    };

    public static final String[] EXEC_INFO_PRODUCER = {
            "java",
            "-cp",
            "bin",
            "src/main/java/es/ies/puerto/model/DataProducer.java"
    };


    public static void main(String[] args) {
        System.out.println(producerConsumerProcesses(EXEC_INFO_PRODUCER, EXEC_INFO_CONSUMER));
    }

    public static boolean producerConsumerProcesses(String [] execInfoProducer, String [] execInfoConsumer){
        ProcessBuilder pbProducer = new ProcessBuilder(execInfoProducer);
        ProcessBuilder pbConsumer = new ProcessBuilder(execInfoConsumer);

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

            if (exitCodeProducer == 0  && exitCodeConsumer == 0){
                return true;
            }

        } catch (IOException | InterruptedException e) {
            return false;
        }
        return false;
    }

}
