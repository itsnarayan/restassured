import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Test_DELETE {
	
	@Test
	public void test_1_delete() {
		given().
			delete("https://reqres.in/api/users/2").
		then().
			statusCode(204).
			log().all();
		
	}
	

}
