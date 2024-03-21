package test;
import java.util.*;
import javax.sql.rowset.*;
public class DBCon26 {
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		try(s;)
		{
			try
			{
				RowSetFactory rsf=RowSetProvider.newFactory();
				System.out.println("******Choice*******");
				System.out.println("\t1.JdbcRowSet"+"\n\t2.CachedRowSet");
				System.out.println("Enter The Choice:");
				switch(Integer.parseInt(s.nextLine()))
				{
				case 1:
					JdbcRowSet jrs=rsf.createJdbcRowSet();
					jrs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
					jrs.setUsername("system");
					jrs.setPassword("tiger");
					jrs.setCommand("select * from BookDetails");
					jrs.execute();
					while(jrs.next())
					{
						System.out.println(jrs.getString(1)+"\t"+jrs.getString(2)+"\t"+jrs.getString(3)+"\t"+jrs.getFloat(4)+"\t"+jrs.getInt(5));
					}
					break;
				case 2:
					CachedRowSet crs=rsf.createCachedRowSet();
					crs.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
					crs.setUsername("system");
					crs.setPassword("tiger");
					crs.setCommand("select * from BookDetails");
					crs.execute();
					System.out.println("========Display In Reverse========");
					crs.afterLast();
					while(crs.previous())
					{
						System.out.println(crs.getString(1)+"\t"+crs.getString(2)+"\t"+crs.getString(3)+"\t"+crs.getFloat(4)+"\t"+crs.getInt(5));
					}
					break;
					default:
						System.out.println("Invalid Choice...");
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}//end of try with resource

	}

}
