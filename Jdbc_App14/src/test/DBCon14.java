package test;
import java.sql.*;
import java.util.*;
public class DBCon14 {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try(s)
		{
			try
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
				System.out.println("Status of AutoCommit :"+con.getAutoCommit());
				con.setAutoCommit(false);
				System.out.println("Status of AutoCommit :"+con.getAutoCommit());
				
				PreparedStatement ps1=con.prepareStatement("select * from Bank52 where accno=?");
				PreparedStatement ps2=con.prepareStatement("update Bank52 set bal=bal+? where accNo=?");
				
				Savepoint sp=con.setSavepoint();
				System.out.println("Enter The Home AccNo :");
				long hAccNo=Long.parseLong(s.nextLine());
				ps1.setLong(1, hAccNo);
				ResultSet rs1=ps1.executeQuery();
				if(rs1.next())
				{
					float bl=rs1.getFloat(3);
					System.out.println("Enter The Beneficiery AccNo:");
					long bAccNo=Long.parseLong(s.nextLine());
					ps2.setLong(1, bAccNo);
					ResultSet rs2=ps1.executeQuery();
					if(rs2.next())
					{
						System.out.println("Enter the amt to be Transferred:");
						float amt=Integer.parseInt(s.nextLine());
						if(amt<=bl)
						{
							ps2.setFloat(1, -amt);
							ps2.setFloat(2, hAccNo);
							int i=ps2.executeUpdate();//update in buffer
							ps2.setFloat(1, amt);
							ps2.setFloat(2, bAccNo);
							int j=ps2.executeUpdate();//update in buffer
							if(i==1 && j==1)
							{
								System.out.println("Transaction Successfull...");
								con.commit();
							}
							else
							{
								System.out.println("Transaction failed...");
							}
						}
						else
						{
							System.out.println("Insufficient balance....");
						}
					}
					else
					{
						System.out.println("Invalid bAccNo...");
					}
					
				}
				else
				{
					System.out.println("Invalid homeAccNo...");
				}
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}//end of try with resource

	}

}
