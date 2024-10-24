package es.ies.puerto.exercise09;

import es.ies.puerto.exercise09.MillenniumFalconSimulator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.TestUtilities;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MillenniumFalconSimulatorTest extends TestUtilities {
    MillenniumFalconSimulator instanceForThread1;
    MillenniumFalconSimulator instanceForThread2;

    @BeforeEach
    public void beforeEach(){
        instanceForThread1 = new MillenniumFalconSimulator();
        instanceForThread2 = new MillenniumFalconSimulator();
        instanceForThread1.setName("nameTest1");
        instanceForThread2.setName("nameTest2");
    }

    @Test
    public void millenniumFalconSimulatorTest() throws InterruptedException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Thread thread1 = new Thread(instanceForThread1);
        Thread thread2 = new Thread(instanceForThread2);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        String output = outContent.toString();
        assertTrue(output.contains("Speed and shields at maximum capacity! We're saved")
                || output.contains("Millennium Falcon has been destroyed.")
                , MESSAGE_ERROR);
    }
    
}