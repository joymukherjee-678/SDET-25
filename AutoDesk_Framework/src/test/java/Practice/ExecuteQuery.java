package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class ExecuteQuery {
  @Test
  public void executeQuery() throws SQLException{
	//Step 1: Register the Database
	Driver driverref = new Driver();
	DriverManager.registerDriver(driverref);
	//Step 2:establish connection with database
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/customers","root","root");
	//Step 3:issue create statement
	Statement stat=con.createStatement();
	//Step 4: Execute the query
	ResultSet result=stat.executeQuery("select * from customer;");
	while(result.next())
	{
		
		System.out.println(result.getString(3));
		
	}
  }
		
}
