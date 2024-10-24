package es.ies.puerto.exercise08;

import es.ies.puerto.exercise08.StrengthCompetition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.TestUtilities;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StrengthCompetitionTest extends TestUtilities {
    StrengthCompetition instanceForThread1;
    StrengthCompetition instanceForThread2;

    @BeforeEach
    public void beforeEach(){
        instanceForThread1 = new StrengthCompetition();
        instanceForThread2 = new StrengthCompetition();
        instanceForThread1.setHeroName("nameTest1");
        instanceForThread2.setHeroName("nameTest2");
    }

    @Test
    public void strengthCompetitionTest() throws InterruptedException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Thread thread1 = new Thread(instanceForThread1);
        Thread thread2 = new Thread(instanceForThread2);


        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        String output = outContent.toString();
        assertTrue(output.contains(instanceForThread1.getHeroName() +" has won with a total of ") ||
                        output.contains(instanceForThread2.getHeroName() +" has won with a total of "),
                        MESSAGE_ERROR);
    }

}
