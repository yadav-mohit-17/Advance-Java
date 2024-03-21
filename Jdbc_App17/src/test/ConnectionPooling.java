package test;
import java.util.*;
import java.sql.*;
public class ConnectionPooling{
	public String dburl,uName,pWord;
	public ConnectionPooling(String dburl,String uName,String pWord)
	{
		this.dburl=dburl;
		this.uName=uName;
		this.pWord=pWord;
	}
	public Vector<Connection> v=new Vector<Connection>();
	public void createConnection()
	{
		try
		{
			while(v.size()<5)
			{
				System.out.println("Pool is not full...");
				Connection con=DriverManager.getConnection(dburl,uName,pWord);
				v.add(con);
				System.out.println(con);
			}//end of loop
			if(v.size()==5)
			{
				System.out.println("Pool is Full.....");
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}//end of method
}
