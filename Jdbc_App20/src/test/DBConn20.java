package test;
import java.util.*;
import java.sql.*;

public class DBConn20 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try(s)
		{
			try
			{
					System.out.println("Enter the CustId :");
					String cid=s.nextLine();
					System.out.println("Enter the firstName :");
					String fn=s.nextLine();
					System.out.println("Enter the lastName :");
					String ln=s.nextLine();
					System.out.println("Enter the hNo :");
					String hno=s.nextLine();
					System.out.println("Enter the StreetName :");
					String sn=s.nextLine();
					System.out.println("Enter the CityName :");
					String cty=s.nextLine();
					System.out.println("Enter the PinCode :");
					int pin=Integer.parseInt(s.nextLine());
					System.out.println("Enter the MailId :");
					String mid=s.nextLine();
					System.out.println("Enter the PhoneNumber :");
					long pno=Long.parseLong(s.nextLine());
				
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
					CallableStatement cs=con.prepareCall("{call custinsert52(?,?,?,?,?,?,?,?,?)}");
					cs.setString(1, cid);
					cs.setString(2, fn);
					cs.setString(3, ln);
					cs.setString(4, hno);
					cs.setString(5, sn);
					cs.setString(6, cty);
					cs.setInt(7, pin);
					cs.setString(8, mid);
					cs.setLong(9, pno);
					
					cs.execute();
					System.out.println("Procedure executed Successfuly...");
					System.out.println("CustmerData updated......");
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
