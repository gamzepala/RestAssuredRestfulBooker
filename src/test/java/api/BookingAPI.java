package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Booking;
import org.json.JSONObject;

import java.io.File;

public class BookingAPI {

    private static final String BOOKING =  "/booking";

    File jsonDataInFile = new File("src/test/resources/Payloads/AuthPayload.json");



//    public void getAllIssues(String accessToken) {
//        SerenityRest.given().auth().preemptive().oauth2(accessToken)
//                .contentType(ContentType.JSON)
//                .when()
//                .log().all()
//                .get(ALL_ISSUES);
//    }
//
//    public void getSingleIssueByProject(Integer issueId, Integer projectId, String accessToken) {
//        SerenityRest.given().auth().preemptive().oauth2(accessToken)
//                .contentType(ContentType.JSON)
//                .when()
//                .pathParam("issue", issueId)
//                .pathParam("projects", projectId)
//                .log().all()
//                .get(SINGLE_ISSUE_BY_PROJECT);
//    }
//
//    public void getSingleIssueByQueryParameter(Integer projectId, String parameterName, String parameterValue, String accessToken) {
//        SerenityRest.given().auth().preemptive().oauth2(accessToken)
//                .contentType(ContentType.JSON)
//                .when()
//                .pathParam("projects", projectId)
//                .queryParam(parameterName, parameterValue)
//                .log().all()
//                .get(SINGLE_ISSUE_BY_QUERY_PARAMETER);
//    }
//
//    public void getInvalidIssueRequestByProject(String issueId, Integer projectId, String accessToken) {
//        SerenityRest.given().auth().preemptive().oauth2(accessToken)
//                .contentType(ContentType.JSON)
//                .when()
//                .pathParam("issue", issueId)
//                .pathParam("projects", projectId)
//                .log().all()
//                .get(SINGLE_ISSUE_BY_PROJECT);
//    }

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

    public Response updateBooking(Integer bookingId, String token, JSONObject body) {
        return RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .cookie("token", token)
                .body(body.toString())
                .put(BOOKING + "/" + bookingId);
    }
}
