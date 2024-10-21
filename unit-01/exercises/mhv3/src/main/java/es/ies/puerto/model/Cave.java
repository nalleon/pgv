import es.ies.puerto.model.Monster;

import java.util.concurrent.Semaphore;

public class Cave {
    private final Semaphore semaphore;

    public Cave(int capacity) {
        this.semaphore = new Semaphore(capacity);
    }

    public void enterCave(Monster monster) throws InterruptedException {
        semaphore.acquire();
        System.out.println(monster.getMonsterName() + " has entered the cave.");
    }

    public void exitCave(Monster monster) {
        semaphore.release();
        System.out.println(monster.getMonsterName() + " has exited the cave.");
    }
}
