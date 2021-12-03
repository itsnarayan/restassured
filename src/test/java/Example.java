import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class Example {

	//	@Test
	public void test_get() {
		baseURI = "http://localhost:3000/";
		given().
			params("id","1").
			get("/comments").
		then().
			statusCode(200).
			body("id[0]", equalTo(1)).
			log().all();
	}

	//@Test
	public void test_post() {

		JSONObject request = new JSONObject();
		request.put("id", "2");
		request.put("title", "Apache");
		request.put("author", "Peter");

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

	//@Test
	public void test_put() {


		JSONObject request = new JSONObject();
		request.put("id", "3");
		request.put("title", "Java");
		request.put("author", "John");

		baseURI = "http://localhost:3000/";
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			put("/posts/3").
		then().
			statusCode(200).
			log().all();
	}


	//@Test
	public void test_patch() {


		JSONObject request = new JSONObject();
		request.put("author", "Thomas");

		baseURI = "http://localhost:3000/";
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("/posts/2").
		then().
			statusCode(200).
			log().all();
	}
	
//	@Test
	public void test_delete() {

		baseURI = "http://localhost:3000/";
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
		when().
			delete("/posts/3").
		then().
			statusCode(200).
			log().all();
	}
}
