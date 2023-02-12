package helper;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;

public class BaseTest {

	public Response createBooking() {
		
		// Create json body

		JSONObject body = new JSONObject();
		body.put("firstname", "Gamze");
		body.put("lastname", "DP");
		body.put("totalprice", 200);
		body.put("depositpaid", false);

		JSONObject bookingdates = new JSONObject();
		bookingdates.put("checkin", "2018-01-01");
		bookingdates.put("checkout", "2019-01-01");
		body.put("bookingdates", bookingdates);
		body.put("additionalneeds", "Lunch");

		// Get response
		Response response = RestAssured.given().contentType(ContentType.JSON).body(body.toString())
				.post("/booking");
		return response;
	}
}
