package test;
import java.sql.*;
import java.util.*;
public class DBCon4 {

	public static void main(String[] args) {
	
		Scanner s = new Scanner(System.in);
		try(s;)
		{
			try
			{
				//create connection
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
				
				//Compilation
				PreparedStatement ps1=con.prepareStatement("insert into BookDetails52 values(?,?,?,?,?)");
				
				//Compilation
				PreparedStatement ps2=con.prepareStatement("select * from BookDetails52");
				
				PreparedStatement ps3=con.prepareStatement("select * from BookDetails52 where bcode=?");
				
				PreparedStatement ps4=con.prepareStatement("update BookDetails52 set bprice=?,bqty=bqty+? where bcode=?");
				
				PreparedStatement ps5=con.prepareStatement("delete from BookDetails52 where bcode=?");
				
				while(true)
				{
					System.out.println("********Choice*********");
					System.out.println("\t1.AddBookDetails"+"\n\t2.ViewBookDetails"+"\n\t3.ViewBookByCode"+"\n\t4.UpdateBookByBookCode(price/qty)"+"\n\t5.DeleteBookByBookCode"+"\n\t6.Exit");
					System.out.println("Enter The Choice :");
					int choice = Integer.parseInt(s.nextLine());
					switch(choice)
					{
					case 1:
						//taking data from user
							System.out.println("Enter The BookCode:");
							String bcode=s.nextLine();
							System.out.println("Enter The BookName:");
							String bname=s.nextLine();
							System.out.println("Enter The BookAuthor:");
							String bauthor=s.nextLine();
							System.out.println("Enter The BookPrice:");
							float bprice = Float.parseFloat(s.nextLine());
							System.out.println("Enter The BQty:");
							int bqty=Integer.parseInt(s.nextLine());
							
						//setting data to preparedStatement's bject 'ps1'
							ps1.setString(1,bcode);
							ps1.setString(2,bname);
							ps1.setString(3,bauthor);
							ps1.setFloat(4,bprice);
							ps1.setInt(5,bqty);
						
							//Execution
							int k=ps1.executeUpdate();
							if(k>0)
							{
								System.out.println("Record inserted Successfully...");
							}
							break;
						case 2:
							ResultSet rs=ps2.executeQuery();
							System.out.println("******BookDetails*******");
							while(rs.next())
							{
								System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getFloat(4)+"\t"+rs.getInt(5));
							}//end of loop
							break;
						case 3:
							System.out.println("Enter The BookCode:");
							String code=s.nextLine();
							
						// Setting data to ps3-object
							ps3.setString(1,code);
							ResultSet rs2 =ps3.executeQuery();
							if(rs2.next())
							{
								System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)+"\t"+rs2.getFloat(4)+"\t"+rs2.getInt(5));
							}
							else
							{
								System.out.println("Invalid BookCode....");
							}
							break;
						case 4:
							System.out.println("Enter the BookCode:");
							String code2=s.nextLine();
							
							ps3.setString(1,code2);
							ResultSet rs3=ps3.executeQuery();
							if(rs3.next())
							{
								System.out.println("Old Book Price:"+rs3.getFloat(4));
								System.out.println("Enter The New Book Price:");
								float nprice=Float.parseFloat(s.nextLine());
								System.out.println("Old Book Qty:"+rs3.getInt(5));
								System.out.println("Enter The New Book Qty:");
								int nqty=Integer.parseInt(s.nextLine());
								ps4.setFloat(4, nprice);
								ps4.setInt(5, nqty);
								ps4.setString(3, code2);
								int k2=ps4.executeUpdate();
								if(k2>0)
								{
									System.out.println("Book Price And Qty Updated...");
								}
								else
								{
									System.out.println("Invalid BookCode...");
								}
							}
								break;
						case 5:
							System.out.println("Enter The BookCode");
							String code3 = s.nextLine();
							ps3.setString(1, code3);
							ResultSet rs4=ps3.executeQuery();
							if(rs4.next())
							{
								ps5.setString(1, code3);
								int k3=ps5.executeUpdate();
								if(k3>0)
								{
									System.out.println("BookDetails Deleted Successfully..");
								}
								else
								{
									System.out.println("Invalid BookCode..");
								}
							}
						case 6:
							System.out.println("Operation on DB Stopped...");
							System.exit(0);
							
							default:
								System.out.println("Invalid Choice....");	
					}
					
				}//end of loop
			}//end of try
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}//end of try with resource
	}

}
