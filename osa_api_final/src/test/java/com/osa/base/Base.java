package com.osa.base;

import java.util.Properties;

import com.osa.utility.Utils;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class Base {
	static Properties prop=Utils.setProp("src/test/resources/properties/app.properties");
	
	public static RequestSpecification setAPI() {//its method for api 
		RequestSpecification reqSpec=null;
		RestAssured.baseURI=prop.get("baseURI").toString();
		reqSpec=RestAssured
					.given()
					.headers("Content-Type","application/json")
					.auth()
					.preemptive()
					.basic(prop.getProperty("username"), prop.getProperty("password"));
		return reqSpec;
	}
	
}
