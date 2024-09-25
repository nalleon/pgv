package es.ies.puerto.model;

import java.io.*;

public class DataProducer {
    public static void main(String[] args) {

        try(BufferedWriter br = new BufferedWriter(new FileWriter("exercise07.txt"))){
            for (int i = 1; i <= 10; i++) {
                br.write("Data produced: " +i);
            }
            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }



    }
}
