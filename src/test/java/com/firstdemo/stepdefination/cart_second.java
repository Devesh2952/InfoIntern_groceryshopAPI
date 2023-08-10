package com.firstdemo.stepdefination;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.mortbay.jetty.Request;
import org.testng.Assert;

public class cart_second {

    String str="{\"quantity\":\"3\"}";
    String str2="{\n" +
            "    \"productId\":\"1709\",\n" +
            "    \"quantity\":7\n" +
            "}";
    Response response;
    // Cart_First class object creation for getting cartId and itemId
    cart_first obj=new cart_first();
    String cartId= obj.cardId;
    String itemId=obj.itemId;





    @When("user enter {string} to modify quantity item in cart")
    public void user_enter_to_modify_quantity_item_in_cart(String string) {

        RequestSpecification request =RestAssured.given();


                request.baseUri("http://simple-grocery-store-api.online/");
                request.basePath("carts/{:cartId}/items/{:itemId}");
                request.pathParam(":cartId",cartId);
                request.pathParam(":itemId",itemId);
                request.header("Content-Type","application/json");
                request.body(str);

                this.response=request.patch();
    }
    @Then("user get {int} No Content response for modify")
    public void user_get_no_content_response_for_modify(Integer int1) {
        String body =this.response.getBody().asString();
        int src =this.response.getStatusCode();
        System.out.println("<<<<---  Response Body  ---->>>>>"+body);
        Assert.assertEquals(src,int1);
    }




    @When("user enter {string} to replace an item")
    public void user_enter_to_replace_an_item(String string) {
        RequestSpecification request =RestAssured.given();


        request.baseUri("http://simple-grocery-store-api.online/");
        request.basePath("carts/{:cartId}/items/{:itemId}");
        request.pathParam(":cartId",cartId);
        request.pathParam(":itemId",itemId);
        request.header("Content-Type","application/json");
        request.body(str2);

        this.response=request.patch();
    }
    @Then("User get {int} No Content response for replace")
    public void user_get_no_content_response_for_replace(Integer int1) {

            String body =this.response.getBody().asString();
            int src =this.response.getStatusCode();
            System.out.println("<<<<---  Response Body  ---->>>>>"+body);
            Assert.assertEquals(src,int1);
    }


    @When("user enter {string} to detele a item from cart")
    public void user_enter_to_detele_a_item_from_cart(String string) {
        RequestSpecification request =RestAssured.given();


        request.baseUri("http://simple-grocery-store-api.online/");
        request.basePath("carts/{:cartId}/items/{:itemId}");
        request.pathParam(":cartId",cartId);
        request.pathParam(":itemId",itemId);

        this.response=request.delete();

    }
    @Then("user get {int} No Content response for Delete")
    public void user_get_no_content_response_for_delete(Integer int1) {
        String body =this.response.getBody().asString();
        int src =this.response.getStatusCode();
        System.out.println("<<<<---  Response Body  ---->>>>>"+body);
        Assert.assertEquals(src,int1);
}
}
