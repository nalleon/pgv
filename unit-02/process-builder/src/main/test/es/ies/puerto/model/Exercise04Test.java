package es.ies.puerto.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utilities.TestUtilities;

public class Exercise04Test extends TestUtilities {
    public static final String[] EXEC_INFO = {
            "java",
            "-cp", System.getProperty("java.class.path"),
            "es.ies.puerto.model.WorkerClass",
            "exercise04.txt"
    };

    public static final String[] EXEC_INFO_FALSE = {
            "java",
            "-cp", System.getProperty("java.class.path"),
            "es.ies.puerto.model.NoClass",
            "exercise04.txt"
    };
    @Test
    public void executeAnotherClass(){
        Assertions.assertTrue(Exercise04.executeAnotherClass(EXEC_INFO), MESSAGE_ERROR);
        Assertions.assertFalse(Exercise04.executeAnotherClass(EXEC_INFO_FALSE), MESSAGE_ERROR);
    }}
