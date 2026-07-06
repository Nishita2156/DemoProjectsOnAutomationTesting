package com.basics;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.Assert;

import io.restassured.path.json.JsonPath;
public class OAuthTest {
	public static void main(String[] args) {
		String expectedTitle[]= {"Selenium Webdriver Java","Cypress","Protractor"};//Declaring an class level array to compare with actual title
		//generating access token through post request---
		String response=given()
		.formParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
		.formParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
		.formParam("grant_type", "client_credentials")
		.formParam("scope", "trust")
		.when().log().all()
		.post("https://rahulshettyacademy.com/oauthapi/oauth2/resourceOwner/token").asString();
		System.out.println(response);
		JsonPath js=new JsonPath(response);
		String accessToken=js.getString("access_token");
		System.out.println(accessToken);
		
		//sending get call with access token---
		GetCourses gc=given()
		.queryParam("access_token", accessToken)
		.when().log().all()
		//.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").asString();//deserialization using Json Path syntax
	.get("https://rahulshettyacademy.com/oauthapi/getCourseDetails").as(GetCourses.class);// desi or extraction of json object by using POJO class
		
		//how we get it , just by object name of the class and get method 
		System.out.println(gc.getLinkedIn());
		System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());
		
		//get me the course title price of soap ui testing
		List<Api>  apicourses=gc.getCourses().getApi();
		for(int i=0;i<apicourses.size();i++) {
			if(apicourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI webservices testing")) {
				System.out.println(apicourses.get(i).getPrice());
				
			}
			
		}
		//get the all course title from webAutomation--
		ArrayList<String> listofCourses=new ArrayList<String>();
		List<WebAutomation> t=gc.getCourses().getWebAutomation();
		
		
		for(int j=0;j<t.size();j++) {
		   listofCourses.add(t.get(j).getCourseTitle());
			
		}
		List<String> expectedCourseTitle=Arrays.asList(expectedTitle);
		Assert.assertTrue(listofCourses.equals(expectedCourseTitle));
	}

}
