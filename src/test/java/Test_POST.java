import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.runner.Request;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import utils.ExcelUtils;

import static io.restassured.RestAssured.*;

public class Test_POST {

	//@Test
	public void test_1_post() {
		//		Map<String, Object> map = new HashMap<String, Object>();

		//		map.put("name", "Raghav");
		//		map.put("job", "Teacher");
		//		
		//		System.out.println(map);


		JSONObject request = new JSONObject();
		request.put("name", "Raghav");
		request.put("job", "Teacher");

		//System.out.println(request.toJSONString());

		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		post("https://reqres.in/api/users").
		then().
		statusCode(201);

	}

	//@Test
	public void test_2_put() {



		JSONObject request = new JSONObject();
		request.put("name", "Raghav");
		request.put("job", "Teacher");


		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		put("https://reqres.in/api/users/2").
		then().
		statusCode(200).
		log().all();

	}

	//@Test
	public void test_3_patch() {



		JSONObject request = new JSONObject();
		request.put("name", "Raghav");
		request.put("job", "Teacher");


		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(request.toJSONString()).
		when().
		patch("https://reqres.in/api/users/2").
		then().
		statusCode(200).
		log().all();

	}

	@Test
	public void test_4_post() {

		String excelPath = "./data/testData.xlsx";
		String sheetName = "sheet1";

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		int rowCount = ExcelUtils.getRowCount();
		JSONObject request = new JSONObject();
		JSONArray arr = new JSONArray();
		
		for (int i = 1; i < rowCount; i++) {
			JSONObject row = new JSONObject();
			for (int j = 0; j < 3; j++) {
				row.put(excel.getCellData(0, j),excel.getCellData(i, j));
			}
			arr.add(row);
		}
		System.out.println(arr.toJSONString());
		
		baseURI = "http://localhost:3000/";
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(arr.toJSONString()).
		when().
			post("/posts").
		then().
			statusCode(201).
			log().all();
		
	}
}
