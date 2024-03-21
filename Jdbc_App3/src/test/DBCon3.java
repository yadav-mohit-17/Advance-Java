package test;
import java.sql.*;
import java.util.*;
public class DBCon3 {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try(s;)
		{
			try
			{
			// creating connection
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
				
			//compilation
				PreparedStatement ps1 = con.prepareStatement("insert into BookDetails52 values(?,?,?,?,?)");
				
				//compilation
				PreparedStatement ps2 = con.prepareStatement("Select * from BookDetails52");
				
				while(true)
				{
					System.out.println("*********Choice*********");
					System.out.println("\t1.AddBookDetails"+"\n\t2.ViewBookDetails"+"\n\t3.Exit");
					System.out.println("Enter The Choice:");
					int choice = Integer.parseInt(s.nextLine());
					switch(choice)
					{
					case 1:
						System.out.println("Enter The BookCode:");
						String bcode=s.nextLine();
						System.out.println("Enter The BookName:");
						String bname=s.nextLine();
						System.out.println("Enter The BookAuthor:");
						String bauthor=s.nextLine();
						System.out.println("Enter The BookPrice:");
						float bprice=Float.parseFloat(s.nextLine());
						System.out.println("Enter The BookQuantity:");
						int bqty=Integer.parseInt(s.nextLine());
						
					//setting data to ps1-object
						ps1.setString(1, bcode);
						ps1.setString(2, bname);
						ps1.setString(3, bauthor);
						ps1.setFloat(4, bprice);
						ps1.setInt(5, bqty);
						
					//Execution
						int k=ps1.executeUpdate();
						if(k>0)
						{
							System.out.println("Record Inserted Successfully...");
						}
						break;
					case 2:
						ResultSet rs=ps2.executeQuery();
						System.out.println("*******BookDetails********");
						while(rs.next())
						{
							System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getFloat(4)+"\t"+rs.getInt(5));
						} //end of loop
						break;
					case 3:
						System.out.println("Operation on DataBase Stopped...");
						System.exit(0);
						default:
							System.out.println("Invalid Choice....");
					}
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}//end of try with resource

	}

}
