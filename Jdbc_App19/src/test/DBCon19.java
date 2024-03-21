package test;
import java.sql.*;
public class DBCon19 {
	public static void main(String[] args) {
		ConnectionPooling cp=new ConnectionPooling("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		cp.createConnection();
		System.out.println("========user-1=========");
		Connection cn1=cp.useConnection();
		System.out.println("Conn at user-1 :"+cn1);
		System.out.println("Size of pool :"+cp.v.size());
		try
		{
			PreparedStatement ps1=cn1.prepareStatement("Select * from product52");
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next())
			{
				System.out.println(rs1.getString(1)+"\t"+rs1.getString(2)+"\t"+rs1.getFloat(3)+"\t"+rs1.getInt(4));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("========user-2=========");
		Connection cn2=cp.useConnection();
		System.out.println("Conn at user-2 :"+cn2);
		System.out.println("Size of pool :"+cp.v.size());
		try
		{
			PreparedStatement ps2=cn2.prepareStatement("select * from emp52");
			ResultSet rs2=ps2.executeQuery();
			while(rs2.next())
			{
				System.out.println(rs2.getString(1)+"\t"+rs2.getString(2)+"\t"+rs2.getString(3)+"\t"+rs2.getInt(4));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println("=======Return Connection(User-1=======)");
		cp.returnConnection(cn1);
		System.out.println("=======Return Connection(User-2)=======");
		cp.returnConnection(cn2);
		System.out.println("Size of pool :"+cp.v.size());
		System.out.println("=======Display Connection======");
		cp.v.forEach((k)->
		{
			System.out.println(k);
		});
	}

}
