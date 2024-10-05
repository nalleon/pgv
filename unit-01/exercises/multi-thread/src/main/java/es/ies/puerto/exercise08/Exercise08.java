package es.ies.puerto.exercise08;

public class Exercise08 {
    public static void main(String[] args) {
        StrengthCompetition thor = new StrengthCompetition();
        StrengthCompetition hulk = new StrengthCompetition();

        thor.setHeroName("Thor");
        hulk.setHeroName("Hulk");

        Thread threadThor = new Thread(thor);
        Thread threadHulk = new Thread(hulk);

        threadThor.start();
        threadHulk.start();

        try {
            threadThor.join();
            threadHulk.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
