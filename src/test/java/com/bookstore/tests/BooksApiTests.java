package com.bookstore.tests;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.bookstore.utils.RequestBuilder;
import com.bookstore.utils.ConfigManager;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class BooksApiTests {

    private String baseUrl;
    private int createdBookId;

    @BeforeClass
    public void setup() {
        baseUrl = ConfigManager.getBaseUrl();
    }

    @Test(priority = 1)
    public void createBookPositiveTest() {
        String requestBody = "{ \"title\": \"API Automation Book\", \"author\": \"QA Tester\", \"description\": \"Book created by automation\", \"price\": 29.99 }";
        
        Response response = given().spec(RequestBuilder.getRequestSpec())
            .body(requestBody)
            .when()
            .post(baseUrl + "/books")
            .then()
            .statusCode(200)
            .body("title", equalTo("API Automation Book"))
            .extract().response();
        
        createdBookId = response.jsonPath().getInt("id");
    }

    @Test(priority = 2, dependsOnMethods = "createBookPositiveTest")
    public void getBookPositiveTest() {
        given().spec(RequestBuilder.getRequestSpec())
            .when()
            .get(baseUrl + "/books/" + createdBookId)
            .then()
            .statusCode(200)
            .body("id", equalTo(createdBookId));
    }

    @Test(priority = 3)
    public void getBookNegativeTest() {
        given().spec(RequestBuilder.getRequestSpec())
            .when()
            .get(baseUrl + "/books/999999")
            .then()
            .statusCode(404);
    }

    @Test(priority = 4, dependsOnMethods = "createBookPositiveTest")
    public void deleteBookPositiveTest() {
        given().spec(RequestBuilder.getRequestSpec())
            .when()
            .delete(baseUrl + "/books/" + createdBookId)
            .then()
            .statusCode(204);
    }
}
