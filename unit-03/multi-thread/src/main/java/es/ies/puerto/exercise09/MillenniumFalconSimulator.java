package es.ies.puerto.exercise09;

import java.util.Random;

/**
 * Crea una simulación del Millenium Falcon, donde Han Solo y Chewbacca están controlando la nave en medio de una
 * batalla espacial. Un hilo representa a Han Solo controlando la velocidad, mientras que otro hilo representa a
 * Chewbacca manejando los escudos. Si alguno de los sistemas falla, la nave podría ser destruida.
 */
public class MillenniumFalconSimulator implements Runnable{
    private String name;
    private int progress = 0;
    private static final int GOAL = 100;
    private static boolean milleniumDestroyed = false;
    private static boolean shieldsReady = false;
    private static boolean speedReady = false;

    public MillenniumFalconSimulator() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (progress < GOAL && !milleniumDestroyed) {
            int increment = random.nextInt(10) + 1;
            progress += increment;

            System.out.println(getName() + "'s progress: " + increment + "%. Total: " + progress + "%.");

            if (progress >= GOAL) {
                if (getName().equals("Han Solo")) {
                    speedReady = true;
                    System.out.println("Maximum speed achieved by " + getName() + "!");
                } else if (getName().equals("Chewbacca")) {
                    shieldsReady = true;
                    System.out.println("Maximum shields achieved by " + getName() + "!");
                }
            }

            if (speedReady && shieldsReady && !milleniumDestroyed) {
                System.out.println("Speed and shields at maximum capacity! We're saved");
                break;
            }

            if (random.nextInt(100) < 10) {
                milleniumDestroyed = true;
                System.out.println("Millennium Falcon has been destroyed.");
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
