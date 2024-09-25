package es.ies.puerto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestUtilities;

public class Exercise07Test extends TestUtilities {

    public static final String[] EXEC_INFO_CONSUMER = {
            "java",
            "-cp",
            "bin",
            "src/main/java/es/ies/puerto/model/DataConsumer.java"
    };

    public static final String[] EXEC_INFO_PRODUCER = {
            "java",
            "-cp",
            "bin",
            "src/main/java/es/ies/puerto/model/DataProducer.java"
    };


    public static final String[] EXEC_INFO_CONSUMER_FALSE = {
            "java",
            "-cp",
            "bin",
            "src/main/java/es/ies/puerto/model/test.java"
    };

    public static final String[] EXEC_INFO_PRODUCER_FALSE = {
            "java",
            "-cp",
            "bin",
            "src/main/java/es/ies/puerto/model/test.java"
    };

    @Test
    public void producerConsumerProcessesTest(){
        Assertions.assertTrue(
                Exercise07.producerConsumerProcesses(EXEC_INFO_PRODUCER, EXEC_INFO_CONSUMER), MESSAGE_ERROR);
        Assertions.assertFalse(
                Exercise07.producerConsumerProcesses(EXEC_INFO_PRODUCER_FALSE, EXEC_INFO_CONSUMER), MESSAGE_ERROR);
        Assertions.assertFalse(
                Exercise07.producerConsumerProcesses(EXEC_INFO_PRODUCER, EXEC_INFO_CONSUMER_FALSE), MESSAGE_ERROR);
    }


}
