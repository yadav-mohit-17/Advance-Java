package test;
import java.util.*;
import java.sql.*;

public class DBCon22 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try(s;)
		{
			try
			{
				System.out.println("Enter The Customer Id :");
				String cid=s.nextLine();
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
				CallableStatement cs=con.prepareCall("{call custretrieve52(?,?,?,?,?,?,?,?,?)}");
				cs.setString(1, cid);
				cs.registerOutParameter(2, Types.VARCHAR);
				cs.registerOutParameter(3, Types.VARCHAR);
				cs.registerOutParameter(4, Types.VARCHAR);
				cs.registerOutParameter(5, Types.VARCHAR);
				cs.registerOutParameter(6, Types.VARCHAR);
				cs.registerOutParameter(7, Types.INTEGER);
				cs.registerOutParameter(8, Types.VARCHAR);
				cs.registerOutParameter(9, Types.BIGINT);
				
				cs.execute();
				System.out.println("CID :"+cid);
				System.out.println("FName :"+cs.getString(2));
				System.out.println("LName :"+cs.getString(3));
				System.out.println("HNo :"+cs.getString(4));
				System.out.println("SName :"+cs.getString(5));
				System.out.println("City :"+cs.getString(6));
				System.out.println("PinCode :"+cs.getInt(7));
				System.out.println("Mid :"+cs.getString(8));
				System.out.println("Phno :"+cs.getLong(9));
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}//end of try with resource
		

	}

}
