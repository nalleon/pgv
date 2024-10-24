package es.ies.puerto.exercise02;

import es.ies.puerto.exercise02.HuntHorrocruxes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.TestUtilities;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HuntHorrocruxesTest extends TestUtilities {
    HuntHorrocruxes instanceForThread1;
    HuntHorrocruxes instanceForThread2;
    HuntHorrocruxes instanceForThread3;


    @BeforeEach
    public void beforeEach(){
        instanceForThread1 = new HuntHorrocruxes();
        instanceForThread2 = new HuntHorrocruxes();
        instanceForThread3 = new HuntHorrocruxes();
        instanceForThread1.setName("Harry");
        instanceForThread1.setLocation("Location1");
        instanceForThread2.setName("Ron");
        instanceForThread2.setLocation("Location2");
        instanceForThread3.setName("Hermione");
        instanceForThread3.setLocation("Location3");

    }

    @Test
    public void huntHorrocruxesTest() throws InterruptedException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));


        Thread thread1 = new Thread(instanceForThread1);
        Thread thread2 = new Thread(instanceForThread2);
        Thread thread3 = new Thread(instanceForThread3);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        String output = outContent.toString();
        assertTrue(output.contains("has not found the Horrocrux in ") ||
                output.contains(" has found a Horrocrux at"), MESSAGE_ERROR);
    }

}
