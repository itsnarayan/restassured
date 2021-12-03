package datadriven;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import io.restassured.http.ContentType;



public class DataDrivenExamples extends DataForTests {
	
	

	//@Test(dataProvider = "dataForPost")
	//@Test
	public void test_post(int id, String title, String author) {

		JSONObject request = new JSONObject();
		request.put("id", id);
		request.put("title", title);
		request.put("author", author);

		baseURI = "http://localhost:3000/";
		given().
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("/posts").
		then().
		statusCode(201).
		log().all();
	}
	
	@Parameters({"id","title","author"})
	@Test
	public void test_post_2(int id, String title, String author) {

			JSONObject request = new JSONObject();
			request.put("id", id);
			request.put("title", title);
			request.put("author", author);
			
			System.out.println(request.toJSONString());

			baseURI = "http://localhost:3000/";
			given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
			when().
			post("/posts").
			then().
			statusCode(201).
			log().all();
		}
	
	
	//@Test(dataProvider = "Deletedata")
//	@Test
	public void test_delete(int id) {
		given().
			delete("https://reqres.in/api/users/"+id).
		then().
			statusCode(204).
			log().all();
		
	}


}
