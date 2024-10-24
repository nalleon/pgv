package es.ies.puerto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utilities.TestUtilities;

public class Exercise01Test extends TestUtilities {

    public static final String COMMAND = "ping -c 3 google.com";

    @Test
    public void processPingTest(){
        boolean result = Exercise01.processPing(COMMAND);
        Assertions.assertTrue(result, MESSAGE_ERROR);
    }


}
