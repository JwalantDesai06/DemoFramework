package DemoTestJourney.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public ExcelReader() {}
	
	public static Map<String, HashMap<String, String>> getSheetData(String sheetName){
		
		Map<String, HashMap<String, String>> sheetMap = new HashMap<>();
		
		try (FileInputStream fis = new FileInputStream(new File(Constants.TEST_DATA_REPO));
        		
	             Workbook workbook = new XSSFWorkbook(fis)) {
			
			Sheet sheet = workbook.getSheet(sheetName);
        
        int rows = sheet.getPhysicalNumberOfRows();
        int columns = sheet.getRow(0).getPhysicalNumberOfCells();
        
        for(int i = 1; i < rows; i++) {
        	
        	Row headerRow = sheet.getRow(0);
        	
        	Row testRow = sheet.getRow(i);
        	
        	HashMap<String, String> testDataMap = new HashMap<>();
        	
        	for (int j = 0; j < columns; j++) {
        		
        		testDataMap.put(headerRow.getCell(j).getStringCellValue().trim(), testRow.getCell(j).getStringCellValue().trim());
     
        	}
        	
        	sheetMap.put(testRow.getCell(0).getStringCellValue(), testDataMap);
        	
        }
        
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return sheetMap;
		
	}
	
	
	public static void updateSheetData(Map<String, String> data, String sheetName) {        	

            try (FileInputStream fis = new FileInputStream(Constants.TEST_DATA_REPO);
                    Workbook workbook = new XSSFWorkbook(fis);
                    FileOutputStream fos = new FileOutputStream(Constants.TEST_DATA_REPO)) {
        	
        	

            Sheet sheet = workbook.getSheet(sheetName);

            Row headerRow = sheet.getRow(0);
            Row dataRow = sheet.getRow(1);
            
            int lastColumn = headerRow.getPhysicalNumberOfCells();
            
            headerRow.createCell(lastColumn).setCellValue(Constants.PAYMENT_INFORMATION);
            dataRow.createCell(lastColumn).setCellValue(data.get(Constants.PAYMENT_INFORMATION));
            headerRow.createCell(lastColumn+1).setCellValue(Constants.SHIPPING_INFORMATION);
            dataRow.createCell(lastColumn+1).setCellValue(data.get(Constants.SHIPPING_INFORMATION));
            headerRow.createCell(lastColumn+2).setCellValue(Constants.TOTAL_PRICE);
            dataRow.createCell(lastColumn+2).setCellValue(data.get(Constants.TOTAL_PRICE));
  

            workbook.write(fos);

        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
