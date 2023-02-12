package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.AuthLoginRequests;

import static io.restassured.RestAssured.given;

public class AuthAPI {

    private static final String AUTH =  "/auth";

    public String createToken(AuthLoginRequests payload) {
        Response response = given()
                .body(payload)
                .contentType(ContentType.JSON)
                .post(AUTH);

        return response.jsonPath().getString("token");
    }
}
