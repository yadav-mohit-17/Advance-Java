package test;
import java.sql.*;
import javax.servlet.http.*;

public class LoginDao {
	public UserBean ub=null;
	
	public UserBean login(HttpServletRequest req) {
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from userregtest52 where uname=? and pword=?");
			ps.setString(1, "uname");
			ps.setString(2, "pword");
			
			ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				ub=new UserBean();
				ub.setuName(rs.getString(1));
				ub.setpWord(rs.getString(2));
				ub.setfName(rs.getString(3));
				ub.setlName(rs.getString(4));
				ub.setAddr(rs.getString(5));
				ub.setmId(rs.getString(6));
				ub.setPhNo(rs.getLong(7));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ub;
	}
}
