package com.firstdemo.stepdefination;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class cart_first {
    String str="{\"productId\":\"5851\", \"quantity\":7 }";
    Response response;
    String cardId;
    String itemId;


    @When("user enter {string} to create new cart")
    public void user_enter_to_create_new_cart(String string) {
       this.response= RestAssured.post(string);
       cardId=this.response.path("cartId");
    }
    @Then("user get {int} ok sourcecode")
    public void user_get_ok_sourcecode(Integer int1) {
        System.out.println("new cart detailes"+this.response.getBody().asString());
        Assert.assertEquals(this.response.getStatusCode(),201);
    }

    @When("user enter {string} to add product to cart")
    public void user_enter_to_add_product_to_cart(String string) {
        RequestSpecification request = RestAssured.given();
        request.baseUri("http://simple-grocery-store-api.online/");
        request.basePath("carts/{:cartId}/items");
        request.pathParam(":cartId",cardId);
        request.header("Content-Type","application/json");
        request.body(str);

        this.response=request.post();
        itemId=this.response.path("itemId");

    }
    @Then("user get product id and {int} ok response")
    public void user_get_product_id_and_ok_response(Integer int1) {
       String body =this.response.getBody().asString();
       int src =this.response.getStatusCode();
       System.out.println("<<<<---  Response Body  ---->>>>>"+body);
       Assert.assertEquals(src,int1);

    }

    @When("user enter {string} to get items in a cart")
    public void user_enter_to_get_items_in_a_cart(String string) {
        RequestSpecification request = RestAssured.given();

                request.baseUri("http://simple-grocery-store-api.online/");
                request.basePath("carts/{:cartId}/items");
                request.pathParam(":cartId",cardId);

                this.response=request.get();
    }
    @Then("user list of product and {int} ok response")
    public void user_list_of_product_and_ok_response(Integer int1) {
        String body =this.response.getBody().asString();
        int src =this.response.getStatusCode();
        System.out.println("<<<<---  Response Body  ---->>>>>"+body);
        Assert.assertEquals(src,int1);
    }


    @When("user enter {string} to get cart details and list of card items")
    public void user_enter_to_get_cart_details_and_list_of_card_items(String string) {
        RequestSpecification request = RestAssured.given();
                request.baseUri("http://simple-grocery-store-api.online/");
                request.basePath("carts/{:cartId}/items");
                request.pathParam(":cartId",cardId);

                this.response=request.get();
    }
    @Then("user get {int} ok response")
    public void user_get_ok_response(Integer int1) {
        String body =this.response.getBody().asString();
        int src =this.response.getStatusCode();
        System.out.println("<<<<---  Response Body  ---->>>>>"+body);
        Assert.assertEquals(src,int1);
    }
}
