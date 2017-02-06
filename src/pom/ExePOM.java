package pom;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExePOM {
	WebDriver driver;
	String baseUrl="https://www.flipkart.com/";
	@DataProvider
	public Object[][] dp()
	{
		return new Object[][]
				{
					new Object[]{"priyasham4@yahoo.com","hari#16"},
					new Object[]{"priyaa31@gmail.com","hari16"}
				};
	}
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver","D:\\Alok\\jar\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get(baseUrl);
	}
	@Test(enabled=false)
	public void testCAse()
	{
		Page p=new Page(driver);
		p.open(baseUrl);
		p.logIn("priyasham4@yahoo.com","hari*16");
		p.searchItem("Watch");
		p.logOut();
	}
	@Test(dataProvider ="dp")
	public void testCAse2(String st1,String st2)
	{
		Page p=new Page(driver);
		p.clickLogin();
		p.logIn(st1, st2);
		
		
	}
}
