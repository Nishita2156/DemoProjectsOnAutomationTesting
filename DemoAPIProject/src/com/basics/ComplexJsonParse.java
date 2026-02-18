package com.basics;

import files.Payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
	public static void main(String[] args) {
		
	
	JsonPath js=new JsonPath(Payload.coursePrice());
	//print the number of courses
	int courseNumber=js.getInt("courses.size()");
	System.out.println(courseNumber);
	//print purchse amount
	int totalPurchaseAmount=js.getInt("dashboard.purchaseAmount");
	System.out.println(totalPurchaseAmount);
	//print title of the course
	String firstCourseTitle=js.get("courses[0].title");
	System.out.println(firstCourseTitle);
	//print all course titles and respectives prices , have to iterate it 
	for(int i=0;i<courseNumber;i++) {
		String allCourseTitle=js.get("courses["+i+"].title");
		System.out.println(js.get("courses["+i+"].price").toString());//no matter what data type you working with if you convert it to string it will work
		System.out.println(allCourseTitle);
	}
		//print the no of copies sold by rpa course
		System.out.println("Print the number of copies sold by Rest-assured");
		for(int i=0;i<courseNumber;i++) {
			String courseTitles=js.get("courses["+i+"].title");
			if(courseTitles.equals("Rest-Assured")) {
				int numberOfRestAssuredCopies=js.getInt("courses["+i+"].copies");
				System.out.println(numberOfRestAssuredCopies);
				break;
				
			}
			
		}
		
		
		
		
		
	}
	
	

}
