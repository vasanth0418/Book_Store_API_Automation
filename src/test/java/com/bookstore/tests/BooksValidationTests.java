package com.bookstore.tests;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.bookstore.utils.RequestBuilder;
import com.bookstore.utils.ConfigManager;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class BooksValidationTests {

    private String baseUrl;

    @BeforeClass
    public void setup() {
        baseUrl = ConfigManager.getBaseUrl();
    }

    @Test
    public void createBookMissingTitleNegativeTest() {
        String requestBody = "{ \"author\": \"QA Tester\", \"description\": \"Missing title field\", \"price\": 12.99 }";

        given().spec(RequestBuilder.getRequestSpec())
            .body(requestBody)
            .when()
            .post(baseUrl + "/books")
            .then()
            .statusCode(422)  // Expecting validation error (FastAPI default)
            .body("detail", notNullValue());
    }

    @Test
    public void updateNonExistentBookNegativeTest() {
        String requestBody = "{ \"title\": \"Nonexistent Update\", \"author\": \"No One\", \"description\": \"Trying to update non-existing book\", \"price\": 10.0 }";

        given().spec(RequestBuilder.getRequestSpec())
            .body(requestBody)
            .when()
            .put(baseUrl + "/books/999999")
            .then()
            .statusCode(404);
    }

    @Test
    public void getAllBooksTest() {
        given().spec(RequestBuilder.getRequestSpec())
            .when()
            .get(baseUrl + "/books")
            .then()
            .statusCode(200)
            .body("size()", greaterThanOrEqualTo(0));
    }
}
