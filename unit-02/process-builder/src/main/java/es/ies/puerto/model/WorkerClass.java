package es.ies.puerto.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WorkerClass {

    public static final String FILE_NAME = "exercise06.txt";

    public static void main(String[] args) {
        if (args.length < 1){
            return;
        }

        String instanceNumber = args[0];
        String message = "Hello from WorkerClass " + instanceNumber +"!";

        try(BufferedWriter br = new BufferedWriter(new FileWriter(FILE_NAME, true))){
            br.write(message);
            br.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
