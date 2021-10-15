package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class ExecuteUpdate {
  @Test
  public void executeUpdate() throws SQLException{
	  Connection con = null;
	try {
	//Step 1: Register the Database
	Driver driverref = new Driver();
	DriverManager.registerDriver(driverref);
	//Step 2:establish connection with database
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customers","root","root");
	//Step 3:issue create statement
	Statement stat=con.createStatement();
	//Step 4: Execute the query
	int result=stat.executeUpdate("insert into custome value(2, '122021', 'Kolkata','12/5')");
	
	if(result==1)
	   System.out.println("Project is created successfully");
		
	else
		System.out.println("query failed");
	
	} 
	 
	catch (Exception e) {
		
		
		
	}
	 
	   finally {
		 con.close();
	   }
	 
	
  }
		
}
