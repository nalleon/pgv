package es.ies.puerto.exercise06;

/**
 * Simula viajes en el tiempo de la TARDIS con varios hilos que representan diferentes épocas.
 * Cada hilo debe intentar llegar al destino más rápido que los demás. La duración de cada viaje
 * debe ser aleatoria y el destino final se alcanza cuando uno de los hilos termina su ejecución.
 */
public class Exercise06 {
    public static void main(String[] args) {
        TardisSimulation tardisSimulation1 = new TardisSimulation();
        TardisSimulation tardisSimulation2 = new TardisSimulation();

        tardisSimulation1.setPeriodName("Period1");
        tardisSimulation2.setPeriodName("Period2");

        Thread thread1 = new Thread(tardisSimulation1);
        Thread thread2 = new Thread(tardisSimulation2);

        thread1.start();
        thread2.start();

    }
}
