package test;
import java.sql.*;
import java.util.*;
public class DBCon10 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try(s)
		{
			try
			{
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
				
				Statement stm = con.createStatement();
				System.out.println("*******Enter BookDetails*******");
				System.out.println("Enter The BookCode:");
				String code=s.nextLine();
				System.out.println("Enter The BookName:");
				String name=s.nextLine();
				System.out.println("Enter The BookAuthor:");
				String author=s.nextLine();
				System.out.println("Enter The BookPrice:");
				float price=Float.parseFloat(s.nextLine());
				System.out.println("Enter The BookQty:");
				int qty=Integer.parseInt(s.nextLine());
				
				System.out.println("========Delete Employee========");
				System.out.println("Enter The Empid:");
				String eid=s.nextLine();
				
				stm.addBatch("insert into bookdetails values('"+code+"','"+name+"','"+author+"','"+price+"','"+qty+"')");
				
				stm.addBatch("delete from emp52 where eid ='"+eid+"'");
				
				int k[]=stm.executeBatch();
				for(int i=0;i<k.length;i++)
				{
					System.out.println("Executed Successfully....");
				}
				stm.clearBatch();
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}//end of try with resource

	}

}
