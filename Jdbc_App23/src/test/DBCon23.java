package test;
import java.util.*;
import java.sql.*;
public class DBCon23{
	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		try(s;)
		{
			try
			{
				System.out.println("Enter The CustId :");
				String cid=s.nextLine();
				
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
				CallableStatement cs=con.prepareCall("{call ?:=retrievephno52(?)}");
				cs.registerOutParameter(1, Types.BIGINT);
				cs.setString(2, cid);
				cs.execute();
				System.out.println("CustId :"+cid);
				System.out.println("PhNo :"+cs.getLong(1));
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}//end of try with resource
	}
}