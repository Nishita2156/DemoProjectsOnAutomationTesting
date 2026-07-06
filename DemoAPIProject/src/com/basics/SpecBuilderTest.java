package com.basics;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilderTest {
	public static void main(String[] args) {
		AddPlace ad=new AddPlace();
		ad.setAccuracy(50);
		ad.setAddress("New york, USA");
		ad.setLanguage("English");
		ad.setName("Beach Vibes");
		ad.setPhone_number("+4567891234");
		ad.setWebsite("ghty@org.com");
		List<String> l=new ArrayList<String>();
		l.add("Park");
		l.add("Store");
		ad.setTypes(l);
		Location lo=new Location();
		lo.setLat(-38.383494);
		lo.setLng(33.427362);
		ad.setLocation(lo);
		
		//setting request specification to use it all over the framework--
		RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON).build();
		
		//using response specification builder to set the response related status code
		ResponseSpecification resSpec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		RequestSpecification res=given().spec(req)
		.body(ad);
		
		Response response=res.when().post("/maps/api/place/add/json")
		.then().spec(resSpec).extract().response();
		
		String responseString=response.asString();
		System.out.println(responseString);
		
	}

}
