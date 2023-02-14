package stepdefinitions;

import api.AuthAPI;
import api.BookingAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.Booking;
import model.Bookingdates;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import model.AuthLoginRequests;
import java.io.File;
import java.io.IOException;

public class PartialUpdateBooking {
    private int bookingId;
    private Bookingdates bookingdates;
    private Booking booking;
    private Response response;

    org.json.JSONObject body = new org.json.JSONObject();
    BookingAPI bookingAPI = new BookingAPI();
    AuthAPI auth = new AuthAPI();

    File requestPayload = new File("src/test/resources/payloads/request_payload.json");

    @Given("For partial update booking I have a valid booking")
    public void for_partial_update_booking_i_have_a_valid_booking() throws IOException {

        booking = new Booking(requestPayload);

        // Create a booking and return response
        response = bookingAPI.createBooking(booking);

        // Get bookingId of new booking
        bookingId = response.jsonPath().getInt("bookingid");
    }

    @When("I perform a partial update request with {string} and {string}")
    public void i_perform_a_partial_update_request_with_and(String user, String password) {

        String token = auth.createToken(new AuthLoginRequests(user, password));

		body.put("firstname", "Nederlands");
        body.put("lastname", "Company");

        // Partial update booking
        response = bookingAPI.partialUpdateBooking(bookingId, token, body);

    }
    @Then("the partial update response code should be verified")
    public void the_partial_update_response_code_should_be_verified() {
        // Verify partial update response code
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

    }
    @Then("the partial update response body should be correct")
    public void the_partial_update_response_body_should_be_correct() {

        JsonPath jsonPath = response.jsonPath();

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(jsonPath.getString("firstname")).isEqualTo("Nederlands","Firstname is not correct.");
        softly.assertThat(jsonPath.getString("lastname")).isEqualTo("Company","lastname is not correct.");

        softly.assertAll();
    }
}

