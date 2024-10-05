package es.ies.puerto.exercise07;

import es.ies.puerto.exercise07.CitySavingByHeroes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.TestUtilities;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CitySavingByHeroesTest extends TestUtilities {
    CitySavingByHeroes instanceForThread1;
    CitySavingByHeroes instanceForThread2;

    @BeforeEach
    public void beforeEach(){
        instanceForThread1 = new CitySavingByHeroes();
        instanceForThread2 = new CitySavingByHeroes();
        instanceForThread1.setHeroName("nameTest1");
        instanceForThread1.setLocationsCity(new HashSet<>(Arrays.asList("Zone1", "Zone2")));
        instanceForThread2.setHeroName("nameTest2");
        instanceForThread2.setLocationsCity(new HashSet<>(Arrays.asList("Zone1", "Zone2", "Zone3")));
        
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
        assertTrue(output.contains("has saved their city!"), MESSAGE_ERROR);
    }

}
