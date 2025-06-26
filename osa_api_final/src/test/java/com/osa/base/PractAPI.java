package com.osa.base;



import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PractAPI {
	public static void main(String[] args) {
		
		RestAssured.baseURI="https://reqres.in";
		RequestSpecification rsp=RestAssured.given();
		Response res=rsp.get("/api/users?page=2");
		System.out.println(res.getBody().asPrettyString());
		//JSONObject us=new JSONObject(res.getBody().asPrettyString());
		//System.out.println(res.getBody().asPrettyString());
		
	}

}
