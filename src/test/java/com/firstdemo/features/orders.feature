Feature: All orders API validation

  @order @created
  Scenario: Create a new order API validation
    When user enter "http://simple-grocery-store-api.online/orders" to create a order
    Then he get orderId and 201 created response


  @order @singleorder
  Scenario: Get a single order API validation
    When user enter "http://simple-grocery-store-api.online/orders/:orderId" to get order detail
    Then he get 200 ok response

  @order @allorder
  Scenario: Get all orders API validation
    When user enter "http://simple-grocery-store-api.online/orders" to get all order list
    Then he get 200 ok response for all order


  @order @update
  Scenario: Update an order API validation
    When user enter "http://simple-grocery-store-api.online/orders/:orderId" to update customerName from order
    Then he get 204 No Content response

  @order @delete
  Scenario: Delete an order API validation
    When user enter "http://simple-grocery-store-api.online/orders/:orderId" to delete order
    Then he get 204 No Content response for delete API