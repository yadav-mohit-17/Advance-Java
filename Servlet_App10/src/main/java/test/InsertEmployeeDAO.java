package test;
import java.sql.*;
public class InsertEmployeeDAO {
	public int k=0;
	public int insert(EmployeeBean eb)
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("insert into Employee52 values(?,?,?,?,?)");
			ps.setString(1, eb.getid());
			ps.setString(2, eb.getname());
			ps.setString(3, eb.getdesg());
			ps.setInt(4, eb.getbsal());
			ps.setFloat(5, eb.getbsal());
			k=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return k;
	}
}
