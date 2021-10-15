package Practice;

import org.testng.annotations.Test;


public class CreateCustomerTest {
 @Test
 public void createCustomerTest()
 {
	 String USERNAME= System.getProperty("username");
	 String PASSWORD= System.getProperty("password");
	 String BROWSER= System.getProperty("browser");
	 String URL= System.getProperty("url");
	 
	 System.out.println(USERNAME+" "+PASSWORD+" "+BROWSER+" "+URL);
	 
 }
	
}









