package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.restassured.RestAssured;

/**
 * This config provides baseURI in setup phase to be used in tests
 */

public class Config {

    @Before
    public void setup() {

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        RestAssured.baseURI = "https://restful-booker.herokuapp.com";
    }

    @After
    public void tearDown() {
        System.out.println("Test finished");
    }
}
