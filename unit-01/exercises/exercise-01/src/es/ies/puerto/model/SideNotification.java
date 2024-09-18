package es.ies.puerto.model;

import java.io.*;

public class SideNotification {
    public static final String PATH = "src/resources/file.txt";

    /**
     * Default constructor of the class
     */
    public SideNotification() {

    }


    public boolean modifyFile(String str) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(PATH))){
            writer.write(str);
            return true;
        } catch (IOException e) {
            return false;
        }
    }


    public boolean createFile() throws IOException {
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
