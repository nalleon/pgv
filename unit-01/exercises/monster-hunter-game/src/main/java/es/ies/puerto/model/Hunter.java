package es.ies.puerto.model;

import java.util.Objects;
import java.util.Random;

/**
 * @author Nabil L. A.
 */
public class Hunter extends Thread {
    private String hunterName;

    @Override
    public void run() {
        Random random = new Random();
    }


    public int movement(int location){

        return location;
    }

    @Override
    public String toString() {
        return "Hunter{" +
                "hunterName='" + hunterName + '\'' +
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
