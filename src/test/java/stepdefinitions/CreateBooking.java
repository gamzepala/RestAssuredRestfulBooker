package stepdefinitions;


import api.BookingAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import model.Booking;
import model.Bookingdates;
import model.Bookingid;
import org.apache.http.HttpStatus;
import org.junit.Assert;

public class CreateBooking {
	protected RequestSpecification spec;
	private Bookingid bookingid;
	private Bookingdates bookingdates;
	private Booking booking;
	private Response response;

	@Given("I have a valid booking payload with the following details")
	public void i_have_a_valid_booking_payload_with_the_following_details() {

		//Create body using POJOs
		bookingdates = new Bookingdates("2022-11-20", "2022-11-18");
		booking = new Booking("VR", "NN", 200, false, bookingdates, "Brunch");
	}
	@When("I perform a POST request")
	public void i_perform_a_post_request() {
		BookingAPI bookingAPI = new BookingAPI();
		// Get response
		response = bookingAPI.createBooking(booking);
		System.out.println(response.prettyPrint());
	}
	@Then("the create response code should be verified")
	public void the_create_response_code_should_be_verified() {
		bookingid = response.as(Bookingid.class);
		// Verification
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
	}
	@Then("the response body should be correct")
	public void the_response_body_should_be_correct() {
		System.out.println("Request booking : " + booking.toString());
		System.out.println("Response booking : " + bookingid.getBooking().toString() );

		// Verify all fields
		Assert.assertEquals(bookingid.getBooking().toString(), booking.toString());
	}


}
