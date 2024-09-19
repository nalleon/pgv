package main.es.ies.puerto.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClassA {

    public static final String DIRECTORY_PATH = "./target/classes";
    public static final int NUM_PROCESS = 7;

    public ClassA() {
    }


    public static void main(String[] args) {
        for (int i = 1; i <= NUM_PROCESS; i++) {
            runProcess(i);
        }
    }

    public static void runProcess(int num) {
        ProcessBuilder pb = new ProcessBuilder("java", "main.es.ies.puerto.model.ClassB", String.valueOf(num));
        pb.directory(new java.io.File(DIRECTORY_PATH));

        try {
            Process process = pb.start();

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String str;
            while ((str = reader.readLine()) != null) {
                System.out.println(str);
            }

            BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
            String errorStr;
            while ((errorStr = errorReader.readLine()) != null) {
                System.out.println("Error: " + errorStr);
            }

            int exitCode = process.waitFor();
            System.out.println("Exit code: " + exitCode);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}