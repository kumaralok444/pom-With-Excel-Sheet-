package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Page {
	WebDriver wd;
	Page(WebDriver driver)
	{
		wd=driver;
	}
	public void open(String url)
	{
		wd.get(url);
	}
	public void clickLogin()
	{
		wd.findElement(By.linkText("Log In")).click();
	}
	public void logIn(String uname, String passwd)
	{
		WebElement we;
	    we=wd.findElement(By.xpath("html/body/div[2]/div/div/div/div/div[2]/div/form/div[1]/input"));
	   
	    we.sendKeys(uname);
	    we=wd.findElement(By.xpath("html/body/div[3]/div/div/div/div/div[2]/div/form/div[2]/input"));
	   
	    we.sendKeys(passwd);
	    we=wd.findElement(By.xpath("html/body/div[3]/div/div/div/div/div[2]/div/form/div[3]/button"));
	    we.click();
	    
	}
	public void searchItem(String item)
	{
		WebElement we=wd.findElement(By.name("q"));
		we.sendKeys(item);
		we.submit();
	}
	public void logOut()
	{
		 WebElement we=wd.findElement(By.className("_2mEF1S"));	  
		    Actions a=new Actions(wd);
		    a.moveToElement(we).build().perform();
		    we=wd.findElement(By.linkText("Log Out"));
		    we.click();
	}

}
