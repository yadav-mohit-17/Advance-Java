package test;
import java.sql.*;
@SuppressWarnings("unused")
public class RegisterDAO {
	public int k=0;
	public int register(RegisterBean rb)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into practice1 values(?,?,?,?,?,?,?)");
			ps.setString(1, rb.getuName());
			ps.setString(2, rb.getpWord());
			ps.setString(3, rb.getfName());
			ps.setString(4, rb.getlName());
			ps.setString(5, rb.geteId());
			ps.setString(6, rb.getAddress());
			ps.setLong(7, rb.getPhNo());
			
			int k=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
}
