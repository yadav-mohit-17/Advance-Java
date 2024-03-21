package test;
import java.util.*;
import java.sql.*;
public class DBCon11 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try(s)
		{
			try
			{
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
				Statement stm=con.createStatement();
				
				System.out.println("========Insert Operation on product52========");
				System.out.println("Enter The ProductCode:");
				String code=s.nextLine();
				System.out.println("Enter The ProductName:");
				String name=s.nextLine();
				System.out.println("Enter The ProductPrice:");
				float price=Float.parseFloat(s.nextLine());
				System.out.println("Enter The ProductQty:");
				int qty=Integer.parseInt(s.nextLine());
				System.out.println("=======Update Operation on product52=========");
				System.out.println("Enter The ProductCode:");
				String code1=s.nextLine();
				System.out.println("=======Delete Operation on product52=========");
				String code2=s.nextLine();
				
				System.out.println("================================================================================");
				System.out.println("========Insert Operation On BookDetais52========");
				System.out.println("Enter The BookCode:");
				String code3=s.nextLine();
				System.out.println("Enter The BookName:");
				String name1=s.nextLine();
				System.out.println("Enter The BookAuthor:");
				String author=s.nextLine();
				System.out.println("Enter The BookPrice:");
				float price1=Float.parseFloat(s.nextLine());
				System.out.println("Enter The BookQty:");
				int qty1=Integer.parseInt(s.nextLine());
				System.out.println("=======Update Operation on BookDetails52=========");
				System.out.println("Enter The BookCode:");
				String code4=s.nextLine();
				System.out.println("=======Delete Operation On BookDetails52=========");
				System.out.println("Enter The BookCode:");
				String code5=s.nextLine();
				System.out.println("================================================================================");
				
				stm.addBatch("insert into product52 values('"+code+"','"+name+"','"+price+"','"+qty+"')");
				stm.addBatch("update product52 set name='Ram' where code='"+code1+"'");
				stm.addBatch("delete from product52 where code='"+code2+"'");
				stm.addBatch("insert into bookdetails52 values('"+code3+"','"+name1+"','"+author+"','"+price1+"','"+qty1+"')");
				stm.addBatch("update bookdetails52 set bname='C#' where bcode='"+code4+"'");
				stm.addBatch("delete from bookdetails52 where bcode='"+code5+"'");
				
				int k[]=stm.executeBatch();
				for(int i=0;i<k.length;i++)
				{
					System.out.println("Executed Successfull....");
				}
				
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}//end of try with resource

	}

}
