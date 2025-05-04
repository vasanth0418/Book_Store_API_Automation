package com.bookstore.tests;

import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.bookstore.utils.RequestBuilder;
import com.bookstore.utils.ConfigManager;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.qameta.allure.*;

public class BooksExtendedTests {

    private String baseUrl;
    private int createdBookId;

    @BeforeClass
    public void setup() {
        baseUrl = ConfigManager.getBaseUrl();
    }

    @Test(priority = 1)
    @Description("Creates a book for update testing")
    @Severity(SeverityLevel.CRITICAL)
    public void createBookForUpdateTest() {
        String requestBody = "{ \"title\": \"Book for Update\", \"author\": \"Updater\", \"description\": \"Created for update test\", \"price\": 18.50 }";

        Response response = given().spec(RequestBuilder.getRequestSpec())
            .body(requestBody)
            .when()
            .post(baseUrl + "/books")
            .then()
            .statusCode(200)
            .extract().response();

        createdBookId = response.jsonPath().getInt("id");
    }

    @Test(priority = 2, dependsOnMethods = "createBookForUpdateTest")
    @Description("Updates the created book and verifies updated price")
    @Severity(SeverityLevel.CRITICAL)
    public void updateBookPositiveTest() {
        String updatedBody = "{ \"title\": \"Book Updated\", \"author\": \"Updater\", \"description\": \"Updated desc\", \"price\": 25.00 }";

        given().spec(RequestBuilder.getRequestSpec())
            .body(updatedBody)
            .when()
            .put(baseUrl + "/books/" + createdBookId)
            .then()
            .statusCode(200)
            .body("price", equalTo(25.00f));
    }

    @Test(priority = 3, dependsOnMethods = "createBookForUpdateTest")
    @Description("Verifies response headers for get book API")
    @Severity(SeverityLevel.MINOR)
    public void verifyResponseHeadersTest() {
        given().spec(RequestBuilder.getRequestSpec())
            .when()
            .get(baseUrl + "/books/" + createdBookId)
            .then()
            .statusCode(200)
            .header("Content-Type", containsString("application/json"));
    }

    @Test(priority = 4)
    @Description("Attempts to create a book with invalid negative price")
    @Severity(SeverityLevel.NORMAL)
    public void createBookInvalidPriceTest() {
        String badRequestBody = "{ \"title\": \"Bad Book\", \"author\": \"Bad Author\", \"description\": \"Invalid Price\", \"price\": -10.0 }";

        given().spec(RequestBuilder.getRequestSpec())
            .body(badRequestBody)
            .when()
            .post(baseUrl + "/books")
            .then()
            .statusCode(422);
    }
}
