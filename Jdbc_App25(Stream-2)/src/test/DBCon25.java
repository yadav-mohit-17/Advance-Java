//retrieve image from database to folder
package test;
import java.util.*;
import java.sql.*;
import java.io.*;
public class DBCon25 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try(s;)
		{
			try
			{
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
				PreparedStatement ps=con.prepareStatement("select * from streamtab52 where id=?");
				System.out.println("Enter The Id :");
				String id=s.nextLine();
				ps.setString(1, id);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					Blob b=rs.getBlob(2);
					byte by[]=b.getBytes(1, (int)b.length());
					System.out.println("Enter fPath&fName(destination):");
					File f=new File(s.nextLine());
					FileOutputStream fos=new FileOutputStream(f);
					fos.write(by);
					System.out.println("Image retrieved Successfully....");
					fos.close();
				}
				else
				{
					System.out.println("Invalid id....");
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}//end of try with resource

	}

}
