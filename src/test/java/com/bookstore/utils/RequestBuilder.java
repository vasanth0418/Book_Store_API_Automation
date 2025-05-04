package com.bookstore.utils;

import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;

public class RequestBuilder {
    public static RequestSpecification getRequestSpec() {
        return RestAssured.given()
                .contentType("application/json")
                .accept("application/json");
    }
}
