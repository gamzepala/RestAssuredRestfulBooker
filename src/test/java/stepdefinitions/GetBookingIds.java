//package booking.stepdefinitions;
//
//import helper.BaseTest;
//import io.restassured.RestAssured;
//import io.restassured.http.Header;
//import io.restassured.response.Response;
//import org.assertj.core.api.SoftAssertions;
//import org.junit.Assert;
//
//
//public class GetBookingIds extends BaseTest {
//
//
//	public void getBookingTest() {
//
//		// Create Booking
//		Response responseCreate = createBooking();
//		responseCreate.print();
//
//		// Get bookingId of new booking
//		int bookingid = responseCreate.jsonPath().getInt("bookingid");
//
//		//Set Parameter
//		spec.pathParam("bookingId", bookingid);
//
//		// Get
//
//		System.out.println("Bookingid : " + bookingid + " için JSON çalışacak : ");
//		Response response = RestAssured.given(spec).get("/booking/{bookingId}");
//		response.print();
//
//		System.out.println("StatusCode : " +response.getStatusCode());
//
//		// Verify
//		Assert.assertEquals(response.getStatusCode(), 200);
//
//		// Verify all fields
//		SoftAssert softAssert = new SoftAssert();
//
//		String actualFirstName = response.jsonPath().getString("firstname");
//		softAssert.assertEquals(actualFirstName, "Gamze", "Firstname doğru değil.");
//
//		String actualLastName = response.jsonPath().getString("lastname");
//		softAssert.assertEquals(actualLastName, "DP", "Lastname doğru değil");
//
//		int price = response.jsonPath().getInt("totalprice");
//		softAssert.assertEquals(price, 200, "Price 111 değil");
//
//		boolean depositpaid = response.jsonPath().getBoolean("depositpaid");
//		softAssert.assertFalse(depositpaid, "Depositpaid false değil.");
//
//		String actualCheckin = response.jsonPath().getString("bookingdates.checkin");
//		softAssert.assertEquals(actualCheckin, "2018-01-01", "Checkin doğru değil.");
//
//		String actualCheckout = response.jsonPath().getString("bookingdates.checkout");
//		softAssert.assertEquals(actualCheckout, "2019-01-01", "Checkout doğru değil.");
//
//		String actuaAdditionalneeds = response.jsonPath().getString("additionalneeds");
//		softAssert.assertEquals(actuaAdditionalneeds, "Lunch", "Additionalneeds doğru değil");
//
//		/*
//		 * "firstname": "Sally", "lastname": "Brown", "totalprice": 111, "depositpaid":
//		 * true, "bookingdates": { "checkin": "2013-02-23", "checkout": "2014-10-23" },
//		 * "additionalneeds": "Breakfast"
//		 *
//		 */
//
//		softAssert.assertAll();
//	}
//
//
//	public void getBookingXMLTest() {
//
//		// Create Booking
//		Response responseCreate = createBooking();
//		responseCreate.print();
//
//		// Get bookingId of new booking
//		int bookingid = responseCreate.jsonPath().getInt("bookingid");
//
//		//Set Parameter
//		spec.pathParam("bookingId", bookingid);
//
//		// Get response with booking
//		Header xml = new Header("Accept" , "application/xml");
//		spec.header(xml);
//		System.out.println("Bookingid : " + bookingid + " için JSON çalışacak : ");
//		Response response = RestAssured.given(spec).get("/booking/{bookingId}");
//		response.print();
//
//		System.out.println("StatusCode : " +response.getStatusCode());
//
//		// Verify
//		Assert.assertEquals(response.getStatusCode(), 200);
//
//		// Verify all fields
//		SoftAssertions softAssert = new SoftAssertions();
//
//		String actualFirstName = response.xmlPath().getString("booking.firstname"); //jsonPath().getString("firstname");
//		softAssert.assertThat(actualFirstName.equals("Gamze"));
//
//		String actualLastName = response.xmlPath().getString("booking.lastname");//jsonPath().getString("lastname");
//		softAssert.assertEquals(actualLastName, "DP", "Lastname doğru değil");
//
//		int price = response.xmlPath().getInt("booking.totalprice");//jsonPath().getInt("totalprice");
//		softAssert.assertEquals(price, 200, "Price 111 değil");
//
//		boolean depositpaid = response.xmlPath().getBoolean("booking.depositpaid");//jsonPath().getBoolean("depositpaid");
//		softAssert.assertFalse(depositpaid, "Depositpaid false değil.");
//
//		String actualCheckin = response.xmlPath().getString("booking.bookingdates.checkin");//jsonPath().getString("bookingdates.checkin");
//		softAssert.assertEquals(actualCheckin, "2018-01-01", "Checkin doğru değil.");
//
//		String actualCheckout = response.xmlPath().getString("booking.bookingdates.checkout");//jsonPath().getString("bookingdates.checkout");
//		softAssert.assertEquals(actualCheckout, "2019-01-01", "Checkout doğru değil.");
//
//		String actuaAdditionalneeds = response.xmlPath().getString("booking.additionalneeds");//jsonPath().getString("additionalneeds");
//		softAssert.assertEquals(actuaAdditionalneeds, "Lunch", "Additionalneeds doğru değil");
//
//		/*
//		 * "firstname": "Sally", "lastname": "Brown", "totalprice": 111, "depositpaid":
//		 * true, "bookingdates": { "checkin": "2013-02-23", "checkout": "2014-10-23" },
//		 * "additionalneeds": "Breakfast"
//		 *
//		 */
//
//		softAssert.assertAll();
//	}
//
//}
