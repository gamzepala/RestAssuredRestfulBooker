Feature: Confirm whether the API is up and running
  As a user
  I want to confirm whether the API is up and running
  So I ping the endpoint

  Scenario: Ping the endpoint
    When I perform a GET request by ping end-point
    Then the response code should be verified
