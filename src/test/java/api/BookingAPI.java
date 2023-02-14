package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Booking;
import org.json.JSONObject;

/**
 * This class mainly contains the steps that uses
 * HTTP requests in order to interact with endpoints
 */
public class BookingAPI {

    private static final String BOOKING =  "/booking";

    public Response createBooking(Booking booking) {
        return RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(booking)
                .post(BOOKING);
    }

    public Response getBookingIds() {
        return RestAssured
                .given()
                .log().all()
                .get(BOOKING);
    }
    public Response getBookingById(Integer bookingId) {
        return RestAssured
                .given()
                .log().all()
                .get(BOOKING+ "/" + bookingId);
    }

    public Response deleteBooking(Integer bookingId, String token) {
        return RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .cookie("token", token)
                .delete(BOOKING + "/" + bookingId);
    }

    public Response partialUpdateBooking(Integer bookingId, String token, JSONObject body) {
        return RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .cookie("token", token)
                .body(body.toString())
                .patch(BOOKING + "/" + bookingId);

    }

    public Response updateBooking(Integer bookingId, String token, Booking booking) {
        return RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .cookie("token", token)
                .body(booking)
                .put(BOOKING + "/" + bookingId);
    }

    public Response sendInvalidBookingRequest(String booking) {
        return RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .body(booking)
                .post(BOOKING);
    }
}
