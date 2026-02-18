package files;

public class Payload {
	
	public static String addPlace() {
		return "{\r\n"
				+ "  \"location\": {\r\n"
				+ "    \"lat\": -38.383494,\r\n"
				+ "    \"lng\": 33.427362\r\n"
				+ "  },\r\n"
				+ "  \"accuracy\": 50,\r\n"
				+ "  \"name\": \"Frontline house\",\r\n"
				+ "  \"phone_number\": \"(+91) 983 893 3937\",\r\n"
				+ "  \"address\": \"29, side layout, cohen 09\",\r\n"
				+ "  \"types\": [\r\n"
				+ "    \"shoe park\",\r\n"
				+ "    \"shop\"\r\n"
				+ "  ],\r\n"
				+ "  \"website\": \"http://google.com\",\r\n"
				+ "  \"language\": \"French-IN\"\r\n"
				+ "}\r\n"
				+ "";
	}
	 public static String coursePrice() {
		 return "{\r\n"
		 		+ "  \"dashboard\":{\r\n"
		 		+ "    \"purchaseAmount\":590,\r\n"
		 		+ "    \"website\":\"rahulshettyacademy.com\"\r\n"
		 		+ "    \r\n"
		 		+ "    \r\n"
		 		+ "  },\r\n"
		 		+ "  \"courses\":[\r\n"
		 		+ "    {\r\n"
		 		+ "      \"title\":\"Selenium Java\",\r\n"
		 		+ "      \"price\":60,\r\n"
		 		+ "      \"copies\":5\r\n"
		 		+ "      \r\n"
		 		+ "    },\r\n"
		 		+ "    {\r\n"
		 		+ "    \"title\":\"Rest-Assured\",\r\n"
		 		+ "    \"price\":70,\r\n"
		 		+ "    \"copies\":3\r\n"
		 		+ "    },\r\n"
		 		+ "    {\r\n"
		 		+ "    \"title\":\"mySql\",\r\n"
		 		+ "    \"price\":40,\r\n"
		 		+ "    \"copies\":2\r\n"
		 		+ "    }\r\n"
		 		+ "  ]\r\n"
		 		+ "}";
	 }
	 public static String addBook(String isbn, String aisle) {
		 String payload="{\r\n"
		 		+ "    \"name\":\"learn Appium Automation with Java\",\r\n"
		 		+ "    \"isbn\": \""+isbn+"\",\r\n"
		 		+ "    \"aisle\":"+aisle+",\r\n"
		 		+ "    \"author\":\"John doe\"\r\n"
		 		+ "}";
		 return payload;
	 }

}
