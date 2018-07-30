package readDataFromExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
	public String[][] getDataFromExcel(String excellocation,String sheetName) throws IOException
	{
		String dataSets[][]=null;
		FileInputStream fis=new FileInputStream(new File(excellocation));
		
		//create workbook instance for storing .xlsx file
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		//count number of rows
		int totalRows = sheet.getLastRowNum();
		//count number of columns in a row
		int totalcolumns = sheet.getRow(0).getLastCellNum();
		dataSets=new String[totalRows][totalcolumns];
		//iterate each row one by one
		Iterator<Row> rowIterator = sheet.iterator();
		int i=0;
	    while(rowIterator.hasNext())
	    {
	    	Row row = rowIterator.next();
	    	Iterator<Cell> cellIterator = row.cellIterator();
	    	int j=0;
	    	while(cellIterator.hasNext())
	    	{
	    		Cell cell = cellIterator.next();
	    		if(cell.getStringCellValue().contains("UserName"))
	    		{
	    			break;
	    		}
	    		switch(cell.getCellType()) {
	    		case Cell.CELL_TYPE_NUMERIC:
	    		dataSets[i-1][j++]=cell.getStringCellValue();
	    		System.out.println(cell.getNumericCellValue());
	    		break;
	    		case Cell.CELL_TYPE_STRING:
	    		dataSets[i-1][j++]=cell.getStringCellValue();
	    		System.out.println(cell.getStringCellValue());
	    		break;
	    		case Cell.CELL_TYPE_BOOLEAN:
	    		dataSets[i-1][j++]=cell.getStringCellValue();
	    		System.out.println(cell.getStringCellValue());
	    		break;
	    		case Cell.CELL_TYPE_FORMULA:
	    		dataSets[i-1][j++]=cell.getStringCellValue();
	    		System.out.println(cell.getStringCellValue());
	    		break;
	    		
	    	}
	    	}
	    	 System.out.println("");
	    i++;
	}
	    fis.close();
	    return dataSets;
	}
	
	
	public void updateReporting(String excellocation,String sheetName,String testcaseName,String status) throws IOException
	{
		FileInputStream fis=new FileInputStream(new File(excellocation));
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet(sheetName);
		int totalRows = sheet.getLastRowNum()+1;
		for(int i=0; i<totalRows; i++)
		{
			XSSFRow row = sheet.getRow(i);
			String cellString = row.getCell(1).getStringCellValue();
			if(cellString.contains(testcaseName))
			{
				XSSFCellStyle style = workbook.createCellStyle();
				style.setFillForegroundColor(IndexedColors.BLUE.index);
				XSSFCell cell = row.createCell(2);
				cell.setCellValue(status);
				cell.setCellStyle(style);
				
				fis.close();
				System.out.println("results updated");
				FileOutputStream fos=new FileOutputStream(new File(excellocation));
				workbook.write(fos);
				fos.close();
				break;
			}
		}
		
	}
	/*public static void main(String[] args) throws IOException {
		ReadDataFromExcel read=new ReadDataFromExcel();
		String path = System.getProperty("user.dir")+"\\src\\main\\java\\com\\sreenu\\testdata\\Emails.xlsx";
		System.out.println(path);
		//read.getDataFromExcel(path,"Sheet1");
		
		read.updateReporting(path, "Reporting", "Registration Test", "Pass");
		read.updateReporting(path, "Reporting", "Login Test", "Fail");
		read.updateReporting(path, "Reporting", "Home Test", "pass");
		read.updateReporting(path, "Reporting", "DashBoard Test","Fail");
		
	}*/
}


