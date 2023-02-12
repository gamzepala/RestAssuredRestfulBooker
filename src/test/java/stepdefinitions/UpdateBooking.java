//package booking.stepdefinition;
//
//
//import helper.BaseTest;
//import io.restassured.RestAssured;
//import io.restassured.http.ContentType;
//import io.restassured.response.Response;
//import org.assertj.core.api.SoftAssertions;
//import org.json.JSONObject;
//import org.junit.Assert;
//
//
//public class UpdateBooking extends BaseTest {
//
//	public void updateBookingTest() {
//
//		// Create Booking
//		Response responseCreate = createBooking();
//		responseCreate.print();
//
//		// Get bookingId of new booking
//		int bookingid = responseCreate.jsonPath().getInt("bookingid");
//
//		// Create json body
//		JSONObject body = new JSONObject();
//		body.put("firstname", "Olga");
//		body.put("lastname", "OL");
//		body.put("totalprice", 300);
//		body.put("depositpaid", true);
//
//		JSONObject bookingdates = new JSONObject();
//		bookingdates.put("checkin", "2018-01-01");
//		bookingdates.put("checkout", "2019-01-01");
//		body.put("bookingdates", bookingdates);
//		body.put("additionalneeds", "Lunch");
//
//		// Update booking
//		Response responseUpdate = RestAssured.given(spec).auth().preemptive().basic("admin", "password123").contentType(ContentType.JSON).body(body.toString())
//				.put("/booking/" + bookingid);
//		responseUpdate.print();
//
//
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
