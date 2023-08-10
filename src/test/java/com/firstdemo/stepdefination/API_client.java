package com.firstdemo.stepdefination;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class API_client {

    Response response;
    String tocken;
    String str ="{ \"clientName\":\"khla gupta\",\n" +
            "    \"clientEmail\":\"llioa23@gmail.com\"}";
    @When("User enter the {string} to register")
    public void user_enter_the_to_register(String string) {
        RequestSpecification request = RestAssured.given();
        request .baseUri("http://simple-grocery-store-api.online/");
        request .basePath("api-clients");
        request.header("Content-Type","application/json");
        request.body(str);


        response=request.post();
        request.log().all();
        tocken=response.getBody().path("accessToken");
        request.log().all();

        System.out.println("Authorization Tocken is :- "+tocken);
    }
    @Then("tocken and {int} created response gerated")
    public void tocken_and_created_response_gerated(Integer int1) {

        int src =response.getStatusCode();
        Assert.assertEquals(src,int1);
        System.out.println("Authorization Tocken is :- "+tocken);
    }

}
