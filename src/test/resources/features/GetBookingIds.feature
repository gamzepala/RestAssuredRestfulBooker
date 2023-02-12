Feature: Returns the ids of all the bookings that exist within the API
  As a user
  I want to get all booking based
  So that I can see at the list


  Scenario: I get response with booking Ids
    When I perform a GET request by bookingid end-point
    Then the response code of without filter should be verified
    And the response of without filter should verify at least one booking id