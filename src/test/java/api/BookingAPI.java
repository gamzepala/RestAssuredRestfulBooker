package api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.Booking;

public class BookingAPI {

    private static final String BOOKING =  "/booking";
    private static final String SINGLE_ISSUE_BY_PROJECT =  "projects/{projects}/issues/{issue}";
    private static final String SINGLE_ISSUE_BY_QUERY_PARAMETER =  "projects/{projects}/issues";
    private static final String ALL_ISSUES =  "/issues";

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

    public Response deleteBooking(Integer bookingId, String token) {
        return RestAssured
                .given()
                .log().all()
                .contentType(ContentType.JSON)
                .cookie("token", token)
                .delete(BOOKING + "/" + bookingId);
    }

    public Response getBooking(Integer bookingId) {
        return RestAssured
                .given()
                .log().all()
                .get(BOOKING+ bookingId);
    }

//    public void editIssueByProject(Integer issueId, Integer projectId, String accessToken, String payload) {
//        SerenityRest.given().auth().preemptive().oauth2(accessToken)
//                .contentType(ContentType.JSON)
//                .body(payload)
//                .when()
//                .pathParam("issue", issueId)
//                .pathParam("projects", projectId)
//                .log().all()
//                .put(SINGLE_ISSUE_BY_PROJECT);
//    }
//
//    public void deleteIssue(Integer issueId, Integer projectId, String accessToken) {
//        SerenityRest.given().auth().preemptive().oauth2(accessToken)
//                .contentType(ContentType.JSON)
//                .when()
//                .pathParam("issue", issueId)
//                .pathParam("projects", projectId)
//                .log().all()
//                .delete(SINGLE_ISSUE_BY_PROJECT);
//    }
}
