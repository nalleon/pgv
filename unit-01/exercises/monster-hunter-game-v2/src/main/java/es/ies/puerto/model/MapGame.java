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
    private String [][] map;

    private List<Monster> monsters;
    private List<Hunter> hunters;


    /**
     * Default constructor of the class
     */
    public MapGame() {
        locations = new ConcurrentHashMap<>();
        size = DEFAULT_SIZE;
        map = new String[size][size];
        monsters = new CopyOnWriteArrayList<>();
        hunters = new CopyOnWriteArrayList<>();
        generateMap();
    }

    /**
     * Constructor of the class
     * @param size of the map
     */
    public MapGame(int size) {
        this.size = size;
        locations = new ConcurrentHashMap<>();
        map = new String[size][size];
        monsters = new CopyOnWriteArrayList<>();
        hunters = new CopyOnWriteArrayList<>();
        generateMap();
    }


    /**
     * Function to generate the locations of the map
     * @return positions
     */
    public String generateLocations(){
        Random random = new Random();
        int y = random.nextInt(size);
        int x = random.nextInt(size);
        return x + "," + y;
    }


    public synchronized void moveHunter(Hunter hunter){
        Random random = new Random();
        int y = random.nextInt(size);
        int x = random.nextInt(size);

        if (map[x][y].equals(" . ")){
            map[x][y] = " H ";
            String[] position = hunter.getPosition().split(",");
            map[Integer.parseInt(position[0])][Integer.parseInt(position[1])] = " . ";
            hunter.setPosition(x + ","+ y);
            showMap();
            return;
        }

        if (map[x][y].equals(" M ")){
            System.out.println(hunter.getHunterName() + " encountered a monster at: " + x + "," + y);

            if (!catchMonster(hunter)){
                return;
            }

            map[x][y] = " H ";
            String[] position = hunter.getPosition().split(",");
            map[Integer.parseInt(position[0])][Integer.parseInt(position[1])] = " . ";
            hunter.setPosition(x + ","+ y);
            showMap();
            return;
        }

        if (map[x][y].equals(" H ")){
            moveHunter(hunter);
        }
    }

    public synchronized void moveMonster(Monster monster){
        Random random = new Random();
        int y = random.nextInt(size/2);
        int x = random.nextInt(size/2);

        if (map[x][y].equals(" . ")){
            map[x][y] = " M ";
            String[] position = monster.getPosition().split(",");
            map[Integer.parseInt(position[0])][Integer.parseInt(position[1])] = " . ";
            monster.setPosition(x + ","+ y);
            showMap();

        } else if (map[x][y].equals(" H ")){
            System.out.println(monster.getMonsterName() + " encountered a hunter at: " + x + "," + y);
            if (fightMonster(monster) != 1){
                return;
            }

            map[x][y] = " M ";
            String[] position = monster.getPosition().split(",");
            map[Integer.parseInt(position[0])][Integer.parseInt(position[1])] = " . ";
            monster.setPosition(x + ","+ y);
            showMap();

        } else {
            moveMonster(monster);
        }
    }

    private void generateMap() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.map[i][j] = " . ";
            }
        }
    }

    public void showMap(){
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println(" ");
        }
        System.out.println(" ");
    }

    public synchronized void addHunter(Hunter hunter, String location){
        if (checkPositionsOverlap(location)) {
            hunters.add(hunter);
            String[] positions = location.split(",");
            int row = Integer.parseInt(positions[0]);
            int col = Integer.parseInt(positions[1]);

            map[row][col] = " H ";

            locations.put(hunter.getHunterName(), location);
        }
    }

    public boolean checkPositionsOverlap(String position){
        return !locations.containsValue(position);
    }


    public synchronized void addMonster(Monster monster){
        if (checkPositionsOverlap(monster.getPosition())) {
            monsters.add(monster);
            String[] positions = monster.getPosition().split(",");
            int row = Integer.parseInt(positions[0]);
            int col = Integer.parseInt(positions[1]);
            map[row][col] = " M ";

            locations.put(monster.getMonsterName(), monster.getPosition());
        }
    }


    public synchronized void removeMonster(Monster monster, String location){
        locations.remove(monster.getMonsterName(), location);
        monsters.remove(monster);
    }

    public synchronized void removeHunter(Hunter hunter, String location){
        locations.remove(hunter.getHunterName(), location);
        hunters.remove(hunter);
    }

    public synchronized boolean catchMonster(Hunter hunter) {
        Random random = new Random();
        for (int i = monsters.size() - 1; i >= 0; i--) {
            Monster monster = monsters.get(i);
            if (hunter.getPosition().equals(monster.getPosition())) {
                if (random.nextInt(10) <= 7) {
                    System.out.println(hunter.getName() + " caught " + monster.getMonsterName() + " at "
                            + monster.getPosition());
                    monster.setCaptured(true);
                    removeMonster(monster, monster.getPosition());
                    System.out.println("Remaining monsters: " + getMonsters().size());
                    return true;
                } else {
                    System.out.println(monster.getMonsterName() + " repelled " + hunter.getName() + "!");
                    moveMonster(monster);
                    return false;
                }
            } else {
                System.out.println("nothing");
            }
        }
        return false;
    }

    public synchronized int fightMonster(Monster monster) {
        Random random = new Random();
        for (int i = hunters.size() - 1; i >= 0; i--) {
            Hunter hunter = hunters.get(i);
            if (monster.getPosition().equals(hunter.getPosition())) {
                if (random.nextInt(10) <= 7) {
                    System.out.println(monster.getMonsterName() + " defeated " + hunter.getHunterName() + " at "
                            + monster.getPosition());

                    removeHunter(hunter, hunter.getPosition());
                    System.out.println("Remaining hunters: " + getHunters().size());
                    return 1;
                } else {
                    System.out.println(hunter.getName() + " caught " + monster.getMonsterName() + " at "
                            + monster.getPosition());
                    monster.setCaptured(true);
                    removeMonster(monster, monster.getPosition());
                    return -1;
                }
            }
        }
        return 0;
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

    public String[][] getMap() {
        return map;
    }

    public void setMap(String[][] map) {
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
                    case "H":
                        message += " H ";
                        break;
                    case "M":
                        message += " M ";
                        break;
                    default:
                        message += " . ";
                        break;
                }
            }
            message += "\n";
        }
        return message;
    }

}
