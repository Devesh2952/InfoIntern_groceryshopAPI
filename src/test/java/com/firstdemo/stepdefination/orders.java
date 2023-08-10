package com.firstdemo.stepdefination;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

public class orders {

    Response response;

    // Api client class object creation to get tocken.
    API_client obj = new API_client();
    String tocken = obj.tocken;

    // Cart_First class object creation for getting cartId
    cart_first obj2=new cart_first();
    String cartId= obj2.cardId;


    String orderId;

    String str="{\"cartId\":\"BX20-Tv3qlXOX1JX4MzYW\",\n" +
            "    \"customerName\":\"Devesh Sahare\",\n" +
            "    \"comment\":\"api testing\"}";

    String str2="{ \"customerName\":\"pankaj mishra\",\n" +
            "    \"comment\":\"tools\"}";
    @When("user enter {string} to create a order")
    public void user_enter_to_create_a_order(String string) {

        RequestSpecification request =RestAssured.given();


                request.baseUri("http://simple-grocery-store-api.online/");
                request.basePath("orders");
                request.header("Content-Type","application/json");
                request.header("Authorization",tocken);
                request.body(str);

        this.response=request.post();
        orderId=this.response.getBody().path("orderId");
    }
    @Then("he get orderId and {int} created response")
    public void he_get_order_id_and_created_response(Integer int1) {

        String body =this.response.getBody().asString();
        int src =this.response.getStatusCode();
        System.out.println("<<<<---  Response Body  ---->>>>>"+body);
        Assert.assertEquals(src,int1);
    }




    @When("user enter {string} to get order detail")
    public void user_enter_to_get_order_detail(String string) {
        RequestSpecification request =RestAssured.given();


                request.baseUri("http://simple-grocery-store-api.online/");
                request.basePath("orders/{:orderId}");
                request.pathParam(":orderId",orderId);
                request.header("Authorization",tocken);


        this.response=request.get();
    }
    @Then("he get {int} ok response")
    public void he_get_ok_response(Integer int1) {

        String body =this.response.getBody().asString();
        int src =this.response.getStatusCode();
        System.out.println("<<<<---  Response Body  ---->>>>>"+body);
        Assert.assertEquals(src,int1);
    }




    @When("user enter {string} to get all order list")
    public void user_enter_to_get_all_order_list(String string) {
        RequestSpecification request =RestAssured.given();

                request.baseUri("http://simple-grocery-store-api.online/");
                request.basePath("orders");
                request.header("Authorization",tocken);

        this.response=request.get();
    }
    @Then("he get {int} ok response for all order")
    public void he_get_ok_response_for_all_order(Integer int1) {

        String body =this.response.getBody().asString();
        int src =this.response.getStatusCode();
        System.out.println("<<<<---  Response Body  ---->>>>>"+body);
        Assert.assertEquals(src,int1);

    }



    @When("user enter {string} to update customerName from order")
    public void user_enter_to_update_customer_name_from_order(String string) {
        RequestSpecification request =RestAssured.given();

                request.baseUri("http://simple-grocery-store-api.online/");
                request.basePath("orders/{:orderId}");
                request.pathParam(":orderId",orderId);
                request.header("Content-Type","application/json");
                request.header("Authorization",tocken);
                request.body(str2);

        this.response=request.patch();
    }
    @Then("he get {int} No Content response")
    public void he_get_no_content_response(Integer int1) {

        String body =this.response.getBody().asString();
        int src =this.response.getStatusCode();
        System.out.println("<<<<---  Response Body  ---->>>>>"+body);
        Assert.assertEquals(src,int1);

    }



    @When("user enter {string} to delete order")
    public void user_enter_to_delete_order(String string) {

        RequestSpecification request =RestAssured.given();

        request.baseUri("http://simple-grocery-store-api.online/");
        request.basePath("orders/{:orderId}");
        request.pathParam(":orderId",orderId);
        request.header("Authorization",tocken);
        request.body(str2);

        this.response=request.delete();

    }
    @Then("he get {int} No Content response for delete API")
    public void he_get_no_content_response_for_delete_api(Integer int1) {

        String body =this.response.getBody().asString();
        int src =this.response.getStatusCode();
        System.out.println("<<<<---  Response Body  ---->>>>>"+body);
        Assert.assertEquals(src,int1);

    }
}
