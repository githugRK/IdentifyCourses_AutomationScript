package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	//DataProvider 1
	
	@DataProvider(name="EnterpriseFormValidation")
	public String[][] getData() throws IOException {
	    String path = ".\\TestData\\LoginData.xlsx"; // Path to Excel file

	    ExcelUtility xlutil = new ExcelUtility(path); // Create Excel utility object

	    int totalRows = xlutil.getRowCount("Sheet1") ; // Get total rows
	    int totalCols = xlutil.getCellCount("Sheet1", 1); // Get total columns from row 1
	    String[][] loginData = new String[totalRows][totalCols]; // Create 2D array

	    for (int i = 1; i <= totalRows; i++) 
	    { // Start from row 1 (skip header)
	        for (int j = 0; j < totalCols; j++) 
	        {
	            loginData[i - 1][j] = xlutil.getCellData("Sheet1", i, j); // Fill array
	        }
	    }

	    return loginData; // Return data to test method
	}

	
	//DataProvider 2
	
	//DataProvider 3
	
	//DataProvider 4
}

