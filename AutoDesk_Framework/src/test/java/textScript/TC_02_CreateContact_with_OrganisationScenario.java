package textScript;

import java.awt.Window;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class TC_02_CreateContact_with_OrganisationScenario {
	static {
		
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");   
	}

	@Test
	public void fillingOrganisationInfo() throws InterruptedException
	{
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.findElement(By.xpath("//input[@type='text' and @name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@type='password' and @name='user_password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		WebElement firstName = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		Select s = new Select(firstName);
		s.selectByIndex(1);
		driver.findElement(By.name("firstname")).sendKeys("Joy");
		driver.findElement(By.name("lastname")).sendKeys("Mukherjee");
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		Set<String> allwh = driver.getWindowHandles();
		String parentTile = driver.getWindowHandle();
		Iterator<String> itr = allwh.iterator();
		//for(int i=0;i<allwh.size();i++)
		//{
			while(itr.hasNext())
			{
				
			  String wh = itr.next();
			  driver.switchTo().window(wh);
			  System.out.println(driver.getTitle());
			  Thread.sleep(5000);
			  if(!parentTile.equals(wh))
			  {
			//String orgname = orgName.getText();
			//System.out.println(orgname);
			//Thread.sleep(5000);
			driver.findElement(By.xpath("//a[.='TYSS']")).click();
			Thread.sleep(6000);
			//driver.close();
			//driver.findElement(By.className("txtBox")).sendKeys(Keys.ENTER);
		//	driver.findElement(By.xpath("//a[contains(text(),'TYSS')]")).click();
			//driver.switchTo().window(wh);
			//JavascriptExecutor j = (JavascriptExecutor)driver;
		//	j.executeScript("window.scrollBy(0,document.body.scrollHeight)");
			//driver.findElement(By.xpath("//a[contains(text(),'TYSS')]")).click();
			  }
		     // driver.close();
			  //driver.switchTo().window(parentTile);
			}
			driver.switchTo().window(parentTile);
		
		//driver.switchTo().window(parentTile);
	
	   driver.findElement(By.name("button")).click();
	   Thread.sleep(5000);
	   WebElement moveElement=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	   Actions a = new Actions(driver);
	   a.moveToElement(moveElement).perform();
	   driver.findElement(By.xpath("//a[.='Sign Out']")).click();
}
}