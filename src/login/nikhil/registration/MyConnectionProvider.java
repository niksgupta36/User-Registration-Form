package login.nikhil.registration;

import java.sql.*;


public class MyConnectionProvider implements DataSource {

	static Connection conn=null;
	
	public static Connection getCon(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/logindb");
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
		
	}
	
}
