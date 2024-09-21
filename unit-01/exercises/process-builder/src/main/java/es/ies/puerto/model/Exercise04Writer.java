package es.ies.puerto.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Exercise04Writer {
    public static void main(String[] args) {
        if (args.length < 1){
            return;
        }

        String fileName = args[0];

        try(BufferedWriter br = new BufferedWriter(new FileWriter(fileName))){

            br.write("Hello World!");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
