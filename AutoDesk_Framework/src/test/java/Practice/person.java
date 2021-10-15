package Practice;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class person {
@Test
public void der(XmlTest xml)
{
System.out.println("execute2");
System.out.println(xml.getParameter("personName"));
}
}
