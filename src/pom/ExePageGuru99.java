package pom;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ExePageGuru99 {
	
	WebDriver driver;
	
	@DataProvider
	public Object[][] dp()
	{
		
				Object[][] arrayObject = getExcelData("D:/sathish/pom/loginData.xlsx","Sheet1");
				return arrayObject;
	}
	@Parameters("browser")
	@BeforeClass
	public void setUp(String brw)
	{
		if(brw.equalsIgnoreCase("Firefox"))
		{
		System.setProperty("webdriver.gecko.driver","D:\\Alok\\jar\\geckodriver-v0.11.1-win64\\geckodriver.exe");
		driver = new FirefoxDriver();
		}
		else if(brw.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\Alok\\jar\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else
		{
			System.out.println("Check your PArameter");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/v4/");
	}
	@Test(dataProvider="dp")
	public void testCase(String st1,String st2) throws InterruptedException
	{
		PageGuru99 p=new PageGuru99(driver);
		p.login(st1,st2);
	
	}
	
	public String[][] getExcelData(String fileName, String sheetName) {
		String[][] arrayExcelData = null;
		try {
			FileInputStream fs = new FileInputStream(fileName);
			Workbook wb = new XSSFWorkbook(fs);
			Sheet sh = wb.getSheet(sheetName);
			Row r=sh.getRow(0);

			int totalNoOfCols = r.getLastCellNum();
			int totalNoOfRows = sh.getLastRowNum();
			//int r1=sh.getFirstRowNum();
			//System.out.println("Total num of column:"+totalNoOfCols);
			//System.out.println("Total num of Rows:"+totalNoOfRows);
			//System.out.println("First Row num is:"+r1);
			arrayExcelData = new String[totalNoOfRows][totalNoOfCols];
			
			for (int i= 1 ; i <=totalNoOfRows; i++) {
				r=sh.getRow(i);
				for (int j=0; j < totalNoOfCols; j++) {
					arrayExcelData[i-1][j] = r.getCell(j).toString();
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			e.printStackTrace();
		} 
		return arrayExcelData;
}
}
