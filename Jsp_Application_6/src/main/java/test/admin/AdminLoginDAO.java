package test.admin;
import java.sql.*;
import javax.servlet.http.*;
public class AdminLoginDAO {
	public AdminBean ab = null;
	public AdminBean login(HttpServletRequest req) {
	try 
	{
	Connection con = DBConnection.getCon();
	PreparedStatement ps = con.prepareStatement("select * from AdminTab52 where uname=? and pword=?");
	ps.setString(1, req.getParameter("uname"));
	ps.setString(2, req.getParameter("pword"));
	ResultSet rs = ps.executeQuery();
	if(rs.next()) 
	{
		ab = new AdminBean();
		ab.setUserName(rs.getString(1));
		ab.setPassword(rs.getString(2));
		ab.setFirstName(rs.getString(3));
		ab.setLastName(rs.getString(4));
		ab.setAddress(rs.getString(5));
		ab.setEmail_Id(rs.getString(6));
		ab.setPhoneNo(rs.getLong(7));
	}
	}catch(Exception e) 
	{
		e.printStackTrace();
	}
		return ab;
	}
}