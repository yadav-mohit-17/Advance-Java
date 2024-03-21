package test;
import java.util.*;
import java.sql.*;

public class ConnectionPooling {
	public String dbUrl,uName,pWord; //instance variables
	
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
			while(v.size()<5)
			{
				System.out.println("pool is not full....");
				Connection con=DriverManager.getConnection(dbUrl,uName,pWord);
				v.add(con);
				System.out.println(con);
			}
			if(v.size()==5)
			{
				System.out.println("Pool is full.....");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
		public synchronized Connection useConnection()
		{
			//Taking the element from index 0
			Connection con=v.elementAt(0);
			 //Element deleted from vector
			v.removeElementAt(0);
			return con;
		}//end of method
		public synchronized void returnConnection(Connection con)
		{
			v.addElement(con);
			System.out.println("Connection added back to pool...");
		}
	}

