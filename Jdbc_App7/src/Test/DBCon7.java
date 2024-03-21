package Test;
import java.sql.*;
public class DBCon7 {
	public static void main(String[] args) {
		try
		{
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			
			Statement stm = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			ResultSet rs=stm.executeQuery("select * from BookDetails52");
			System.out.println("*******Table Data In Reverse*********");
			rs.afterLast(); //cursor pointing after last row
			while(rs.previous())
			{
				System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getFloat(4)+"\t"+rs.getInt(5));
			}
			PreparedStatement ps = con.prepareStatement("select * from BookDetails52",ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs2=ps.executeQuery();
			System.out.println("*******Row-3*******");
			rs2.absolute(3);
			System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)+"\t"+rs2.getFloat(4)+"\t"+rs2.getInt(5));
			
			System.out.println("**********Relative(-2)***********");
			rs2.relative(-2);
			System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)+"\t"+rs2.getFloat(4)+"\t"+rs2.getInt(5));
			
			System.out.println("*********Relative(+3)**********");
			rs2.relative(+3);
			System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)+"\t"+rs2.getFloat(4)+"\t"+rs2.getInt(5));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
