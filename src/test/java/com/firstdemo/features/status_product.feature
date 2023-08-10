Feature: checking the status and product API
    @first @status
  Scenario: checking API request for status
    When user enter 'http://simple-grocery-store-api.online/status' to get status
    Then user will get status as up and 200 sourcecode

    @second @product
  Scenario: checking API for all product list
    When user enter 'http://simple-grocery-store-api.online/products' to get product list of inventory
    Then user will get inventory product and 200 sourcecode

    @three @product
  Scenario: checking API for single product
    When user enter 'http://simple-grocery-store-api.online/products/:productId' to get single product
    Then user will get sourcecode 200 ok