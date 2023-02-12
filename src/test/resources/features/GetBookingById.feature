Feature: Returns a specific booking based upon the booking id provided
  As a user
  I want to get a specific booking based
  So that I can see it at the list

  Scenario: I perform a GET request with filter by bookingid
    Given For get by id I have a valid booking
    When I perform a GET request with filter by bookingid
    Then the response code of this bookingid should be verified
