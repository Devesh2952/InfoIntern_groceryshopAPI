Feature: Cart API validation part one
   @four @cart
  Scenario: Create a new cart API validation
    When user enter "http://simple-grocery-store-api.online/carts" to create new cart
    Then user get 201 ok sourcecode

   @five @cart
  Scenario: Add an item to cart API validation
    When user enter "http://simple-grocery-store-api.online/carts/:cartId/items" to add product to cart
    Then user get product id and 201 ok response

    @six @cart
  Scenario: Get cart items API validation
     When user enter "http://simple-grocery-store-api.online/carts/:cartId/items" to get items in a cart
     Then user list of product and 200 ok response

   @seven @cart
  Scenario: Get a cart API validation
        When user enter "http://simple-grocery-store-api.online/carts/:cartId" to get cart details and list of card items
        Then user get 200 ok response
