package test.user;
import java.sql.*;
import java.util.*;
public class ViewProductDAO {

	public ArrayList<ProductBean> al=new ArrayList<ProductBean>();
	public ArrayList<ProductBean> retrieve()
	{
		try {
			Connection con=DBConnection.getCon();
			PreparedStatement ps=con.prepareStatement("select * from product52");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				ProductBean pb=new ProductBean();
				pb.setCode(rs.getString(1));
				pb.setName(rs.getString(2));
				pb.setPrice(rs.getFloat(3));
				pb.setQty(rs.getInt(4));
				al.add(pb); //adding productBean to ArrayList
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
}
