package stepdefinitions;

import api.BookingAPI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import java.util.List;

public class GetBookingIds{
		Response response ;
		BookingAPI bookingAPI = new BookingAPI();

		@When("I perform a GET request without filter by bookingid end-point")
		public void i_perform_a_get_request_without_filter_by_bookingid_end_point() {
			// Get response with booking Ids
			response = bookingAPI.getBookingIds();
		}
		@Then("the response code of without filter should be verified")
		public void the_response_code_of_without_filter_should_be_verified() {
			// Verify response 200
			Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
		}
		@Then("the response of without filter should verify at least one booking id")
		public void the_response_of_without_filter_should_verify_at_least_one_booking_id() {
			// Verify at least one booking id in response
			List<Integer> bookingIds = response.jsonPath().getList("bookingid");

			Assert.assertFalse(bookingIds.isEmpty());
		}

}
