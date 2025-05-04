package com.bookstore.utils;

import io.restassured.response.Response;
import static org.testng.Assert.*;

public class ResponseValidator {

    public static void validateStatusCode(Response response, int expectedStatus) {
        assertEquals(response.statusCode(), expectedStatus, "Unexpected status code");
    }

    public static void validateHeader(Response response, String headerName, String expectedValue) {
        String actual = response.header(headerName);
        assertNotNull(actual, "Header '" + headerName + "' not found");
        assertTrue(actual.contains(expectedValue), "Header value mismatch for '" + headerName + "'");
    }
}
