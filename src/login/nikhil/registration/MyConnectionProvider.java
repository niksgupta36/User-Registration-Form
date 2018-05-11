package login.nikhil.registration;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnectionProvider implements DataSource {

	static Connection conn=null;
	
	public static Connection getCon(){
		
		try{
			Class.forName("com.mysql.jdbc.driver");
			conn=DriverManager.getConnection(connURL, username, password);
			
		}catch(Exception e){
			System.out.println(e);
		}
		return conn;
		
	}
	
}
