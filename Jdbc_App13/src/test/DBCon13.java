package test;
import java.sql.*;
import java.util.*;

import javax.print.attribute.SetOfIntegerSyntax;
public class DBCon13 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try(s)
		{
			try
			{
				System.out.println("==================EmployeeDetails===================");
				System.out.println("Enter The empId:");
				String id=s.nextLine();
				System.out.println("Enter The EmpName:");
				String name=s.nextLine();
				System.out.println("Enter The Empdesg:");
				String desg=s.nextLine();
				System.out.println("Enter The EmpSal:");
				int sal = Integer.parseInt(s.nextLine());
				
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
				
				Statement stm=con.createStatement();
				
				int k=stm.executeUpdate("insert into emp52 values('"+id+"','"+name+"','"+desg+"','"+sal+"')");
				if(k>0)
				{
					System.out.println("Record Inserted Successfully....");
				}
				ResultSet rs=stm.executeQuery("select * from emp52");
				while(rs.next())
				{
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(4));
				}
				System.out.println("==============Using PreparedStatement==============");
				System.out.println("Enter The ProductID:");
				String id1=s.nextLine();
				System.out.println("Enter The ProductName:");
				String name1=s.nextLine();
				System.out.println("Enter The ProductPrice:");
				float price=Float.parseFloat(s.nextLine());
				System.out.println("Enter The ProductQTY:");
				int qty= Integer.parseInt(s.nextLine());
				
				PreparedStatement ps=con.prepareStatement("insert into product52 values(?,?,?,?)");
				PreparedStatement ps1=con.prepareStatement("select * from product52");
				
				ps.setString(1, id1);
				ps.setString(2, name1);
				ps.setFloat(3, price);
				ps.setInt(4, qty);
				
				int k1=ps.executeUpdate();
				if(k1>0)
				{
					System.out.println("Record Inserted Successfully....");
				}
				ResultSet rs1=ps1.executeQuery();
				while(rs1.next())
				{
					System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getFloat(3)+rs1.getInt(4));
				}
				
			}//end of try
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}//end of try with resource
	}

}
