package com.firstdemo.stepdefination;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;


public class test01 {
    Response response;
    @When(":user enter {string} to open google")
    public void user_enter_to_open_google(String string) {
       this.response= RestAssured.get(string);

    }

    @Then(":verify that  {int} response is coming")
    public void verify_that_response_is_comming(Integer int1) {
        Assert.assertEquals(this.response.getStatusCode(),200);

    }
}
