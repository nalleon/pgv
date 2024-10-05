package es.ies.puerto.exercise03;

import es.ies.puerto.exercise03.DroidFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.TestUtilities;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DroidFactoryTest extends TestUtilities {

    DroidFactory instanceForThread1;
    DroidFactory instanceForThread2;
    DroidFactory instanceForThread3;


    @BeforeEach
    public void beforeEach(){
        instanceForThread1 = new DroidFactory();
        instanceForThread2 = new DroidFactory();
        instanceForThread3 = new DroidFactory();
        instanceForThread1.setName("assembler");
        instanceForThread2.setName("activator");
        instanceForThread2.setName("default");
    }

    @Test
    public void droidFactoryTest() throws InterruptedException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));


        Thread thread1 = new Thread(instanceForThread1);
        Thread thread2 = new Thread(instanceForThread2);


        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        String output = outContent.toString();
        assertTrue(output.contains(" has been assembled") || output.contains(" has been activated"), MESSAGE_ERROR);

        Thread thread3 = new Thread(instanceForThread3);
        thread3.start();
        thread3.join();

        String outputDefault = outContent.toString();
        assertTrue(outputDefault.contains("ERROR: Factory is in shambles without assemblers and activator"), MESSAGE_ERROR);

    }

}
