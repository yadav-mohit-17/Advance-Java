package Test;
import java.sql.*;
import java.util.*;
public class DBCon8 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try(s;)
		{
			try
			{
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
				
				Statement stm=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				ResultSet rs=stm.executeQuery("select * from product52");
				
				while(true)
				{
					System.out.println("*********Choice*********");
					System.out.println("\t1.Display Normal"+"\n\t2.Display Last Row"+"\n\t3.Display First Row"+"\n\t4.Display Specified Row"+"\n\t5.Exit");
					System.out.println("Enter The Choice :");
					int choice=Integer.parseInt(s.nextLine());
					
					switch(choice)
					{
					case 1:
						while(rs.next())
						{
							System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4));
						}
						break;
					case 2:
						rs.last();
						System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4));
						break;
					case 3:
						rs.first();
						System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4));
						break;
					case 4:
						System.out.println("Enter The RowNo you want to display");
						int num=Integer.parseInt(s.nextLine());
						rs.absolute(num);
						System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getInt(3)+"\t"+rs.getInt(4));
						break;
					case 5:
						System.out.println("Exit SuccessFull....");
						System.exit(0);
						break;
						default:
							System.out.println("Invalid Choice.......");
					}
				} //end of loop
			}//end of try
			catch(Exception e)
			{
				e.printStackTrace();
			}
		} //end of try with resource
		
	}

}
