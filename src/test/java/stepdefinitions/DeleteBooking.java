package stepdefinitions;


import api.AuthAPI;
import api.BookingAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import model.Booking;
import model.Bookingdates;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import payload.AuthLoginRequests;


public class DeleteBooking {
	private int bookingId;
	private Bookingdates bookingdates;
	private Booking booking;
	private Response response;

	BookingAPI bookingAPI = new BookingAPI();
	AuthAPI auth = new AuthAPI();
	@Given("I have a valid booking")
	public void i_have_a_valid_booking() {

		// TODO: Payload olayına bak
//		Response responseCreate = createBooking();

		//Create body using POJOs
		bookingdates = new Bookingdates("2022-11-20", "2022-11-18");
		booking = new Booking("VR", "NN", 200, false, bookingdates, "Brunch");

		// Create a booking and return response
		response = bookingAPI.createBooking(booking);

		System.out.println("Create response:" + response.prettyPrint());

		// Get bookingId of new booking
		bookingId = response.jsonPath().getInt("bookingid");

		System.out.println("Booking Id:" + bookingId);

	}

	@When("I perform a DELETE request with {string} and {string}")
	public void i_perform_a_delete_request_with_and(String user, String password) {
		String token = auth.createToken(new AuthLoginRequests(user, password));
		// Delete booking
		response = bookingAPI.deleteBooking(bookingId, token);
	}

	@Then("the DELETE response code should be verified")
	public void the_delete_response_code_should_be_verified() {
		// Verify DELETE
		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED);
	}
	@Then("the DELETE response body should be correct")
	public void the_delete_response_body_should_be_correct() {
		response =  bookingAPI.getBooking(bookingId);

		Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_NOT_FOUND);
		Assert.assertEquals(response.getBody().asString(), "Not Found");
	}



}
