package es.ies.puerto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestUtilities;

import java.util.List;

public class Exercise08Test extends TestUtilities {
    public static final String COMMAND_LINUX = "ping -c 3 google.com";

    @Test
    public void commandTimeTest(){
        List<Integer> result = Exercise08.commandTime(COMMAND_LINUX);
        Assertions.assertEquals(2, result.size(), MESSAGE_ERROR);
    }
}
