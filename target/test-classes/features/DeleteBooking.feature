Feature: Delete existing booking by id
  As a user
  I want to delete a booking
  So that I don't need anymore

  @debug
  Scenario: Delete a booking
    Given I have a valid booking
    When I perform a DELETE request with "admin" and "password123"
    Then the DELETE response code should be verified
    And the DELETE response body should be correct
