package CymousBankGenerics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility 
{
	Connection connection;
	public void connect_To_Database() throws SQLException 
	{ 
		//Register Driver
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		// Connect to Database
		connection = DriverManager.getConnection(PathConstants.mysqlurl,PathConstants.mysqlusername,PathConstants.mysqlpassword );
	}

//	public ResultSet Get_Data(String TableName) throws SQLException 
//	{ 
//		//Register Driver
//		Driver driver= new Driver();
//		DriverManager.registerDriver(driver);
//		
//		// Connect to Database
//		Connection connection = DriverManager.getConnection(PathConstants.mysqlurl,PathConstants.mysqlusername,PathConstants.mysqlpassword );
//		
//		//Create Statement
//		Statement statement = connection.createStatement();
//		String query="Select * from "+TableName+"" ;
//		
//		// Executing the Script
//		ResultSet resultSet = statement.executeQuery(query);
//		
//		return resultSet;
//	}
	
//	public ResultSet Insert_Data(String TableName) throws SQLException 
//	{ 
//		//Register Driver
//		Driver driver= new Driver();
//		DriverManager.registerDriver(driver);
//		
//		// Connect to Database
//		Connection connection = DriverManager.getConnection(PathConstants.mysqlurl,PathConstants.mysqlusername,PathConstants.mysqlpassword );
//		
//		//Create Statement
//		Statement statement = connection.createStatement();
//		String query="insert into "+TableName+" Values ()" ;
//		
//		// Executing the Script
//		ResultSet resultSet = statement.executeQuery(query);
//		
//		return resultSet;
//	}
	
	public void disconnect_From_Database() throws SQLException 
	{ 
		connection.close();
	}


}
