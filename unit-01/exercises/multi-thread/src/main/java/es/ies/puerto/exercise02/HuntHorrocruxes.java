package es.ies.puerto.exercise02;

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
        Random random = new Random();

        int distanceAdvanced = 0;
        int searchTime = (random.nextInt(50)+10);
        long initialTime = System.currentTimeMillis();
        long timePassed = 0;

        System.out.println(getName() + "'s time to find: " + searchTime);

        while (!found && timePassed < searchTime){
            int advanceSearch = random.nextInt(100)+10;
            distanceAdvanced+=advanceSearch;
            long endTime = System.currentTimeMillis();

            timePassed = (endTime - initialTime);

            System.out.println(getName() + " advanced " + distanceAdvanced);

            if (distanceAdvanced >= horrocruxDistance && !found){
                found = true;
                System.out.println(getName() + " has found a Horrocrux at " + getLocation());
                System.out.println(getName() + "'s time to find: " + searchTime);
                break;
            }

            if (timePassed >= searchTime && !found){
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
