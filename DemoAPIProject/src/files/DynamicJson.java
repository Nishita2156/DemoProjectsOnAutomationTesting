package files;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DynamicJson {
	
	@Test(dataProvider="BooksData")
	public void addBook(String isbn, String aisle) {
		RestAssured.basePath="http://216.10.245.166";
		String response=given().log().all().header("Content-type", "application/json")
		.body(Payload.addBook(isbn,aisle))
		.when()
		.post("/Library/AddBook.php")
		.then().assertThat().statusCode(200)
		.extract().response().asString();
		JsonPath js=ResuableMethods.rawtoJson(response);
		String id=js.get("ID");
		System.out.println(id);
		//delete book at the same time to prevent failure 
	}
	//testNg data provider annotation
	//array-collection of elements, multi dimensional array-collection of arrays
	@DataProvider(name="BooksData")
	public Object[][] getData() {
		return new Object[][] {{"rtyi","1234"},{"erty","4567"},{"fght","3456"}};
		
	}

}
