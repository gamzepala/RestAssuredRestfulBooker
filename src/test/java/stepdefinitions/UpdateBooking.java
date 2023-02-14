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
import net.minidev.json.JSONObject;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import model.AuthLoginRequests;
import java.io.File;
import java.io.IOException;


public class UpdateBooking {
    private int bookingId;
    private Bookingdates bookingdates;
    private Booking booking;
    private Response response;

    org.json.JSONObject body = new org.json.JSONObject();

    JSONObject bookingDatesJson = new JSONObject();
    BookingAPI bookingAPI = new BookingAPI();
    AuthAPI auth = new AuthAPI();
    File requestPayload = new File("src/test/resources/payloads/request_payload.json");
    File updatePayload = new File("src/test/resources/payloads/update_payload.json");

    @Given("For update booking I have a valid booking")
    public void for_update_booking_i_have_a_valid_booking() throws IOException {

        booking = new Booking(requestPayload);

        // Create a booking and return response
        response = bookingAPI.createBooking(booking);

        // Get bookingId of new booking
        bookingId = response.jsonPath().getInt("bookingid");
    }
    @When("I perform a update request with {string} and {string}")
    public void i_perform_a_update_request_with_and(String user, String password) throws IOException {
        String token = auth.createToken(new AuthLoginRequests(user, password));

        booking = new Booking(updatePayload);

        // Update booking
        response = bookingAPI.updateBooking(bookingId, token, booking);
    }
    @Then("the update response code should be verified")
    public void the_update_response_code_should_be_verified() {

        // Verify update response code
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
    }
    @Then("the update response body should be correct")
    public void the_update_response_body_should_be_correct() {

        JsonPath jsonPath = response.jsonPath();

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(jsonPath.getString("firstname")).isEqualTo("Solution","Firstname is not correct.");
        softly.assertThat(jsonPath.getString("lastname")).isEqualTo("Account","Lastname is not correct.");
        softly.assertThat(jsonPath.getInt("totalprice")).isEqualTo(300);
        softly.assertThat(jsonPath.getBoolean("depositpaid")).isEqualTo(true);
        softly.assertThat(jsonPath.getString("bookingdates.checkin")).isEqualTo("2023-01-01","Checkin is not correct.");
        softly.assertThat(jsonPath.getString("bookingdates.checkout")).isEqualTo("2023-01-12","Checkout is not correct.");
        softly.assertThat(jsonPath.getString("additionalneeds")).isEqualTo("Future","Additionalneeds is not correct.");

        softly.assertAll();
    }
}

