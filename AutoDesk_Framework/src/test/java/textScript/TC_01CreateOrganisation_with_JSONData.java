package textScript;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.vtiger.genericUtils.ExcelUtility;
import com.crm.vtiger.genericUtils.FileUtility;
import com.crm.vtiger.genericUtils.JavaUtility;
import com.crm.vtiger.genericUtils.WedDriverUtility;

public class TC_01CreateOrganisation_with_JSONData {
static {
		
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");   
	}

    @Test
	public void createOrganisation_with_JSONData() throws IOException, ParseException, InterruptedException, EncryptedDocumentException, InvalidFormatException
	{
    	WebDriver driver = new FirefoxDriver();
    	FileUtility file = new FileUtility();
    	ExcelUtility excel= new ExcelUtility();
    	WedDriverUtility wbutility = new WedDriverUtility();
    	String url=file.getDataFromJson("url");
    	String username=file.getDataFromJson("username");
    	String password = file.getDataFromJson("password");
    	driver.get(url);
    	driver.findElement(By.xpath("//input[@type='text' and @name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password' and @name='user_password']")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[.='Organizations']")).click();
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		String orgname = excel.getExcelData("Sheet1",1,1);
		driver.findElement(By.name("accountname")).sendKeys(orgname+JavaUtility.getRandomData());
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//input[@accesskey='S'])[1]")).click();
		Thread.sleep(5000);
		//WebElement orgName=driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']"));
		//String orgname = orgName.getText();
		Thread.sleep(5000);
		WebElement moveElement=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		//Actions a = new Actions(driver);
		wbutility.mouseOver(driver, moveElement);
		//a.moveToElement(moveElement).perform();
		driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		
		
		
	}
}
