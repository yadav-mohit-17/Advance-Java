package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/add")
public class AddEmployeeServlet extends GenericServlet{
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		EmployeeBean eb=new EmployeeBean();
		eb.setid(req.getParameter("id"));
		eb.setname(req.getParameter("name"));
		eb.setdesg(req.getParameter("desg"));
		int bsal=Integer.parseInt(req.getParameter("bsal"));
		eb.setbsal(bsal);
		float totSal=bsal+(0.93f*bsal)+(0.63f*bsal);
		eb.setotsal(totSal);
		int k=new InsertEmployeeDAO().insert(eb);
		if(k>0)
		{
			pw.println("Employee Added Successfully...<br>");
			RequestDispatcher rd=req.getRequestDispatcher("choice.html");
			rd.include(req, res);
		}
	}

}
