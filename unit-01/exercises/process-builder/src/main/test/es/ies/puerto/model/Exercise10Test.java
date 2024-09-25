package es.ies.puerto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import utilities.TestUtilities;

public class Exercise10Test extends TestUtilities {

    public static final String COMMAND_LINUX = "ls -l";
    public static final String COMMAND_FILTER = "grep \".txt\"";

    public static final String COMMAND_LINUX_FALSE = "ls -l";
    public static final String COMMAND_FILTER_FALSE = "grep \"test\"";

    @Test
    public void consumerReadProducerTest(){
        Assertions.assertTrue(Exercise10.consumerReadProducer(COMMAND_LINUX,COMMAND_FILTER), MESSAGE_ERROR);
    }
}
