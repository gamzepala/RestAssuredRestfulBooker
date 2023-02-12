package stepdefinitions;

import api.AuthAPI;
import api.BookingAPI;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import model.Booking;
import model.Bookingdates;
import org.apache.http.HttpStatus;
import org.junit.Assert;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class GetBookingById {
    private int bookingId;
    private Bookingdates bookingdates;
    private Booking booking;
    private Response response;

    BookingAPI bookingAPI = new BookingAPI();
    AuthAPI auth = new AuthAPI();

    @Given("For get by id I have a valid booking")
    public void for_get_by_id_i_have_a_valid_booking() {

        // TODO: Payload olayına bak
//		Response responseCreate = createBooking();

        //Create body using POJOs
        bookingdates = new Bookingdates("2022-11-20", "2022-11-18");
        booking = new Booking("VR", "NN", 200, false, bookingdates, "Brunch");

        // Create a booking and return response
        response = bookingAPI.createBooking(booking);

        System.out.println("Create response:" + response.prettyPrint());

        // Get bookingId of new booking
        bookingId = response.jsonPath().getInt("bookingid");

        System.out.println("Booking Id:" + bookingId);

    }

    @When("I perform a GET request with filter by bookingid")
    public void i_perform_a_get_request_with_filter_by_bookinig() {
        response = bookingAPI.getBookingById(bookingId);
    }

    @Then("the response code of this bookingid should be verified")
    public void the_response_code_of_this_booking_should_be_verified() {
        // Verify not deleted
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        // TODO : body assertions
        //TODO : ikinci bir eleman olmadığı teyiti

    }
}
//		//Create body using POJOs
//		bookingdates = new Bookingdates("2022-11-20", "2022-11-18");
//		booking = new Booking("VR", "NN", 200, false, bookingdates, "Brunch");
//
//		// Create a booking and return response
//		response = bookingAPI.createBooking(booking);
//
//		System.out.println("Create response:" + response.prettyPrint());
//
//		// Get bookingId of new booking
//		bookingId = response.jsonPath().getInt("bookingid");
//
//		System.out.println("Booking Id:" + bookingId);
//

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
