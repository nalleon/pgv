package es.ies.puerto.controller;

import es.ies.puerto.model.Hunter;
import es.ies.puerto.model.MapGame;
import es.ies.puerto.model.Monster;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MonsterHunter {

    MapGame mapGame;
    List<Monster> monsterList;
    List<Hunter> hunterList;

    public MonsterHunter() {
        mapGame = new MapGame();
        monsterList = new ArrayList<>();
        hunterList = new ArrayList<>();
    }



    /**
     * Getters/setters
     */
    public MapGame getMapGame() {
        return mapGame;
    }

    public void setMapGame(MapGame mapGame) {
        this.mapGame = mapGame;
    }

    public List<Monster> getMonsterList() {
        return monsterList;
    }

    public void setMonsterList(List<Monster> monsterList) {
        this.monsterList = monsterList;
    }

    public List<Hunter> getHunterList() {
        return hunterList;
    }

    public void setHunterList(List<Hunter> hunterList) {
        this.hunterList = hunterList;
    }



    public static void main(String[] args) {
        Hunter hunter1 = new Hunter("Hunter1");
        Hunter hunter2 = new Hunter("Hunter2");

        Monster monster1 = new Monster(1, "Monster1");
        Monster monster2 = new Monster(2, "Monster2");

        MapGame mapGame = new MapGame(5);

        List<Monster> monsterList = new ArrayList<>(Arrays.asList(monster1, monster2));
        List<Hunter> hunterList = new ArrayList<>(Arrays.asList(hunter1, hunter2));

        MonsterHunter monsterHunterGame = new MonsterHunter();
        monsterHunterGame.setMapGame(mapGame);
        monsterHunterGame.setHunterList(hunterList);
        monsterHunterGame.setMonsterList(monsterList);

        createLocations(monsterHunterGame);


        for (Hunter hunter : hunterList) {
            monsterHunterGame.getMapGame().addHunter(hunter, hunter.getPosition());
        }
        for (Monster monster : monsterList) {
            monsterHunterGame.getMapGame().addMonster(monster);
        }



        Thread hunter1Thread = new Thread(hunter1);
        Thread hunter2Thread = new Thread(hunter2);

        hunter1Thread.start();
        hunter2Thread.start();


        System.out.println("Monsters to catch:" + monsterHunterGame.getMonsterList().size());
        boolean gameGoingOn = true;

        while(gameGoingOn){

            for (Hunter hunter : hunterList) {
                String newPosition = monsterHunterGame.getMapGame().movement();
                monsterHunterGame.getMapGame().moveHunter(hunter, newPosition);
                monsterHunterGame.getMapGame().catchMonster(monsterHunterGame.getMonsterList(), hunter);
            }

            System.out.println(monsterHunterGame.getMapGame());

            if (monsterHunterGame.getMapGame().getMonsters().isEmpty()) {
                System.out.println("All monster have been caught. Game is over!");
                gameGoingOn = false;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void createLocations(MonsterHunter monsterHunter) {
        for (Hunter hunter : monsterHunter.getHunterList()) {
            String location;
            do {
                location = monsterHunter.getMapGame().generateLocations();
            } while (checkPositionsOverlap(location, monsterHunter.getHunterList(), monsterHunter.getMonsterList()));
            hunter.setPosition(location);
        }

        for (Monster monster : monsterHunter.getMonsterList()) {
            String location;
            do {
                location = monsterHunter.getMapGame().generateLocations();
            } while (checkPositionsOverlap(location, monsterHunter.getHunterList(), monsterHunter.getMonsterList()));
            monster.setPosition(location);
        }

    }

    public static boolean checkPositionsOverlap(String position, List<Hunter> hunters, List<Monster> monsters){
        for (Hunter hunter : hunters) {
            if (hunter.getPosition() != null && hunter.getPosition().equals(position)) {
                return true;
            }
        }
        for (Monster monster : monsters) {
            if (monster.getPosition() != null && monster.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }
}
