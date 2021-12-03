package datadriven;
import org.testng.annotations.DataProvider;

public class DataForTests {

	
	@DataProvider(name = "dataForPost")
	public Object[][] dataForPost() {
//		Object[][] data = new Object[2][3];	
//		data[0][0] = 4;
//		data[0][1] = "Title4";
//		data[0][2] = "author4";
//		
//		data[1][0] = 5;
//		data[1][1] = "Title5";
//		data[1][2] = "author5";
//		
//		return data;
//		
		
		
		return new Object [][] {
			{6,"title6","author6"},
			{7,"title7","author7"}
		};
	}
	
	@DataProvider(name = "Deletedata")
	public Object[] dataForDelete() {
		
		return new Object[] {
				4,5,6,7
		};
	}
}
