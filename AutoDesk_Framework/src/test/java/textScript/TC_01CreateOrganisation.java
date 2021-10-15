package textScript;

import java.awt.Window;
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

import com.crm.vtiger.genericUtils.JavaUtility;

public class TC_01CreateOrganisation {
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
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys("TYSS"+JavaUtility.getRandomData());
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();
		Thread.sleep(5000);
		WebElement orgName=driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']"));
		String orgname = orgName.getText();
		Thread.sleep(5000);
		WebElement moveElement=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions a = new Actions(driver);
		a.moveToElement(moveElement).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}
		
	}
	

