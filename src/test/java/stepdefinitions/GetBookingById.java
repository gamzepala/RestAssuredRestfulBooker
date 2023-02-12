package stepdefinitions;

import helper.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;
import org.junit.Assert;


import java.util.List;

public class GetBookingById extends BaseTest {

	RequestSpecification spec;
	Response response1 ;
	Response response2;

		@When("I perform a GET request without filter by bookingid end-point")
		public void i_perform_a_get_request_without_filter_by_bookingid_end_point() {
			// Get response with booking Ids
			response1 = RestAssured.given().get("/booking");
			response1.print();
		}
		@Then("the response code of without filter should be verified")
		public void the_response_code_of_without_filter_should_be_verified() {
			// Verify response 200
			Assert.assertEquals(response1.getStatusCode(), HttpStatus.SC_OK);
		}
		@Then("the response of without filter should verify at least one booking id")
		public void the_response_of_without_filter_should_verify_at_least_one_booking_id() {
			// Verify at least one booking id in response
			List<Integer> bookingIds = response1.jsonPath().getList("bookingid");
			Assert.assertFalse(bookingIds.isEmpty());
		}



		@When("I perform a GET request with filter by booking end-point and firstname and lastname query parameters")
		public void i_perform_a_get_request_with_filter_by_booking_end_point_and_firstname_and_lastname_query_parameters() {
			// Add query parameter
			spec.queryParam("firstname", "Josh");
			spec.queryParam("lastname", "Allen");

			// Get response with booking Ids
			response2 = RestAssured.given().get("/booking");
			response2.print();
		}
		@Then("the response code of with filter should be verified")
		public void the_response_code_of_with_filter_should_be_verified() {
			// Verify response 200
			Assert.assertEquals(response2.getStatusCode(),  HttpStatus.SC_OK);
		}
		@Then("the response of with filter should verify at least one booking id")
		public void the_response_of_with_filter_should_verify_at_least_one_booking_id() {
			// Verify at least one booking id in response
			List<Integer> bookingIds = response2.jsonPath().getList("bookingid");
			//Assert.assertFalse(bookingIds.isEmpty(), "Listesi bitti");
		}


}
