//insert image to database

package test;
import java.sql.*;
import java.util.*;
import java.io.*;
public class DBCon24 {
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try(s)
		{
			try
			{
				Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
				PreparedStatement ps=con.prepareStatement("insert into streamtab52 values(?,?)");
				System.out.println("Enter The id :");
				String id=s.nextLine();
				ps.setString(1, id);
				System.out.println("Enter fPath&fName(Source):");
				File f=new File(s.nextLine());
				FileInputStream fis=new FileInputStream(f);
				ps.setBinaryStream(2, fis,f.length());
				
				int k=ps.executeUpdate();
				if(k>0)
				{
					System.out.println("Image Inserted to database Successfully....");
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}//end of try with resource 

	}

}
