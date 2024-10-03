package es.ies.puerto;

import java.util.Random;

/**
 * Imagina que Harry, Hermione y Ron están buscando Horrocruxes. Cada personaje está
 * representado por un hilo que busca en una ubicación diferente del mundo.
 * El primer hilo que encuentra un Horrocrux debe detener a los demás y terminar la
 * búsqueda. Elige el tiempo de búsqueda de manera aleatoria para cada hilo.
 */
public class HuntHorrocruxes implements Runnable {
    private String name;
    private static boolean found = false;
    private int horrocruxDistance = 80;

    private long timeInitiate = System.currentTimeMillis();
    private String location;

    public HuntHorrocruxes() {}


    /**
     * Getters and setters
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public void run() {
        int distanceAdvanced = 0;
        Random random = new Random();

        int searchTime = (random.nextInt(50)+10);

        int initialTime = (int) (System.currentTimeMillis())/1000;
        int currentTime = 0;

        System.out.println(getName() + "'s time to find: " + searchTime);

        while (!found){
            int advanceSearch = random.nextInt(90);
            distanceAdvanced+=advanceSearch;

            System.out.println(getName() + " advanced " + distanceAdvanced);

            currentTime = (int) (System.currentTimeMillis())/1000;


            if (distanceAdvanced == horrocruxDistance){
                found = true;
                System.out.println(getName() + " has found a Horrocrux at :" );
                System.out.println("Time to find: " + searchTime);
            }

            if (searchTime <= (currentTime-initialTime)){
                System.out.println(getName() + " has not found the Horrocrux in " + getLocation());
                System.out.println("Horrocrux was at: " + (horrocruxDistance-distanceAdvanced));
                break;
            }

            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }
    }
}
