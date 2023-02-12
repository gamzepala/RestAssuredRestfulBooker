#Feature: Update Booking
#  As a user
#  I want to update a booking
#  So that I can make changes to the existing booking
#
#  Scenario: Update a booking successfully
#    Given I have a valid booking with ID 1
#    And I have a valid update payload with the following details
#      | field     | value |
#      | firstname | John  |
#      | lastname  | Doe   |
#    When I send a PATCH request to the 1 endpoint with the update payload
#    Then the response status code should be 200
#    And the response body should match the update payload
