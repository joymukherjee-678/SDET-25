package Practice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutoSuggestion {

	static {
		
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver1.exe");
	}
	
    @Test
	public void findAllOption() throws InterruptedException
	{
    	//System.setProperty("webdriver.chrome.driver", "./driver/chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[contains(text(),'✕')]")).click();
		driver.findElement(By.name("q")).sendKeys("samsung mobiles"+Keys.ENTER);
		List<WebElement> allLinks = driver.findElements(By.xpath("//div[contains(text(),'SAMSUNG')]"));
		
		for(WebElement s:allLinks)
		{
			System.out.println(s.getText());
			
		}
		
		WebElement phoneLink = driver.findElement(By.xpath("//div[text()='SAMSUNG Galaxy F22 (Denim Blue, 128 GB)']"));
		WebElement priceLink = driver.findElement(By.xpath("//div[contains(text(),'SAMSUNG Galaxy F22')]/../../div[2]/div/div/div"));
		
		System.out.println("The price of "+phoneLink.getText()+" is "+priceLink.getText());
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='SAMSUNG Galaxy F22 (Denim Blue, 128 GB)']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//button)[2]")).click();
		
		//driver.close();
		
	}

}
