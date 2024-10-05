package es.ies.puerto.exercise04;

import es.ies.puerto.exercise02.HuntHorrocruxes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.TestUtilities;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuidditchMatchTest extends TestUtilities {
    QuidditchMatch classForThread1;
    QuidditchMatch classForThread2;
    QuidditchMatch classForThread3;


    @BeforeEach
    public void beforeEach(){
        classForThread1 = new  QuidditchMatch();
        classForThread2 = new  QuidditchMatch();
        classForThread3 = new  QuidditchMatch();
        classForThread1.setName("nameTest1");
        classForThread1.setFinder(false);
        classForThread2.setName("nameTest2");
        classForThread2.setFinder(false);
        classForThread3.setName("nameTest3");
        classForThread3.setFinder(true);

    }

    @Test
    public void quidditchMatchTest() throws InterruptedException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Thread thread1 = new Thread(classForThread1);
        Thread thread2 = new Thread(classForThread2);
        Thread thread3 = new Thread(classForThread3);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        String output = outContent.toString();
        assertTrue(output.contains("has won"), MESSAGE_ERROR);
    }
}
