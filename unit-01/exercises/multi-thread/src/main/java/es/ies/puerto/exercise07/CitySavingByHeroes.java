package es.ies.puerto.exercise07;

import java.util.Random;
import java.util.Set;

public class CitySavingByHeroes implements Runnable{
    private String heroName;
    private Set<String> locationsCity;
    private int progress = 0;
    private static final int GOAL = 100;
    private static boolean winnerDeclared = false;

    public CitySavingByHeroes() {}

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public Set<String> getLocationsCity() {
        return locationsCity;
    }

    public void setLocationsCity(Set<String> locationsCity) {
        this.locationsCity = locationsCity;
    }

    @Override
    public void run() {
        Random random = new Random();
        int auxCounter = 0;
        int zonesToSave = locationsCity.size();

        while (progress < GOAL && !winnerDeclared && (auxCounter<zonesToSave)) {
            int savePercent = random.nextInt(10) + 1;
            progress += savePercent;
            int totalProgress = 0;
            System.out.println(getHeroName() + "'s progress: " + progress + "%.");


            if (progress >= GOAL){
                auxCounter++;
                System.out.println(getHeroName() + " has saved one zone! Total zones saved: " + auxCounter);
                progress= 0;
            }


            if (auxCounter == zonesToSave && !winnerDeclared) {
                winnerDeclared = true;
                System.out.println(getHeroName() + " has saved their city!");
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
