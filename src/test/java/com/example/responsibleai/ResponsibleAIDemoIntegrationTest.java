package com.example.responsibleai;

import com.azure.core.exception.HttpResponseException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * ResponsibleAIDemoIntegrationTest class is responsible for testing the integration of the ResponsibleAIDemo class.
 * It contains test cases for the ResponsibleAIDemo content filter exception.
 */
public class ResponsibleAIDemoIntegrationTest {

    @Test
    public void testResponsibleAIDemoContentFilterException() {
        // Create the executable that runs the main method
        Executable executable = () -> {
            ResponsibleAIDemo.main(new String[] {});
        };

        // Assert that the exception is thrown
        HttpResponseException exception = assertThrows(HttpResponseException.class, executable);

        // Verify the exception message
        String expectedMessage = "Status code 400";
        String actualMessage = exception.getMessage();
        assert actualMessage.contains(expectedMessage)
                : "Expected message to contain: " + expectedMessage + " but was: " + actualMessage;
    }
}