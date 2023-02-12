#Feature: Create Booking
#  As a user
#  I want to create a new booking
#  So that I can make a reservation
#
#  Scenario: Create a new booking
#    Given I have a valid booking payload with the following details:
#      | firstname | Alice |
#      | lastname  | Smith |
#      | totalprice| 150   |
#      | depositpaid| true |
#      | checkin   | 2022-07-28 |
#      | checkout  | 2022-07-30 |
#    When I perform a POST request to "/booking" with the above payload
#    Then the response code should be the correct 200
#    And the response body should include the following details:
#      | firstname | Alice |
#      | lastname  | Smith |
#      | totalprice| 150   |
#      | depositpaid| true |
#      | checkin   | 2022-07-28 |
#      | checkout  | 2022-07-30 |
