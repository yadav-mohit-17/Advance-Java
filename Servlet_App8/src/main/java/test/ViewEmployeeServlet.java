package test;
import java.util.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/View")
public class ViewEmployeeServlet extends GenericServlet{
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		ArrayList<EmployeeBean> al=new ViewEmployeeDAO().retrieve();
		if(al.size()==0)
		{
			pw.println("No Employees Available....");
			RequestDispatcher rd=req.getRequestDispatcher("choice.html");
			rd.include(req, res);
		}
		else
		{
			al.forEach((k)->{
				EmployeeBean eb=(EmployeeBean)k;
				pw.println(eb.getid()+"&nbsp&nbsp"+eb.getname()+"&nbsp&nbsp"+eb.getdesg()+"&nbsp&nbsp"+eb.getbsal()+"&nbsp&nbsp"+eb.gettotsal()+"<a href='edit'>Edit</a>&nbsp&nbsp<a href='delete'>Delete</a><br>");
			});
			pw.println("<a href='choice.html'>Back</a>");
		}//end of else
		
	}
}