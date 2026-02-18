package com.basics;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;

import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;


public class EcommerceAPITest {
	public static void main(String[] args) {
		//if API has to pass through SSL certification then use relaxedHTTPsValidation in login request
			
	RequestSpecification req=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
		.setContentType(ContentType.JSON).build();
	
		//using POJO class to send the body--
		LoginRequest login =new LoginRequest();	
		login.setUserEmail("nyusa@gmail.com");
		login.setUserPassword("123USAny");
		
		RequestSpecification reqlogin=given().relaxedHTTPSValidation().log().all().spec(req).body(login);
		LoginResponse loginResponse=reqlogin.when().post("/api/ecom/auth/login")
				.then().log().all().extract().response()
				.as(LoginResponse.class);
		System.out.println(loginResponse.getToken());
		String token=loginResponse.getToken();
		System.out.println(loginResponse.getUserId());
		String userId=loginResponse.getUserId();
	
	
	//add product ,here we use Json path instead of POJO class for serializing/sending the data to network
	RequestSpecification addProductBasereq=new RequestSpecBuilder()
			.setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization", token).build();
	RequestSpecification addProduct=given().log().all().spec(addProductBasereq)
	.param("productName", "GiftCard")
	.param("productAddedBy", userId)
	.param("productCategory", "Paper")
	.param("productSubCategory", "Color")
	.param("productPrice", "100")
	.param("productDescription", "GreetingCard")
	.param("productFor", "ALL")
	.multiPart("productImage",new File("C:\\Users\\Nishita Jannat Alam\\Desktop\\YouTubeVideos\\goodMornig.jpeg"));
	String addProductResponse=addProduct.when().post("api/ecom/product/add-product")
			.then().log().all().extract().response().asString();
	JsonPath js=new JsonPath(addProductResponse);
	String productId=js.get("productId");
	System.out.println(productId);
	
	//create order, here we are using POJO class to seirialize
	RequestSpecification createOrderBasereq=new RequestSpecBuilder()
			.setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization", token)
			.setContentType(ContentType.JSON).build();
	
	OrderDetails orderDetail=new OrderDetails();
	orderDetail.setCountry("United States");
	orderDetail.setProductOrderedId(productId);
	
	List<OrderDetails> orderDetailsList=new ArrayList<OrderDetails>();
	orderDetailsList.add(orderDetail);
	
	Orders order =new Orders();
	order.setOrders(orderDetailsList);
	RequestSpecification createOrderReq=given().log().all().spec(createOrderBasereq).body(order);
	String createOrderResponse=createOrderReq.when().post("/api/ecom/order/create-order")
	.then().log().all().extract().response().asString();
	System.out.println(createOrderResponse);
	
	//delete product--
	RequestSpecification deleteOrderBasereq=new RequestSpecBuilder()
			.setBaseUri("https://rahulshettyacademy.com").addHeader("Authorization", token)
			.setContentType(ContentType.JSON).build();
	RequestSpecification deleteOrdereq=given().log().all().spec(deleteOrderBasereq).pathParam("productId", productId);
	String deleteProductResponse=deleteOrdereq.when().delete("https://rahulshettyacademy.com/api/ecom/product/delete-product/{productId}")
	.then().log().all().extract().response().asString();
	
	JsonPath js1=new JsonPath(deleteProductResponse);
	
	Assert.assertEquals("Product Deleted Successfully", js1.get("message"));
	
	
}

}
