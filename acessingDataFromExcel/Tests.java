package acessingDataFromExcel;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class Tests{
	
@Test(dataProvider = "getData" )
public void test1(String Name, String Role) {
	
	System.out.println(Name + " :- "+ Role);	
}

@DataProvider
public Object[][] getData() throws EncryptedDocumentException, IOException {
	
	return GetData.getData("C:\\Users\\PBALAJIK\\Selenium_Workspace\\HSBC_SeleniumTraining\\src\\test\\java\\acessingDataFromExcel\\data.xlsx","Sheet1");
	
}

}
