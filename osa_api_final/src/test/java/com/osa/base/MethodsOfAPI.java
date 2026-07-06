package com.osa.base;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MethodsOfAPI {
public static Response Get(String endpoint) {
	RequestSpecification req=Base.setAPI();
	Response res=req.get(endpoint);
	return res;
}
public static Response Post(String endpoint,String payload) {
	RequestSpecification req=Base.setAPI();
	Response res=req
			.body(payload)
	        .post(endpoint);
	return res;
}
}
