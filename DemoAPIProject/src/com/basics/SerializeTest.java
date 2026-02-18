package com.basics;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;


public class SerializeTest {
	//serialization in API---
	//have to create an object of POJO class and set the method
	
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
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		Response res=given().log().all().queryParam("key", "qaclick123")
		.body(ad)
		.when()
		.post("/maps/api/place/add/json")
		.then().assertThat().statusCode(200).extract().response();
		
		String response=res.asString();
		System.out.println(response);
		
	}

}
