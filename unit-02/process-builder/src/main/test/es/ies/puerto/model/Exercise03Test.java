package es.ies.puerto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestUtilities;

public class Exercise03Test extends TestUtilities {
    public static final String COMMAND_TRUE = "ls -l";
    public static final String COMMAND_FALSE = "cat test.txt";

    @Test
    public void processPingTest(){
        boolean resultTrue = Exercise03.redirectToFile(COMMAND_TRUE);
        boolean resultFalse= Exercise03.redirectToFile(COMMAND_FALSE);
        Assertions.assertTrue(resultTrue, MESSAGE_ERROR);
        Assertions.assertFalse(resultFalse, MESSAGE_ERROR);
    }
}
