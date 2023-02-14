package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import model.AuthLoginRequests;

import static io.restassured.RestAssured.given;

/**
 * This class provides Access Token by
 * resource owner Credentials grant type
 */
public class AuthAPI {

    private static final String AUTH =  "/auth";

    /**
     * This method provides access token based on owner information
     * @return access token
     */
    public String createToken(AuthLoginRequests payload) {
        Response response = given()
                .body(payload)
                .contentType(ContentType.JSON)
                .post(AUTH);

        return response.jsonPath().getString("token");
    }
}
