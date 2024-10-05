package es.ies.puerto.exercise06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.TestUtilities;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TardisSimulationTest extends TestUtilities {
    TardisSimulation instanceForThread1;
    TardisSimulation instanceForThread2;

    @BeforeEach
    public void beforeEach(){
        instanceForThread1 = new TardisSimulation();
        instanceForThread2 = new TardisSimulation();
        instanceForThread1.setPeriodName("nameTest1");
        instanceForThread2.setPeriodName("nameTest2");
    }

    @Test
    public void tardisSimulationTest() throws InterruptedException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));


        Thread thread1 = new Thread(instanceForThread1);
        Thread thread2 = new Thread(instanceForThread2);


        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        String output = outContent.toString();
        assertTrue(output.contains("Reached the end of " + instanceForThread1.getPeriodName() + " first!") ||
                        output.contains("Reached the end of " + instanceForThread2.getPeriodName() + " first!"),
                        MESSAGE_ERROR);
    }

}
