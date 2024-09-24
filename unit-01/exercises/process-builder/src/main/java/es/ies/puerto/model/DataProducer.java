package es.ies.puerto.model;

import java.io.OutputStream;
import java.io.PrintWriter;

public class DataProducer {
    public static void main(String[] args) {
        PrintWriter writer = new PrintWriter(System.out, true);

        // Simula la producción de 10 líneas de datos
        for (int i = 1; i <= 10; i++) {
            writer.println("Dato producido: " + i);
        }

        writer.close(); // Cierra la salida para indicar que ya no enviará más datos
    }
}
