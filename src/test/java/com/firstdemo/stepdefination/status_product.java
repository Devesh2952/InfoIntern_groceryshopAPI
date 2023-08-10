package com.firstdemo.stepdefination;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class status_product {
    Object obj;
    Response response;
    Response response1;
    Response response2;
    @When("user enter {string} to get status")
    public void user_enter_to_get_status(String string) {
        this.response= RestAssured.get(string);
    }
    @Then("user will get status as up and {int} sourcecode")
    public void user_will_get_status_as_up_and_sourcecode(Integer int1) {
       System.out.println(this.response.getBody().toString());
        Assert.assertEquals(this.response.getStatusCode(),200);
    }




    @When("user enter {string} to get product list of inventory")
    public void user_enter_to_get_product_list_of_inventory(String string) {
        this.response1=RestAssured.get(string);
    }
    @Then("user will get inventory product and {int} sourcecode")
    public void user_will_get_inventory_product_and_sourcecode(Integer int1) {
        System.out.println(
                "Product list available in Inventory"+
                        this.response1.getBody().asString()
        );
        Assert.assertEquals(this.response1.getStatusCode(),200);
    }





    @When("user enter {string} to get single product")
    public void user_enter_to_get_single_product(String string) {
        String url="http://simple-grocery-store-api.online///products/:productId";
        RequestSpecification request = RestAssured.given();
//        request.contentType(ContentType.JSON);

        // Add query parameters
        String productId = "1709";

        request.baseUri("http://simple-grocery-store-api.online/");
        request.basePath("products/{:productId}");
        request.pathParam(":productId", productId);

        // Create JSON payload
//        String payload = "{\"productId\": \"1234\"}";
//        request.body(payload);

        response = request.get();
        request.log().all();
    }
    @Then("user will get sourcecode {int} ok")
    public void user_will_get_sourcecode_ok(Integer int1) {
        int actualStatusCode = response.getStatusCode();
        Assert.assertEquals(actualStatusCode, int1);
        int stock=response.path("current-stock");
        int id=response.path("id");
        System.out.println("Current Available stock of productId "+id+" is :- "+stock);
      
    }

}
