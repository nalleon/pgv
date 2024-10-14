package es.ies.puerto.model;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Nabil L. A.
 */
public class MapGame {
    /**
     * Properties
     */
    private int size;
    private ConcurrentHashMap<String, String> locations;

    private static final int DEFAULT_SIZE = 10;
    private char [][] map;

    private List<Monster> monsters;
    private List<Hunter> hunters;


    /**
     * Default constructor of the class
     */
    public MapGame() {
        locations = new ConcurrentHashMap<>();
        size = DEFAULT_SIZE;
        map = new char[size][size];
        monsters = new CopyOnWriteArrayList<>();
        hunters = new CopyOnWriteArrayList<>();
    }

    /**
     * Constructor of the class
     * @param size of the map
     */
    public MapGame(int size) {
        this.size = size;
        locations = new ConcurrentHashMap<>();
        map = new char[size][size];
        monsters = new CopyOnWriteArrayList<>();
        hunters = new CopyOnWriteArrayList<>();
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
        monsters = new CopyOnWriteArrayList<>();
        hunters = new CopyOnWriteArrayList<>();
    }

    /**
     * Function to generate the locations of the map
     * @return positions
     */
    public String generateLocations(){
        Random random = new Random();
        int y = random.nextInt(size);
        int x = random.nextInt( size);
        return x + "," + y;
    }

    public String movement (){
        Random random = new Random();
        int newPositionX = random.nextInt( size-1);
        int newPositionY = random.nextInt( size-1);
        return newPositionX +","+ newPositionY;
    }

    public synchronized void moveHunter(Hunter hunter, String movement){
        String[] position = hunter.getPosition().split(",");
        map[Integer.parseInt(position[0])][Integer.parseInt(position[1])] = ' ';

        hunter.setPosition(movement);
        locations.replace(hunter.getHunterName(), hunter.getPosition(), movement);

        position = hunter.getPosition().split(",");
        map[Integer.parseInt(position[0])][Integer.parseInt(position[1])] = 'H';

    }

    public synchronized void addHunter(Hunter hunter, String location){
        if (!checkPositionsOverlap(location)) {
            String[] positions = location.split(",");
            int row = Integer.parseInt(positions[0]);
            int col = Integer.parseInt(positions[1]);

            map[row][col] = 'H';

            locations.put(hunter.getHunterName(), location);

        }
    }

    public boolean checkPositionsOverlap(String position){
        return locations.containsValue(position);
    }


    public synchronized void addMonster(Monster monster){
        if (!checkPositionsOverlap(monster.getPosition())) {
            monsters.add(monster);
            String[] positions = monster.getPosition().split(",");
            int row = Integer.parseInt(positions[0]);
            int col = Integer.parseInt(positions[1]);
            map[row][col] = 'M';

            locations.put(monster.getMonsterName(), monster.getPosition());
        }
    }


    public synchronized void removeMonster(Monster monster, String location){
        locations.remove(monster.getMonsterName(), location);
        monsters.remove(monster);
    }

    public synchronized void catchMonster(List<Monster> monsters, Hunter hunter) {
        for (int i = monsters.size() - 1; i >= 0; i--) {
            Monster monster = monsters.get(i);
            if (hunter.getPosition().equals(monster.getPosition())) {
                System.out.println(hunter.getName() + " caught " + monster.getMonsterName() + " at "
                        + monster.getPosition());
                monster.setCaptured(true);
                removeMonster(monster, monster.getPosition());
                monsters.remove(i);
                System.out.println("Remaining monsters: " + getMonsters().size());
                return;
            }
        }
    }

    /**
     * Getters/setters
     */

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public ConcurrentHashMap<String, String> getLocations() {
        return locations;
    }

    public void setLocations(ConcurrentHashMap<String, String> locations) {
        this.locations = locations;
    }

    public char[][] getMap() {
        return map;
    }

    public void setMap(char[][] map) {
        this.map = map;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public List<Hunter> getHunters() {
        return hunters;
    }

    public void setHunters(List<Hunter> hunters) {
        this.hunters = hunters;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MapGame mapGame = (MapGame) o;
        return Objects.equals(locations, mapGame.locations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locations);
    }

    @Override
    public synchronized String toString() {
        String message = "";
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                switch (map[i][j]) {
                    case 'H':
                        message += "H";
                        break;
                    case 'M':
                        message += "M";
                        break;
                    default:
                        message += "·";
                        break;
                }
            }
            message += "\n";
        }
        return message;
    }
}
