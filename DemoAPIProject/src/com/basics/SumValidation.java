package com.basics;

import org.testng.Assert;
import org.testng.annotations.Test;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	
	
	//verify all  the prices are equal to purchase amount--
	@Test
	public void sumValidate() {
		int sum=0;
		JsonPath js=new JsonPath(Payload.coursePrice());
		int courseNumber=js.getInt("courses.size()");
		for(int i=0;i<courseNumber;i++) {
			
		int allCoursePrice= js.getInt("courses["+i+"].price");
		int allCoursecopies=js.getInt("courses["+i+"].copies");
		int totalCopyPrice=allCoursePrice * allCoursecopies;
		System.out.println(totalCopyPrice);
		sum=sum + totalCopyPrice;
		
		}
		System.out.println(sum);
		int actualAmount=js.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(actualAmount, sum);
		
	}

}
