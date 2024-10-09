package es.ies.puerto.model;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Nabil L. A.
 */
public class Map {
    int size;
    ConcurrentHashMap<String, String> locations;

    public Map() {
        locations = new ConcurrentHashMap<>();
    }

    public Map(int size, ConcurrentHashMap<String, String> locations) {
        this.size = size;
        this.locations = locations;
    }

    public String generateLocations(){
        Random random = new Random();
        int y = random.nextInt(0, size);
        int x = random.nextInt(0, size);
        return x + "," + y;
    }

    public boolean moveHunter(Hunter hunter, String newLocation){
        return true;
    }

    public boolean addMonster(Monster monster, String location){
        return true;
    }
}
