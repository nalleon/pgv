package es.ies.puerto.model;

import java.util.Objects;
import java.util.Random;

/**
 * @author Nabil L. A.
 */
public class Monster extends Thread {

    private int monsterId;
    private String monsterName;
    private String position;
    private boolean captured;

    private MapGame mapGame;

    /**
     * Default constructor of the class
     */
    public Monster() {
        monsterId = 1;
        monsterName = "";
        position = "0,0";
        captured = false;
        mapGame = new MapGame();
    }

    public Monster(int monsterId, String monsterName, MapGame mapGame) {
        this.monsterId = monsterId;
        this.monsterName = monsterName;
        position = "0,0";
        captured = false;
        this.mapGame = mapGame;
    }



    @Override
    public void run() {
        boolean isAlive = true;
        mapGame.addMonster(this);
        while (isAlive) {

            int result = mapGame.fightMonster(this);

            if(result == -1){
                isAlive = false;
            }

            if (isAlive) {
                mapGame.moveMonster(this);
                System.out.println(mapGame+" has moved");
            }else{
                break;
            }

            try {
                Thread.sleep(new Random().nextInt(10000)+5000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    /**
     * Getters and setters
     */

    public int getMonsterId() {
        return monsterId;
    }

    public void setMonsterId(int monsterId) {
        this.monsterId = monsterId;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isCaptured() {
        return captured;
    }

    public void setCaptured(boolean captured) {
        this.captured = captured;
    }

    public MapGame getMapGame() {
        return mapGame;
    }

    public void setMapGame(MapGame mapGame) {
        this.mapGame = mapGame;
    }

    /**
     * Method to string
     */

    @Override
    public String toString() {
        return "Monster{" +
                "monsterId=" + monsterId +
                ", monsterName='" + monsterName + '\'' +
                ", position='" + position + '\'' +
                ", captured=" + captured +
                '}';
    }

    /**
     * Equals and hashcode
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monster monster = (Monster) o;
        return monsterId == monster.monsterId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(monsterId);
    }
}
