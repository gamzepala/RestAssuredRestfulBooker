package stepdefinitions;

import helper.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class HealthCheck extends BaseTest {

    Response response;
    @When("I perform a GET request by ping end-point")
    public void i_perform_a_get_request_by_ping_end_point() {
        response = RestAssured.given().get("/ping");
    }
    @Then("the response code should be verified")
    public void the_response_code_should_be_verified() {
        // Verify response 201
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED);
    }
}
