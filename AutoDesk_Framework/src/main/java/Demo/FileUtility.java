package Demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class FileUtility {

	
@Test
public String getPropertyValue(String key) throws IOException
{
	/*read the data from properties file*/
	//step 1: get the java representation object of the physical file*/
     // FileReader reader = new FileReader(IPathConstant);
	//step 2: create an object of the properties class & load the all keys:value pair
	Properties pobj = new Properties();
//	pobj.load(fis);
	//step 3:read the value using getProperty(key)
	
		return pobj.getProperty(key);
	
}
	
}
