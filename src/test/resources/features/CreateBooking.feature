Feature: Creates a new booking in the API
  As a user
  I want to create a new booking
  So that I can make a reservation

  Scenario: Create a new booking
    Given I have a valid booking payload with the following details
    When I perform a POST request
    Then the create response code should be verified
    And the response body should be correct

  Scenario: Verify schema of a post request
    Given I have a valid booking payload with the following details
    When I perform a POST request
    Then the schema should be correct

  Scenario Outline: Try to break the API with payload: <payload>
    When I perform a POST request with invalid "<payload>"
    Then api should return a correct <status_code>
    And api should return a correct "<response_error>"
    Examples:
      | payload                                                                                                                                                                          | status_code | response_error        |
      | { }                                                                                                                                                                              | 500         | Internal Server Error |
      | {'username' : 'admin','password' : 'password123'}                                                                                                                                | 400         | Bad Request           |
      | {'firstname' :null ,'lastname' :  ,'totalprice' : 0,'depositpaid' : true,'bookingdates' : {'checkin' : '2019-01-01','checkout' : '2019-01-12' },'additionalneeds' : 'Breakfast'} | 400         | Bad Request           |
      | {'lastname' :'Money' ,'totalprice' :A,'depositpaid' : true,'bookingdates' : {'checkin' : '2019-01-01','checkout' : '2019-01-12'  }}                                              | 400         | Bad Request           |


