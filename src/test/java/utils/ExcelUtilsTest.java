package utils;

public class ExcelUtilsTest {
	
	public static void main(String[] args) {
		String excelPath = "./data/testData.xlsx";
		String sheetName = "sheet1";
		
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		
		excel.getRowCount();
		excel.getCellData(0, 0);
		excel.getCellData(0, 1);
	}

	
}
