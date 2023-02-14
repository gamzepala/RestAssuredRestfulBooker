package stepdefinitions;

import api.BookingAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import model.Booking;
import model.Bookingid;
import org.apache.http.HttpStatus;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;

public class CreateBooking {
	private Bookingid bookingid;
	private Response response;
	BookingAPI bookingAPI =	new BookingAPI();;
	Booking booking;
	File requestPayload = new File("src/test/resources/payloads/request_payload.json");

	@Given("I have a valid booking payload with the following details")
	public void i_have_a_valid_booking_payload_with_the_following_details() throws IOException {

		booking = new Booking(requestPayload);
	}
	@When("I perform a POST request")
	public void i_perform_a_post_request() {

		response = bookingAPI.createBooking(booking);
	}
	@Then("the create response code should be verified")
	public void the_create_response_code_should_be_verified() {

		bookingid = response.as(Bookingid.class);
		// Verification
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
	}
	@Then("the response body should be correct")
	public void the_response_body_should_be_correct() {
		// Verify all fields
		Assert.assertEquals(bookingid.getBooking().toString(), booking.toString());
	}
	@Then("the schema should be correct")
	public void the_schema_should_be_correct() {

		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));
	}

	@When("I perform a POST request with invalid {string}")
	public void I_perform_a_POST_request_with_invalid(String payload) {

		response = bookingAPI.sendInvalidBookingRequest(payload);
	}

	@Then("api should return a correct {int}")
	public void api_should_return_a_correct(int statusCode) {

		Assert.assertEquals(response.getStatusCode(), statusCode);

	}
	@Then("api should return a correct {string}")
	public void api_should_return_a_correct(String responseError) {

		Assert.assertEquals(response.getBody().asString(), responseError);
	}

}
