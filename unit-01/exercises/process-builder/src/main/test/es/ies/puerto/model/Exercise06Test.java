package es.ies.puerto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestUtilities;

public class Exercise06Test extends TestUtilities {
    public static final String EXECUTABLE = "java";
    public static final String CLASS = "es.ies.puerto.model.WorkerClass";
    public static final int NUM_PROCESS = 5;
    public static final String CLASS_PATH = System.getProperty("java.class.path");

    @Test
    public void runInstancesTest(){
        Assertions.assertTrue(
                Exercise06.runInstances(NUM_PROCESS, EXECUTABLE, CLASS_PATH, CLASS), MESSAGE_ERROR);
        Assertions.assertFalse(
                Exercise06.runInstances(NUM_PROCESS, EXECUTABLE, CLASS_PATH, "es.test"), MESSAGE_ERROR);
    }
}
