package com.sample.web;

import org.junit.Test;

import static io.restassured.RestAssured.when;

public class SampleControllerIT {

    @Test
    public void testRestAssured() {
        when().
                get("/ping").
                then().
                statusCode(200);
    }
}
