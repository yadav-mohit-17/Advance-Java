package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.HttpServletRequest;

public class StudentDAO {
	public StudentBean sb=null;
	
	public StudentBean login(HttpServletRequest req) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from StudentDetails where name=? and password=?");
			ps.setString(1, req.getParameter("name"));
			ps.setString(2, req.getParameter("pwd"));
			
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				sb=new StudentBean();
				sb.setId(rs.getString(1));
				sb.setName(rs.getString(2));
				sb.setCourse(rs.getString(3));
				sb.setPassword(rs.getString(4));
				sb.setMobile(rs.getString(5));
				sb.setAddress(rs.getString(6));
				
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return sb;
	}

}
