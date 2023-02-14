Feature: Updates a current booking
  As a user
  I want to update a current booking
  So that I can see the details of the updated booking

  Background: Prepare for test
    Given For update booking I have a valid booking


  Scenario: For update booking an existing booking
    When I perform a update request with "admin" and "password123"
    Then the update response code should be verified
    And the update response body should be correct