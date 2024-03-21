package test;
import java.util.*;
import java.sql.*;
public class DBCon12 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try(s)
		{
			try
			{
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
				
				PreparedStatement ps=con.prepareStatement("insert into product52 values(?,?,?,?)");
				System.out.println("Enter The Number Of product:");
				int n=Integer.parseInt(s.nextLine());
				System.out.println("Enter The "+n+" product Details...");
				for(int i=1;i<=n;i++)
				{
					System.out.println("*****Details Of Product"+i+"****");
					System.out.println("Enter The ProductCode:");
					String code=s.nextLine();
					System.out.println("Enter The Product Name:");
					String name=s.nextLine();
					System.out.println("Enter The Product Price:");
					float price=Float.parseFloat(s.nextLine());
					System.out.println("Enter The Product Qty:");
					int qty=Integer.parseInt(s.nextLine());
					
					ps.setString(1, code);
					ps.setString(2, name);
					ps.setFloat(3, price);
					ps.setInt(4, qty);
					
					ps.addBatch();//Query will values added to batch
				} // end of loop
				int k[]=ps.executeBatch();
				for(int i=0;i<k.length;i++)
				{
					System.out.println("Executed Successfully....");
				}
				ps.clearBatch();
				con.close();
			}//end of try
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}//end of try

	}

}
