package test;
import java.sql.*;
import javax.servlet.http.*;
public class LoginDAO {
 public RegisterBean rb=null;
 public RegisterBean login(HttpServletRequest req)
 {
	 try
	 {
		 Connection con=DBConnection.getCon();
		 PreparedStatement ps=con.prepareStatement("select * from practice1 where username=?,password=?");
		 
		 ps.setString(1, req.getParameter("uname"));
		 ps.setString(2, req.getParameter("pword"));		 
		 ResultSet rs=ps.executeQuery();
		 while(rs.next())
		 {
			 rb=new RegisterBean();
			 rb.setuName(rs.getString(1));
			 rb.setpWord(rs.getString(2));
			 rb.setfName(rs.getString(3));
			 rb.setlName(rs.getString(4));
			 rb.seteId(rs.getString(5));
			 rb.setAddress(rs.getString(6));
			 rb.setPhNo(rs.getLong(7));
		 }
	 }
	 catch(Exception e)
	 {
		 e.printStackTrace();
	 }
	return rb;
	 
 }
}
