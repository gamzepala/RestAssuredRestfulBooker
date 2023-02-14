package stepdefinitions;

import api.AuthAPI;
import api.BookingAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import model.Booking;
import org.apache.http.HttpStatus;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;
import java.io.File;
import java.io.IOException;

public class GetBookingById {
    private int bookingId;
    private Booking booking;
    private Response response;
    BookingAPI bookingAPI = new BookingAPI();
    AuthAPI auth = new AuthAPI();

    File requestPayload = new File("src/test/resources/payloads/request_payload.json");

    @Given("For get by id I have a valid booking")
    public void for_get_by_id_i_have_a_valid_booking() throws IOException {

        booking = new Booking(requestPayload);

        // Create a booking and return response
        response = bookingAPI.createBooking(booking);

        // Get bookingId of new booking
        bookingId = response.jsonPath().getInt("bookingid");
    }

    @When("I perform a GET request with filter by bookingid")
    public void i_perform_a_get_request_with_filter_by_bookinig() {

        response = bookingAPI.getBookingById(bookingId);
    }

    @Then("the response code of this bookingid should be verified")
    public void the_response_code_of_this_booking_should_be_verified() {
        // Verify status code
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);

        JsonPath jsonPath = response.jsonPath();

        SoftAssertions softly = new SoftAssertions();

        softly.assertThat(jsonPath.getString("firstname")).isEqualTo("Payment","Firstname is not correct.");
        softly.assertThat(jsonPath.getString("lastname")).isEqualTo("Credit","Lastname is not correct.");
        softly.assertThat(jsonPath.getInt("totalprice")).isEqualTo(900);
        softly.assertThat(jsonPath.getBoolean("depositpaid")).isEqualTo(false);
        softly.assertThat(jsonPath.getString("bookingdates.checkin")).isEqualTo("2022-12-20","Checkin is not correct.");
        softly.assertThat(jsonPath.getString("bookingdates.checkout")).isEqualTo("2022-12-18","Checkout is not correct.");
        softly.assertThat(jsonPath.getString("additionalneeds")).isEqualTo("Test","Additionalneeds is not correct.");

        softly.assertAll();
    }
}

