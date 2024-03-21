package test; 
import java.sql.*;
import java.util.*;
class DBCon6 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Scanner s =new Scanner(System.in);
		try(s;)
		{
			try
			{
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
				
				PreparedStatement ps1=con.prepareStatement("insert into student52 values(?,?,?,?,?,?)");
				PreparedStatement ps2=con.prepareStatement("Insert into stumarks52 values(?,?,?,?,?,?,?)");
				while(true)
				{
					
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}//end of try with resource
	}

}
