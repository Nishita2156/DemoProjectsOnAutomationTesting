package files;

import io.restassured.path.json.JsonPath;

public class ResuableMethods {
	
	public static JsonPath rawtoJson(String response) {
		JsonPath js=new JsonPath(response);
		return js;
	}

}
