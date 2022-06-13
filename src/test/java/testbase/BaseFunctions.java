package testbase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

public class BaseFunctions extends BaseTest{
	
	
	
	public BaseFunctions() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void takeScreeenShot(String filepath) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File src = screenshot.getScreenshotAs(OutputType.FILE); 	
		File dest = new File(System.getProperty("user.dir")+"\\screenshots\\"+filepath);
		FileHandler.copy(src, dest);
	}
	
	public String getExcelData(String filepath, int sheet_number, int rowIndex, int cellnum) throws IOException {
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\" + filepath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(sheet_number);
		return sheet.getRow(rowIndex).getCell(cellnum).getStringCellValue();
	}
	
	public void sendData(String filepath, String value) throws IOException {
		File file = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\" + filepath);
		FileOutputStream fos = new FileOutputStream(file);
		byte b[] = value.getBytes();
		fos.write(b);
	}

}
