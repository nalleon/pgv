package es.ies.puerto.exercise08;

import java.util.Random;

/**
 *  Simula una competencia de fuerza entre Thor y Hulk. Ambos héroes tienen que levantar pesas (representados
 *  por incrementos de peso levantado en cada iteración del hilo) durante un tiempo limitado. Al final, el hilo
 *  que haya levantado más peso gana la competencia.
 */
public class StrengthCompetition implements Runnable{
    private String heroName;
    private int progress = 0;
    private static final int MAX_WEIGHT_PER_ITERATION = 100;
    private static final long COMPETITION_DURATION = 5000;
    private static boolean winnerDeclared = false;

    public StrengthCompetition() {
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    @Override
    public void run() {
        Random random = new Random();
        long startTime = System.currentTimeMillis();
        long timePassed = 0;

        while ((timePassed < COMPETITION_DURATION) && !winnerDeclared) {

            int weightLifted = random.nextInt(MAX_WEIGHT_PER_ITERATION) + 1;
            progress += weightLifted;
            long endTimeIteration = System.currentTimeMillis();
            timePassed = (endTimeIteration-startTime);

            System.out.println(heroName + " has lifted " + weightLifted + ". Total weight: " + progress + "kg.");

            if (timePassed >= COMPETITION_DURATION && !winnerDeclared){
                winnerDeclared = true;
                System.out.println(getHeroName() + " has won with a total of " + progress + "kg lifted");
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
