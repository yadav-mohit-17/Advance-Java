package test;
import java.io.*;
@SuppressWarnings("serial")
public class EmployeeBean implements Serializable{
	private String id,name,desg;
	private int bsal;
	private float totSal;
	public EmployeeBean()
	{
		
	}
	
	public String getid()
	{
		return id;
	}
	public void setid(String id)
	{
		this.id=id;
	}
	public String getname()
	{
		return name;
	}
	public void setname(String name)
	{
		this.name=name;
	}
	public String getdesg()
	{
		return desg;
	}
	public void setdesg(String desg)
	{
		this.desg=desg;
	}
	public int getbsal()
	{
		return bsal;
	}
	public void setbsal(int bsal)
	{
		this.bsal=bsal;
	}
	public float gettotsal()
	{
		return totSal;
	}
	public void setotsal(float totSal)
	{
		this.totSal=totSal;
	}
}
