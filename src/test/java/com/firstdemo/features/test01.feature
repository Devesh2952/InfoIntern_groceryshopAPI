Feature: Check if API is working
  @google
Scenario: Check if google api is working
  When :user enter "https://www.google.co.in/" to open google
  Then :verify that  200 response is coming