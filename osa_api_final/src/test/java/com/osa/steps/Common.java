package com.osa.steps;

import com.osa.base.API;
import com.osa.utility.Utils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Common {

	@Given("I have completeted the authentication")
	public void i_have_completeted_the_authentication() {

	}

	@When("I send a {string} request to {string} endpoint")
	public void i_send_a_request_to_endpoint(String req, String endpoint) {
		Response res=API.sendRequest(req, endpoint, null);
		JsonPath jp=Utils.getRes(res);
		System.out.println(jp);
	}

	@Then("I verify the response value for following fields")
	public void i_verify_the_response_value_for_following_fields() {
	  
	}
	
}
