package es.ies.puerto.exercise03;
/**
 * Simula una fábrica de droides en la que se están ensamblando droides de batalla.
 * Un hilo se encarga de ensamblar los droides, mientras que otro hilo se encarga de
 * activarlos. Asegúrate de que los droides no se activen antes de ser
 * completamente ensamblados, usando mecanismos de sincronización entre hilos.
 */
public class Exercise03 {
    public static void main(String[] args) {
        DroidFactory droidFactory1 = new DroidFactory();
        DroidFactory droidFactory2 = new DroidFactory();
        droidFactory1.setName("assembler");
        droidFactory2.setName("activator");

        Thread thread1 = new Thread(droidFactory1);
        Thread thread2 = new Thread(droidFactory2);

        try {
            thread1.start();
            thread1.join();
            thread2.start();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
