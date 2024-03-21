package test;
import java.sql.*;
public class DBConnection {
	private static Connection con=null;
	private DBConnection()
	{
		
	}
	static
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}//end of block
	public static Connection getCon()
	{
		return con;
	}
}
