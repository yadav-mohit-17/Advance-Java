package test;
import java.sql.*;
import java.util.*;
public class DBCon27 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try(s;)
		{
			try
			{
				Connection con =DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
				DatabaseMetaData dbmd=con.getMetaData();
				System.out.println("*******DatabaseMetaData()********");
				System.out.println("URL ="+dbmd.getURL());
				System.out.println("USerName :"+dbmd.getUserName());
				System.out.println("Driver Version :"+dbmd.getDriverVersion());
				PreparedStatement ps=con.prepareStatement("insert into product52 values(?,?,?,?)");
				ParameterMetaData pmd=ps.getParameterMetaData();
				System.out.println("Parameter count ="+pmd.getParameterCount());
				System.out.println("Enter The ProdId :");
				String id=s.nextLine();
				System.out.println("Enter The ProductName :");
				String name=s.nextLine();
				System.out.println("Enter The ProdPrice :");
				float price=Float.parseFloat(s.nextLine());
				System.out.println("Enter The ProductQty :");
				int qty =Integer.parseInt(s.nextLine());
				
				ps.setString(1, id);
				ps.setString(2, name);
				ps.setFloat(3, price);
				ps.setInt(4, qty);
				
				int k=ps.executeUpdate();
				if(k>0)
				{
					System.out.println("Record Inserted in Successfully updated on product table...");
				}
				System.out.println("*********ResultSetMetaData*********");
				PreparedStatement ps2=con.prepareStatement("select code,name,price from bookdetails");
				ResultSet rs=ps2.executeQuery();
				while(rs.next())
				{
					System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getFloat(3));
				}//end of loop
				ResultSetMetaData rsmd=rs.getMetaData();
				System.out.println("Col Count ="+rsmd.getColumnCount());
				for(int i=1;i<=rsmd.getColumnCount();i++)
				{
					System.out.println("Col-"+i+":"+rsmd.getColumnName(i)+"-"+rsmd.getColumnTypeName(i));
				}
				con.close();
			}
			catch(SQLIntegrityConstraintViolationException sicve)
			{
				System.out.println("Record already available..");
			}
			catch(NumberFormatException nfe)
			{
				System.out.println("Invalid input...");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}//end of try with resource

	}

}
