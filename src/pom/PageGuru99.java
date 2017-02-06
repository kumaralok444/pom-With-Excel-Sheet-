package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageGuru99 {
	WebDriver driver;
	PageGuru99(WebDriver driver)
	{
		this.driver=driver;
	}
	public void login(String uName,String password) throws InterruptedException
	{
		WebElement we1=driver.findElement(By.name("uid"));
		we1.clear();
		we1.sendKeys(uName);
	    we1=driver.findElement(By.name("password"));
	    we1.clear();
		we1.sendKeys(password);
		we1=driver.findElement(By.name("btnLogin"));
		we1.click();
		Thread.sleep(1000);
		Alert a= driver.switchTo().alert();
		//String s=a.getText();
		a.accept();
		driver.switchTo().defaultContent();
	}
	

}
