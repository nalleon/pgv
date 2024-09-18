package es.ies.puerto.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class Excercise01 {


    public static final String PATH = "src/resources/file.txt";

    public Excercise01() {
    }


    public void modifyFile() {
        ProcessBuilder pb = new ProcessBuilder("java", "SideNo");
        pb.directory(new java.io.File(PATH));

        try {
            Process process = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }

            int exitCode = process.waitFor();
            System.out.println("Código de salida: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}