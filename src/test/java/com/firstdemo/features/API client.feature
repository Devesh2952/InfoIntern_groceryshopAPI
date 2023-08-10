Feature: Register a new API client
  @registration
  Scenario: Register a new API client to generate tocken
    When User enter the "http://simple-grocery-store-api.online/api-clients" to register
    Then tocken and 201 created response gerated