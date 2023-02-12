Feature: Returns a specific booking based upon the booking id provided
  As a user
  I want to get a specific booking based
  So that I can see at the list


  Scenario: I get response with booking Ids
    When I perform a GET request without filter by bookingid end-point
    Then the response code of without filter should be verified
    And the response of without filter should verify at least one booking id

  Scenario: I get response with booking Ids by firstname and lastname query parameters
    When I perform a GET request with filter by booking end-point and firstname and lastname query parameters
    Then the response code of with filter should be verified
    And the response of with filter should verify at least one booking id