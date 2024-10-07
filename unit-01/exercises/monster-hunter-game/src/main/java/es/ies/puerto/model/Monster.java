package es.ies.puerto.model;

import java.util.Objects;

/**
 * @author Nabil L. A.
 */
public class Monster {

    private int monsterId;
    private String monsterName;
    private String location;
    private boolean captured;

    /**
     * Default constructor of the class
     */
    public Monster() {}

    /**
     * Constructor of the class
     * @param monsterId of the monster
     */
    public Monster(int monsterId) {
        this.monsterId = monsterId;
    }

    /**
     * Constructor of the class
     * @param monsterId of the monster
     * @param monsterName of the monster
     * @param location of the monster
     * @param captured of the monster
     */
    public Monster(int monsterId, String monsterName, String location, boolean captured) {
        this.monsterId = monsterId;
        this.monsterName = monsterName;
        this.location = location;
        this.captured = captured;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isCaptured() {
        return captured;
    }

    public void setCaptured(boolean captured) {
        this.captured = captured;
    }

    /**
     * Method to string
     */

    @Override
    public String toString() {
        return "Monster{" +
                "monsterId=" + monsterId +
                ", monsterName='" + monsterName + '\'' +
                ", location='" + location + '\'' +
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
