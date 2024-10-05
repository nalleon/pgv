package es.ies.puerto.exercise10;

import es.ies.puerto.exercise10.MagicBattle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.TestUtilities;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MagicBattleTest extends TestUtilities {
    MagicBattle instanceForThread1;
    MagicBattle instanceForThread2;

    @BeforeEach
    public void beforeEach(){
        instanceForThread1 = new MagicBattle();
        instanceForThread2 = new MagicBattle();
        instanceForThread1.setName("nameTest1");
        instanceForThread2.setName("nameTest2");
    }

    @Test
    public void citySavingByHeroesTest() throws InterruptedException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Thread thread1 = new Thread(instanceForThread1);
        Thread thread2 = new Thread(instanceForThread2);


        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        String output = outContent.toString();
        assertTrue(output.contains(" has won the battle!"), MESSAGE_ERROR);
    }
}
