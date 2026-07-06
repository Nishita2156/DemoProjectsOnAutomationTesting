package com.basics;

import io.restassured.RestAssured;

import io.restassured.path.json.JsonPath;

import  static io.restassured.RestAssured.*;//for importing static package which is not imported by default
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;

import files.Payload;
import files.ResuableMethods;
public class Basics {

	public static void main(String[] args) throws IOException {
		//validate if add place is working or not
		//given all input details
		//when you submit request ,resource ,http methods
		//then you validate response
		//logging is necessary in given and then both method 
		//content of the file to String-->content of the file convert into Byte-->Byte data to String
		RestAssured.baseURI="https://rahulshettyacademy.com";
		String response=given().log().all().queryParam("key", "qaclick123").header("Content-type", "application/json")
		//.body(Payload.addPlace())--sending from payload class
	    //sending through file path 
		.body( new String (Files.readAllBytes(Paths.get("C:\\Users\\Nishita Jannat Alam\\Desktop\\AddplaceinGoogleMaps.txt"))))
		.when().post("/maps/api/place/add/json")
		.then().assertThat()
		.statusCode(200)
		.body("scope",equalTo("APP"))
		//.header("server","Apache/2.4.18 (Ubuntu)")
		
		//add place-->update place with new address -->get place to validate if 
		//new address in present in response or not 
		.extract().response().asString();
		System.out.println(response);
		
       JsonPath  js =new JsonPath(response);//to parse the json
       String place_id=js.get("place_id");
       System.out.println(place_id);
       
       //update place
       String newAddress="New York,USA";
       
       given().log().all().queryParam("key", "qaclick123")
       .body("{\r\n"
       		+ "\"place_id\":\""+place_id+"\",\r\n"
       		+ "\"address\":\""+newAddress+"\",\r\n"
       		+ "\"key\":\"qaclick123\"\r\n"
       		+ "}\r\n"
       		+ "")
       .when().put("/maps/api/place/update/json")
       .then().assertThat().log().all().statusCode(200)
       .body("msg", equalTo("Address successfully updated"));
       
       //Get place to validate 
      String getPlaceResponse= given().log().all().queryParam("key", "qaclick123")
       .queryParam("place_id", place_id)
       .when().get("/maps/api/place/get/json")
       .then().assertThat().log().all().statusCode(200).extract().response().asString();
      
      JsonPath jsres=ResuableMethods.rawtoJson(getPlaceResponse);
      String actualAddress=jsres.getString("address");
      System.out.println(actualAddress);
       Assert.assertEquals(actualAddress, newAddress);
       
	}

}
