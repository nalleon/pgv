package es.ies.puerto.exercise10;

import java.util.Random;

/**
 * Simula una batalla mágica entre Gandalf y Saruman. Cada mago lanza hechizos que reducen la energía
 * del otro mago, usando dos hilos. El primer mago que agote por completo la energía del otro gana la batalla.
 * Los hechizos deben ser lanzados a intervalos de tiempo aleatorios.
 */
public class MagicBattle implements Runnable {
    private String name;
    private static int energy = 1000;
    private static boolean battleOver = false;


    public MagicBattle() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        int rivalEnergy = energy;

        while (rivalEnergy > 0 && !battleOver) {
            int damage = random.nextInt(100) + 1;
            int spellCastTime = random.nextInt(1000) + 1;
            rivalEnergy -= damage;
            System.out.println(getName() + " caused " + damage + " to rival. Rival's left energy: " + rivalEnergy);

            if (rivalEnergy <= 0 && !battleOver) {
                battleOver = true;
                System.out.println(getName() + " has won the battle!");
            }

            try {
                Thread.sleep(spellCastTime);
            } catch (InterruptedException e) {
                e.printStackTrace();


            }
        }
    }
}
