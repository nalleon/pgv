package es.ies.puerto.model;

import java.util.Objects;
import java.util.Random;

/**
 * @author Nabil L. A.
 */
public class Hunter extends Thread {
    private String hunterName;
    private String position;

    @Override
    public void run() {
        Random random = new Random();
    }

    /**
     * Default constructor of the class
     */
    public Hunter (){}

    /**
     * Constructor of the clase
     * @param name of the thread
     * @param hunterName of the hunter
     */
    public Hunter(String name, String hunterName, String position) {
        super(name);
        this.hunterName = hunterName;
        this.position = position;
    }

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
    public String toString() {
        return "Hunter{" +
                "hunterName='" + hunterName + '\'' +
                ", position='" + position + '\'' +
                '}';
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
}
