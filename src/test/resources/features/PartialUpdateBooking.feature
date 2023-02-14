Feature: Updates a current booking with a partial payload
  As a user
  I want to update a current booking with a partial payload
  So that I can see the details of the updated booking

  Background: Prepare for test
    Given For partial update booking I have a valid booking


  Scenario: For partial update booking an existing booking
    When I perform a partial update request with "admin" and "password123"
    Then the partial update response code should be verified
    And the partial update response body should be correct