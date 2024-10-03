package es.ies.puerto;

import java.util.Random;

public class PokemonBattle implements Runnable {

    private String name;
    private int hp = 100;

    private static final int END_BATTLE = 0;
    private static boolean winBattle = false;

    /**
     * Default constructor of the classs
     */
    public PokemonBattle() {
    }

    public PokemonBattle(String name) {
        this.name = name;
    }

    /**
     * Getters/setters
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void run() {
        int hpAux = hp;
        Random random = new Random();

        while(hpAux > END_BATTLE && !winBattle){
            int damageTaken = random.nextInt(15);
            hpAux -= damageTaken;

            if (damageTaken != 0){
                System.out.println(getName() + " has taken " + damageTaken);
            } else {
                System.out.println(getName() + " has avoided the attack.");
            }

            if (hpAux <= END_BATTLE && !winBattle){
                winBattle = true;
                System.out.println(getName() + " has been defeated");
            }

            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }


}
