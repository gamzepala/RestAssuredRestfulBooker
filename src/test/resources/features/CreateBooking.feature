Feature: Creates a new booking in the API
  As a user
  I want to create a new booking
  So that I can make a reservation

  Scenario: Create a new booking
    Given I have a valid booking payload with the following details
    When I perform a POST request
    Then the create response code should be verified
    And the response body should be correct
