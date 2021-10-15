package Practice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class contact {
  @Test
  public void org(XmlTest xml)
  {
	  System.out.println("excecute1");
	  String URL = xml.getParameter("url");
	  String UN = xml.getParameter("username");
	  String Password = xml.getParameter("password");
	  String Browser = xml.getParameter("browser");
	  System.out.println(URL);
	  System.out.println(UN);   
	  System.out.println(Password);
	  System.out.println(Browser);
  }
	
}
