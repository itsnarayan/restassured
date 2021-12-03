import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Test_GET {
	
	@Test
	public void test_01() {
		given().
			
			get("https://reqres.in/api/users?page=2").
		then().
			body("data.id[0]", equalTo(7)).
			body("data.first_name",hasItems("Michael","Lindsay"));
		
	}

}
