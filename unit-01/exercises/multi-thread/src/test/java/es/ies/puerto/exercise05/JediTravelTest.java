package es.ies.puerto.exercise05;

import es.ies.puerto.exercise05.JediTravel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.TestUtilities;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class JediTravelTest extends TestUtilities {

    JediTravel instanceForThread1;
    JediTravel instanceForThread2;

    @BeforeEach
    public void beforeEach(){
        instanceForThread1 = new JediTravel();
        instanceForThread2 = new JediTravel();
        instanceForThread1.setName("nameTest1");
        instanceForThread2.setName("nameTest2");
    }

    @Test
    public void pokemonBattleTest() throws InterruptedException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));


        Thread thread1 = new Thread(instanceForThread1);
        Thread thread2 = new Thread(instanceForThread2);


        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        String output = outContent.toString();
        assertTrue(output.contains(instanceForThread2.getName() +" has found all clues from the dark side!") ||
                output.contains(instanceForThread1.getName() +"  has found all clues from the dark side! "),
                MESSAGE_ERROR);
    }

}
