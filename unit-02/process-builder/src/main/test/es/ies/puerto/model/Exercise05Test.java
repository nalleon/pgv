package es.ies.puerto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestUtilities;

public class Exercise05Test extends TestUtilities {
    public static final String COMMAND_TRUE = "cat test.txt";
    public static final String COMMAND_FALSE = "ls -l";

    @Test
    public void redirectErrorsTest(){
        Assertions.assertTrue(Exercise05.redirectErrors(COMMAND_TRUE), MESSAGE_ERROR);
        Assertions.assertFalse(Exercise05.redirectErrors(COMMAND_FALSE), MESSAGE_ERROR);
    }
}
