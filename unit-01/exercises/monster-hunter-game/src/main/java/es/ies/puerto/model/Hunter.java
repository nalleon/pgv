package es.ies.puerto.model;

import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * @author Nabil L. A.
 */
public class Hunter extends Thread {
    private String hunterName;
    private String position;
    private MapGame mapGame;
    private List<Monster> monsters;
    private static long TIME_TO_CATCH = 15000;



    /**
     * Default constructor of the class
     */
    public Hunter (){
        hunterName = "";
        position="0,0";
        mapGame = new MapGame();
        monsters = mapGame.getMonsters();
    }

    /**
     * Constructor of the class
     * @param hunterName
     */
    public Hunter(String hunterName) {
        this.hunterName = hunterName;
        position = "0,0";
        mapGame = new MapGame();
        monsters = mapGame.getMonsters();
    }
    /**
     * Constructor of the clase
     * @param name of the thread
     * @param hunterName of the hunter
     */
    public Hunter(String name, String hunterName, String position) {
        super(name);
        this.hunterName = hunterName;
        this.position = position;
        mapGame = new MapGame();
        monsters = mapGame.getMonsters();
    }

    /**
     * Constructor of the class
     * @param name
     * @param hunterName
     * @param position
     * @param mapGame
     */
    public Hunter(String name, String hunterName, String position, MapGame mapGame) {
        super(name);
        this.hunterName = hunterName;
        this.position = position;
        this.mapGame = mapGame;
        this.monsters = mapGame.getMonsters();
    }

    /**
     * Getters/setters
     */


    public String getHunterName() {
        return hunterName;
    }

    public void setHunterName(String hunterName) {
        this.hunterName = hunterName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public void run() {
        long initialTime = System.currentTimeMillis();
        long timePassed = 0;

        int monsterCaught = 0;

        while (!monsters.isEmpty() && timePassed < TIME_TO_CATCH) {
            String newPosition = movement();
            setPosition(newPosition);
            System.out.println(hunterName + " moved to " + newPosition);
            System.out.println();

            long endTime = System.currentTimeMillis();
            timePassed = (endTime - initialTime);

            if (timePassed >= TIME_TO_CATCH){
                System.out.println(hunterName + " caught " + monsterCaught + " monsters");
                break;
            }

            for (Monster monster : monsters) {
                if (monster.getPosition().equals(newPosition) && !monster.isCaptured()) {
                    monster.setCaptured(true);
                    mapGame.removeMonster(monster, monster.getPosition());
                    monsters.remove(monster);
                    monsterCaught++;
                    break;
                }
            }


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(hunterName + " interrupted");
            }
        }
    }


    public String movement (){
        Random random = new Random();
        int newPositionX = random.nextInt(mapGame.getSize()/2);
        int newPositionY = random.nextInt(mapGame.getSize()/2);
        return newPositionX +","+ newPositionY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hunter hunter = (Hunter) o;
        return Objects.equals(hunterName, hunter.hunterName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hunterName);
    }

    @Override
    public String toString() {
        return "Hunter{" +
                "hunterName='" + hunterName + '\'' +
                ", position='" + position + '\'' +
                '}';
    }

}
