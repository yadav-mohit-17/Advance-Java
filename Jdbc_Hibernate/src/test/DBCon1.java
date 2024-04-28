package test;
import java.sql.*;
import java.sql.DriverManager;

public class DBCon1 {
	public static void main(String[] args) {
		try
		{
			//Loading driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Creating connection
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
			
			//preparing statements
			Statement stm = con.createStatement();
			
			//Executing query
			ResultSet rs =stm.executeQuery("select * from emp");
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4)+"\t"+rs.getString(5)+"\t"+rs.getInt(6)+"\t"+rs.getInt(7)+"\t"+rs.getInt(8));
			} //end of loop
			//closing connection
			con.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception type :"+e);
		}
	}
}
