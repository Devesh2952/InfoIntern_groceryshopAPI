Feature: Cart API validation part two

  @cart @modify
  Scenario: Modify an item in the cart API validation
    When user enter "http://simple-grocery-store-api.online/carts/:cartId/items/:itemId" to modify quantity item in cart
    Then user get 204 No Content response for modify

    @cart @replace
    Scenario:Replace an item in the cart API validation
      When user enter "http://simple-grocery-store-api.online/carts/:cartId/items/:itemId" to replace an item
      Then User get 204 No Content response for replace

      @cart @delete_cart
    Scenario: Delete an item in the cart API validation
      When  user enter "http://simple-grocery-store-api.online/carts/:cartId/items/:itemId" to detele a item from cart
      Then user get 204 No Content response for Delete
