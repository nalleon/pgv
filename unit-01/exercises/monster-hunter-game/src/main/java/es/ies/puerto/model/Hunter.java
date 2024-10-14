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
    private static boolean gameOver = false;



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
        while (!gameOver && !monsters.isEmpty()) {
            String newPosition = movement();
            setPosition(newPosition);
            System.out.println(hunterName + " moved to " + newPosition);
            System.out.println();

            synchronized (monsters) {
                for (Monster monster : monsters) {
                    if (monster.getPosition().equals(newPosition) && !monster.isCaptured()) {
                        monster.setCaptured(true);
                        System.out.println(hunterName + " caught " + monster.getMonsterName()
                                + " at: " + newPosition);
                        mapGame.removeMonster(monster, monster.getPosition());
                        monsters.remove(monster);
                        break;
                    }
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
        int newPositionX = random.nextInt(mapGame.getSize());
        int newPositionY = random.nextInt(mapGame.getSize());
        return newPositionX +","+ newPositionY;
    }

    public static void endGame() {
        gameOver = true;
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
