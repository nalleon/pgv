package es.ies.puerto.exercise05;

import java.util.Random;

public class JediTravel implements Runnable {
    private String name;
    private int progress = 0;
    private static final int GOAL = 100;
    private static boolean winnerDeclared = false;

    public JediTravel() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (progress < GOAL && !winnerDeclared) {
            int clues = random.nextInt(10) + 1;
            progress += clues;
            System.out.println(name + " found " + clues + " clues. Progress: " + progress);

            if (progress >= GOAL && !winnerDeclared) {
                winnerDeclared = true;
                System.out.println(name + " has found all clues from the dark side!");
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
