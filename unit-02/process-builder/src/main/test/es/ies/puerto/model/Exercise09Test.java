package es.ies.puerto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestUtilities;

public class Exercise09Test extends TestUtilities {
    public static final String COMMAND_LINUX = "ping -t google.com";
    public static final int MAX_TIME = 10000;
    @Test
    public void stopProcessAfterTimeTest(){
        Assertions.assertTrue(Exercise09.stopProcessAfterTime(MAX_TIME, COMMAND_LINUX), MESSAGE_ERROR);
        Assertions.assertFalse(Exercise09.stopProcessAfterTime(-1, COMMAND_LINUX), MESSAGE_ERROR);
    }
}
