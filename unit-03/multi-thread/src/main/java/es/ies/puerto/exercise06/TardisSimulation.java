package es.ies.puerto.exercise06;

import java.util.Random;

public class TardisSimulation implements Runnable{
    private String periodName;
    private int progress = 0;
    private static final int GOAL = 100;
    private static boolean winnerDeclared = false;

    public TardisSimulation() {}

    public String getPeriodName() {
        return periodName;
    }

    public void setPeriodName(String periodName) {
        this.periodName = periodName;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (progress < GOAL && !winnerDeclared) {
            int time = random.nextInt(10) + 1;
            progress += time;
            System.out.println(getPeriodName() + " has advanced " + time + " secs. Progress: " + progress + " secs");

            if (progress >= GOAL && !winnerDeclared) {
                winnerDeclared = true;
                System.out.println("Reached the end of " + getPeriodName() + " first!");
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
