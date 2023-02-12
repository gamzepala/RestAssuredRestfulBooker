package stepdefinitions;

import api.AuthAPI;
import api.BookingAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import model.Booking;
import model.Bookingdates;
import net.minidev.json.JSONObject;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import payload.AuthLoginRequests;


public class UpdateBooking {
    private int bookingId;
    private Bookingdates bookingdates;
    private Booking booking;
    private Response response;

    org.json.JSONObject body = new org.json.JSONObject();

    JSONObject bookingDatesJson = new JSONObject();
    BookingAPI bookingAPI = new BookingAPI();
    AuthAPI auth = new AuthAPI();

    @Given("For update booking I have a valid booking")
    public void for_update_booking_i_have_a_valid_booking() {
        // TODO: Payload olayına bak

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
    @When("I perform a update request with {string} and {string}")
    public void i_perform_a_update_request_with_and(String user, String password) {
        String token = auth.createToken(new AuthLoginRequests(user, password));

		body.put("firstname", "Olga");
		body.put("lastname", "OL");
		body.put("totalprice", 300);
		body.put("depositpaid", true);
        bookingDatesJson.put("checkin", "2018-01-01");
        bookingDatesJson.put("checkout", "2019-01-01");
		body.put("bookingdates", bookingDatesJson);
		body.put("additionalneeds", "Lunch");

        // Partial update booking
        response = bookingAPI.updateBooking(bookingId, token, body);
        System.out.println("Update Booking: " + response.prettyPrint());
    }
    @Then("the update response code should be verified")
    public void the_update_response_code_should_be_verified() {
        // Verify update
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    }
    @Then("the update response body should be correct")
    public void the_update_response_body_should_be_correct() {
        String actualFirstName = response.jsonPath().getString("firstname");
        System.out.println("Firstname:" + actualFirstName);
        //TODO: assertions kontrol. güncellenen alanları.
    }
}

//		// Verifications
//		// Verify
//		Assert.assertEquals(responseUpdate.getStatusCode(), 200);
//
//		// Verify all fields
//		SoftAssert softAssert = new SoftAssert();
//
//		String actualFirstName = responseUpdate.jsonPath().getString("firstname");
//		softAssert.assertEquals(actualFirstName, "Olga", "Firstname doğru değil.");
//
//		String actualLastName = responseUpdate.jsonPath().getString("lastname");
//		softAssert.assertEquals(actualLastName, "OL", "Lastname doğru değil");
//
//		int price = responseUpdate.jsonPath().getInt("totalprice");
//		softAssert.assertEquals(price, 300, "Price 111 değil");
//
//		boolean depositpaid = responseUpdate.jsonPath().getBoolean("depositpaid");
//		softAssert.assertTrue(depositpaid, "Depositpaid true değil.");
//
//		String actualCheckin = responseUpdate.jsonPath().getString("bookingdates.checkin");
//		softAssert.assertEquals(actualCheckin, "2018-01-01", "Checkin doğru değil.");
//
//		String actualCheckout = responseUpdate.jsonPath().getString("bookingdates.checkout");
//		softAssert.assertEquals(actualCheckout, "2019-01-01", "Checkout doğru değil.");
//
//		String actuaAdditionalneeds = responseUpdate.jsonPath().getString("additionalneeds");
//		softAssert.assertEquals(actuaAdditionalneeds, "Lunch", "Additionalneeds doğru değil");
//
//		softAssert.assertAll();
//
//	}
//
//}
