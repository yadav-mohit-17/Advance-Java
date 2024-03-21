package test;
import java.sql.*;
import java.util.*;
public class DBCon21 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		try(s;)
		{
			try
			{
				System.out.println("Enter The EmpId :");
				String eid=s.nextLine();
				System.out.println("Enter The EmpName :");
				String en=s.nextLine();
				System.out.println("Enter The EmpDesg :");
				String ed=s.nextLine();
				System.out.println("Enter The H.No :");
				String hn=s.nextLine();
				System.out.println("Enter The SName :");
				String sn=s.nextLine();
				System.out.println("Enter The City :");
				String cty=s.nextLine();
				System.out.println("Enter The PinCode :");
				int pin=Integer.parseInt(s.nextLine());
				System.out.println("Enter The EmailId :");
				String mid=s.nextLine();
				System.out.println("Enter The PhoneNo. :");
				long pno=Long.parseLong(s.nextLine());
				System.out.println("Enter The Basic Salary :");
				float bsal=Float.parseFloat(s.nextLine());
				
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
				CallableStatement cs =con.prepareCall("{call InsertEmployeeDetails52(?,?,?,?,?,?,?,?,?)}");
				cs.setString(1, eid);
				cs.setString(2, en);
				cs.setString(3, ed);
				cs.setString(4, hn);
				cs.setString(5, sn);
				cs.setString(6, cty);
				cs.setInt(7, pin);
				cs.setString(8, mid);
				cs.setInt(9, pin);
			
				
				
				
				cs.execute();
				System.out.println("Procedure Executed Successfully....");
				System.out.println("Employee Data Updated....");
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}//end of try with resource
	}

}
