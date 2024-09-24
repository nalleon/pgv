package es.ies.puerto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.TestUtilities;

public class Exercise02Test extends TestUtilities {
    Exercise02 exercise;

    public static final String[] COMMANDS = {
            "ping -c 3 google.com",
            "ls -l ./",
            "echo \"Test echo\""
    };

    @BeforeEach
    public void beforeEach(){

    }


    @Test
    public void executeCommandTest(){
        boolean result = Exercise02.executeCommand(COMMANDS);
        Assertions.assertTrue(result, MESSAGE_ERROR);
    }

     @Test
    public void runProcessTest(){
         Assertions.assertEquals(0, Exercise02.runProcesses("ls -l"), MESSAGE_ERROR);
         Assertions.assertEquals(1, Exercise02.runProcesses("cat test.txt"), MESSAGE_ERROR);
         Assertions.assertEquals(2, Exercise02.runProcesses("ping -c 1 256.256.256.256"), MESSAGE_ERROR);
    }

}
