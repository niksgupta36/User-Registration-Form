package  login.nikhil.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;



public class CustomerDAOImpl implements CustomerDAO {
	
	static Connection conn;
	static PreparedStatement ps;
	@Override
	public int insertCustomer(Customer c) {

		int status=0;
		try{
			conn=MyConnectionProvider.getCon();
			ps = conn.prepareStatement("insert into customer values(?,?)");
			ps.setString(1, c.getUsername());
			ps.setString(2, c.getPassword());
			ps.setString(3, c.getName());
			status = ps.executeUpdate();
			conn.close();
					
		}catch(Exception e){
			System.out.println(e);
		}
		return status;
	}

	@Override
	public Customer getCustomer(String userid, String password) {
		Customer c = new Customer();
		try{
			conn = MyConnectionProvider.getCon();
			ps=conn.prepareStatement("select * from customer where Customer=? and Password=?");
			ps.setString(1, userid );
			ps.setString(2, password );
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				c.setUsername(rs.getString(1));
				c.setPassword(rs.getString(2));
				c.setName(rs.getString(3));
				
			}
			
			
		}catch(Exception e){
			System.out.println(e);
		}

		return c;
	}

}
