package test;
import java.sql.*;
import java.util.*;
public class DBCon5 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try(s;)
		{
			try
			{
				//connection create
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
				
				//prepare statement
				PreparedStatement ps1=con.prepareStatement("insert into userreg52 values(?,?,?,?,?,?,?)");
				
				PreparedStatement ps2=con.prepareStatement("select * from emp where uname='?' and pword='?'");
				
				PreparedStatement ps3=con.prepareStatement("select * from userreg52");
				
				PreparedStatement ps4=con.prepareStatement("Update from userreg52 set addr=?,mid=?,phno=? where uname=? and pword=?" );
				
				
				while(true)
				{
					System.out.println("==========Choice==========");
					System.out.println("\t1.Register"+"\n\t2.Login"+"\n\t3.Exit");
					System.out.println("Enter The Choice:");
					int choice=Integer.parseInt(s.nextLine());
					switch(choice)
					{
					case 1:
						//taking data from user
						System.out.println("Enter The UserName :");
						String name=s.nextLine();
						System.out.println("Enter The Password :");
						String pwd=s.nextLine();
						System.out.println("Enter The FirstName :");
						String fname=s.nextLine();
						System.out.println("Enter The LastName :");
						String lname=s.nextLine();
						System.out.println("Enter The Address :");
						String addr=s.nextLine();
						System.out.println("Enter The Email :");
						String eid=s.nextLine();
						System.out.println("Enter The PhoneNo :");
						long phno=Long.parseLong(s.nextLine());
						
						//setting the data
						ps1.setString(1, name);
						ps1.setString(2, pwd);
						ps1.setString(3, fname);
						ps1.setString(4, lname);
						ps1.setString(5, addr);
						ps1.setString(6, eid);
						ps1.setLong(7, phno);
						
						//execution
						int k=ps1.executeUpdate();
						if(k>0)
						{
							System.out.println("Record Inserted Successfully...");
						}
						break;
					case 2:
						System.out.println("Enter userName:");
						String uname=s.nextLine();
						System.out.println("Enter Password :");
						String pword=s.nextLine();
						//set data to ps2 object
						ps2.setString(1, uname);
						ps2.setString(2, pword);
						
						ResultSet rs=ps2.executeQuery();
						if(rs.next())
						{
							System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getLong(7));
							System.out.println("Login Success....");
							System.out.println("****Choice****");
							System.out.println("\t1.View Profile"+"\n\t2.Edit Profile(addr,mailid,phno)"+"\n\t3.Logout");
							System.out.println("Enter The Choice:");
							int choice1=Integer.parseInt(s.nextLine());
							switch(choice1)
							{
							case 1:
								ResultSet rs2=ps3.executeQuery();
								while(rs2.next())
								{
									System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)+"\t"+rs2.getString(4)+"\t"+rs2.getString(5)+"\t"+rs2.getString(6)+"\t"+rs2.getLong(7));
								}
								break;
							case 2:
								System.out.println("Enter The Username:");
								String name1=s.nextLine();
								System.out.println("Enter The Password:");
								String pwrd1=s.nextLine();
								
								ps2.setString(1, name1);
								ps2.setString(2, pwrd1);
								ResultSet rs3=ps2.executeQuery();
								if(rs3.next())
								{
									System.out.println("Old Address :"+rs3.getString(5));
									System.out.println("Enter The New Address:");
									String naddr=s.nextLine();
									System.out.println("Old E_Id :"+rs3.getString(6));
									System.out.println("Enter The New Email_Id :");
									String nmid=s.nextLine();
									System.out.println("Old Phone :"+rs3.getLong(7));
									System.out.println("Enter The New Phone Number :");
									long nphno=Long.parseLong(s.nextLine());
									
									ps4.setString(5, naddr);
									ps4.setString(6, nmid);
									ps4.setLong(7, nphno);
									
									int k2=ps4.executeUpdate();
									if(k2>0)
									{
										System.out.println("Address,Email_id and phoneNumber updated successfully....");
									}
								}
								else
								{
									System.out.println("Invalid UserName And Password..");
								}
								break;
							case 3:
								System.out.println("You Successfully Logged out....");
								break;
								default:
									System.out.println("Invalid Choice...");
							}
						}
						else
						{
							System.out.println("Invalid UserName & Password");
						}
						break;
					case 3:
						System.out.println("Operation on DB Stopped....");
						System.exit(0);
						default:
							System.out.println("Invalid Choice....");
						
					}
					
				}
			}//end of try
			catch(InputMismatchException ime)
			{
				System.out.println("Invalid Input....");
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}
		}//end of try with resource

	}

}
