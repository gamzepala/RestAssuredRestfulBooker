Feature: Delete existing booking by id
  As a user
  I want to delete a booking
  So that I don't need anymore

  Background: Prepare for test
    Given I have a valid booking

  @debug
  Scenario: Delete an existing booking
    When I perform a DELETE request with "admin" and "password123"
    Then the DELETE response code should be verified
    And the DELETE response body should be correct

  Scenario: Try to delete a booking by invalid credentials
    When I perform a DELETE request with invalid "admin1" and "password123"
    Then the DELETE response code should be verified
    And the DELETE response body should be correct


