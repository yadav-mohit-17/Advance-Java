package test;
import java.sql.*;
import java.util.*;
public class ViewEmployeeDAO {
	public ArrayList<EmployeeBean> al=new ArrayList<EmployeeBean>();
	public ArrayList<EmployeeBean> retrieve()
	{
		try
		{
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from Employee52");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				EmployeeBean eb=new EmployeeBean();
				eb.setid(rs.getString(1));
				eb.setname(rs.getString(2));
				eb.setdesg(rs.getString(3));
				eb.setbsal(rs.getInt(4));
				eb.setotsal(rs.getFloat(5));
				al.add(eb); //add bean object to ArrayList
			}//end of loop
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
}