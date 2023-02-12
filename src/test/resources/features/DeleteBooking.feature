Feature: Delete existing booking by id
  As a user
  I want to delete a booking
  So that I don't need anymore

  Background: Prepare for test
    Given I have a valid booking

  Scenario: Delete an existing booking
    When I perform a DELETE request with "admin" and "password123"
    Then the DELETE response code should be verified
    And the DELETE response body should be correct

  Scenario: Try to delete a booking by invalid credentials
    When I perform a DELETE request with invalid "admin1" and "password123"
    Then the DELETE response code by invalid credentials should be verified

  Scenario: Try to delete a booking by invalid token
    When I perform a DELETE request with invalid "3f3d1d469cf72f6"
    Then the DELETE response code by invalid token should be verified

  Scenario: Delete not existing booking
    Given I perform a GET request first bookingid in the list
    When I perform a DELETE request with "admin" and "password123"
    Then the DELETE response code should be verified
    When I perform a DELETE request with "admin" and "password123"
    Then the DELETE response code by non existing booking should be verified




