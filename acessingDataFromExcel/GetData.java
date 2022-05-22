package acessingDataFromExcel;

import java.io.File;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class GetData {
	
	public static Object[][] getData(String xcelPath, String sheetName) throws EncryptedDocumentException, IOException  {
		
		       
				Object obj[][] = null;	
				Workbook workbook = WorkbookFactory.create(new File(xcelPath));
     	     	Sheet sheet  = workbook.getSheet(sheetName);
     	     	
     	     	int rows = sheet.getLastRowNum();
     	     	int cols= sheet.getRow(1).getLastCellNum();
     	     	
     	     	 obj = new Object[rows][cols];
     	     	
     	     	for(int i = 0; i< rows; i++) {
     	     		
     	     		for(int j = 0; j<cols; j++) {
     	     			
     	     			obj[i][j] = sheet.getRow(i+1).getCell(j).toString();
     	     		}
     	     	}

				return obj;
		
	}

}
