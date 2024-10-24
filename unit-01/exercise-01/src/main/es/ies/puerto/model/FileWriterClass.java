package main.es.ies.puerto.model;

import java.io.*;

public class FileWriterClass {
    public static final String PATH = "src/main/resources/file.txt";

    /**
     * Default constructor of the class
     */
    public FileWriterClass() {}

    public static void main(String[] args) throws IOException {
        String processMessage = "Process line (" + args[0] + ")\n";
        modifyFile(processMessage);
    }

    public static void modifyFile(String str) throws IOException {
        if (createFile()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH, true))) {
                writer.write(str + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static boolean createFile() throws IOException {
        if (existFile(PATH)){
           return true;
        }
        File file = new File(PATH);

        return file.createNewFile();
    }


    public static boolean existFile(String path){
        if (path == null || path.isEmpty()){
            return false;
        }
        File file = new File(path);
        return file.exists() && file.isFile();
    }
}
