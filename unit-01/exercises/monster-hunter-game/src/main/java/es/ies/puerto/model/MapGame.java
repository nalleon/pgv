package es.ies.puerto.model;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Nabil L. A.
 */
public class MapGame {
    /**
     * Properties
     */
    int size;
    ConcurrentHashMap<String, String> locations;

    public static final int DEFAULT_SIZE = 10;
    char [][] map;


    /**
     * Default constructor of the class
     */
    public MapGame() {
        locations = new ConcurrentHashMap<>();
        size = DEFAULT_SIZE;
        map = new char[size][size];
    }

    /**
     * Constructor of the class
     * @param size of the map
     */
    public MapGame(int size) {
        this.size = size;
        locations = new ConcurrentHashMap<>();
        map = new char[size][size];
    }

    /**
     * Constructor of the class
     * @param size of the map
     * @param locations of the map
     */
    public MapGame(int size, ConcurrentHashMap<String, String> locations) {
        this.size = size;
        this.locations = locations;
        map = new char[size][size];
    }

    /**
     * Function to generate the locations of the map
     * @return positions
     */
    public String generateLocations(){
        Random random = new Random();
        int y = random.nextInt(0, size);
        int x = random.nextInt(0, size);
        return x + "," + y;
    }

    public boolean moveHunter(Hunter hunter, String movement){
        hunter.setPosition(movement);
        char [] aux = hunter.getPosition().toCharArray();

        return true;
    }

    public boolean addMonster(Monster monster, String movement){
        monster.setPosition(movement);
        String [] auxPosition = movement.split(",");
        //map[Integer.parseInt(auxPosition[0])]
        return true;
    }


    public boolean removeMonster(Monster monster, String location){
        locations.remove(monster.getMonsterName(), location);
        return true;
    }

    public boolean catchMonster(){
        return true;
    }

    public String movement (){
        Random random = new Random();
        int newPositionX = random.nextInt(0, size/2);
        int newPositionY = random.nextInt(0, size/2);
        return newPositionX +","+ newPositionY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapGame mapGame = (MapGame) o;
        return size == mapGame.size && Objects.equals(locations, mapGame.locations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, locations);
    }

    @Override
    public String toString() {
        return "MapGame{" +
                "size=" + size +
                ", locations=" + locations +
                '}';
    }
}
