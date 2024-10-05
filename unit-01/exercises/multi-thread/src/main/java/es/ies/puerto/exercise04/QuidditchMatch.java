package es.ies.puerto.exercise04;

import java.util.Random;

public class QuidditchMatch implements Runnable{
    private String name;
    private int points = 0;
    private int snitchProgress = 0;
    private static final int GOAL = 100;
    private static boolean winnerDeclared = false;
    private boolean isFinder;

    public QuidditchMatch() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFinder() {
        return isFinder;
    }

    public void setFinder(boolean finder) {
        isFinder = finder;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (points < GOAL && snitchProgress < GOAL && !winnerDeclared) {
            if (!isFinder) {
                int incrementPoints = random.nextInt(10) + 1;
                points =+ incrementPoints;
                System.out.println(getName() + " has " + points + " points.");
            }

            int progressAdd = random.nextInt(10) + 1;
            snitchProgress += progressAdd;

            System.out.println("Snitch search by " + name + ": " + snitchProgress + "%");

            if (points >= GOAL || snitchProgress >= GOAL && !winnerDeclared) {
                winnerDeclared = true;
                System.out.println(name + " has won");
            }
            try {
                Thread.sleep(500);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
