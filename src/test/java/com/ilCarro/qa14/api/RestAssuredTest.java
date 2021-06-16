package com.ilCarro.qa14.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuredTest {

    @Test
    public void postNewUserRegistrationTest() {
        RequestSpecification httpRequest = io.restassured.RestAssured.given();

        Response response = httpRequest.
                given().contentType(ContentType.JSON)
                .given().header("Authorization", "dHR0dEBoaC55eTpUdFl5MTIzNDU2Nw==")
                .request().body("{\n" +
                        "  \"first_name\": \"Tester\",\n" +
                        "  \"second_name\": \"Tester\"\n" +
                        "}")
                .when().post("https://java-3-ilcarro-team-b.herokuapp.com/registration");

        String responseBody = response.getBody().asString();
        System.out.println(responseBody);

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);

        JsonElement parsed = new JsonParser().parse(responseBody);
        String fName = parsed.getAsJsonObject().get("first_name").toString();
        System.out.println(fName);

        Assert.assertEquals(statusCode, 200, "Bug:status code is coming different");
    }
}
