package com.osa.base;



import com.osa.utility.Utils;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API {

	public static void main(String[] args) {
     
     String payload="{\"firstName\":\"shamima\",\"lastName\":\"yesmin\",\"dob\":\"08-23-1989\",ep.shamima88yesmin@gmail.com\",\"phone\":\"88884545454\"},\"aggrement\\\":{\"agree\":true\"contractInfo\":{\"email\":\"suvade,\"message\":\"IagreealltherulesandconditionfromOSAConsultingTechCorp\"}}";		
		
		Response res=sendRequest("POST","students/registration",payload);
		JsonPath jp=Utils.getRes(res);
		Response resGet=GET("/students/"+jp.getString("id"));
		JsonPath jpp=Utils.getRes(resGet);
		
		
		
	}
	
	public static Response sendRequest(String requestType,String endpoint, String ...payload) {
		
		Response res=null;
		if(requestType.toLowerCase().equals("get")) {
			res=GET(endpoint);
		}else if(requestType.toLowerCase().equals("post")) {
			res=POST(endpoint,payload[0]);
		}else if(requestType.toLowerCase().equals("patch")) {
			res=PATCH(endpoint,payload[0]);	
		}else if(requestType.toLowerCase().equals("delete")) {
			res=DELETE(endpoint);
		}else {
			System.out.println("You have entered value of requestType="+requestType+"but it need to be[GET/POST/DELETE/PATCH]");
		}
		return res;
	}
	
	public static Response DELETE(String endpoint) {
		RequestSpecification req=Base.setAPI();
		Response res=req
				.delete(endpoint);
		return res;
	}
	public static Response PATCH(String endpoint,String ...payload) {
		RequestSpecification req=Base.setAPI();
		Response res=req
				.body(payload)
				.patch(endpoint);
		return res;
	}
	
	public static Response POST(String endpoint,String payload) {
		RequestSpecification req=Base.setAPI();
		Response res=req
				.body(payload)
				.post(endpoint);
		return res;
	}
	
	public static Response GET(String endpoint) {
		RequestSpecification req=Base.setAPI();
		Response res=req.get(endpoint);
		return res;
	}
	
	
	
}
