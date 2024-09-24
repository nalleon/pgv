package es.ies.puerto.model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class DataConsumer {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                System.out.println("Consumer received: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
