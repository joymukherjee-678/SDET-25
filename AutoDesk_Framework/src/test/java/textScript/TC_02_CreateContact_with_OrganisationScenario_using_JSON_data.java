package textScript;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.crm.vtiger.genericUtils.ExcelUtility;
import com.crm.vtiger.genericUtils.FileUtility;
import com.crm.vtiger.genericUtils.WedDriverUtility;

public class TC_02_CreateContact_with_OrganisationScenario_using_JSON_data {

static {
		
		System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");   
	}

    @Test
	public void createContact_with_OrganisationScenario_using_JSON_data() throws IOException, ParseException, InterruptedException, EncryptedDocumentException, InvalidFormatException
	{
    	WebDriver driver = new FirefoxDriver();
    	FileUtility file = new FileUtility();
    	WedDriverUtility wbu = new WedDriverUtility();
    	ExcelUtility exutl = new ExcelUtility() ;
    	String url=file.getDataFromJson("url");
    	String username=file.getDataFromJson("username");
    	String password = file.getDataFromJson("password");
    	driver.get(url);
    	driver.findElement(By.xpath("//input[@type='text' and @name='user_name']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@type='password' and @name='user_password']")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[.='Contacts']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		WebElement firstName = driver.findElement(By.xpath("//select[@name='salutationtype']"));
	//	Select s = new Select(firstName);
		//s.selectByIndex(1);
		wbu.SelectOption(firstName, 1);
		driver.findElement(By.name("firstname")).sendKeys(exutl.getExcelData("Sheet1",4,1));
		driver.findElement(By.name("lastname")).sendKeys(exutl.getExcelData("Sheet1",4,2));
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
			driver.findElement(By.xpath("//a[.='TYSS-375884595']")).click();
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
