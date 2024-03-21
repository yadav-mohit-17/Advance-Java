package test;
import java.sql.*;
import java.util.*;
public class DBCon2 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try(s;)
		{
			try
			{
				System.out.println("Enter The empId:");
				String id=s.nextLine();
				System.out.println("Enter The EmpName:");
				String name=s.nextLine();
				System.out.println("Enter The Empdesg:");
				String desg=s.nextLine();
				System.out.println("Enter The EmpSal:");
				int sal = s.nextInt();
				
				//create connection
				Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
				
				//statement preparing
				Statement stm = con.createStatement();
				
				int k=stm.executeUpdate("insert into emp52 values('"+id+"','"+name+"','"+desg+"','"+sal+"')");
				if(k>0)
				{
					System.out.println("Record inserted Successfully...");
				}
			}//end of try
			catch(InputMismatchException ime)
			{
				System.out.println("Invalid input...");
			}
			catch(SQLIntegrityConstraintViolationException sicve)
			{
				System.out.println("Employee details already available...");
			}
			catch(SQLException cnfe)
			{
				cnfe.printStackTrace();
			}
		}
	}

}
