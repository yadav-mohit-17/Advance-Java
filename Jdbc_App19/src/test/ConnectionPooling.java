package test;
import java.sql.*;
import java.util.*;
public class ConnectionPooling {
	public String dbUrl,uName,pWord;
	public ConnectionPooling(String dbUrl,String uName,String pWord)
	{
		this.dbUrl=dbUrl;
		this.uName=uName;
		this.pWord=pWord;
	}
	public Vector<Connection> v=new Vector<Connection>();
	public void createConnection()
	{
		try
		{
			while(v.size()<10)
			{
				System.out.println("Pool is not full....");
				Connection con=DriverManager.getConnection(dbUrl,uName,pWord);
				v.add(con);
				System.out.println(con);
				if(v.size()==10)
				{
					System.out.println("Pool is full...");
				}
			}
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public synchronized Connection useConnection()
	{
		Connection con=v.elementAt(0);
		v.removeElementAt(0);
		return con;
	}
	public synchronized void returnConnection(Connection con)
	{
		v.addElement(con);
		System.out.println("Connection back to the pool...");
		
	}
}
