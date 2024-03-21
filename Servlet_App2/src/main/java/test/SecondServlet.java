package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/second")
public class SecondServlet implements Servlet{
	public void init(ServletConfig sc) throws ServletException
	{
		//no code
	}
	@SuppressWarnings("unused")
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String name=req.getParameter("fna");
		String EmailId=req.getParameter("emid");
		String phone=req.getParameter("phone");
		String course=req.getParameter("course");
		String Mode=req.getParameter("mot");
		pw.println("****Display from servlet****");
		pw.println("<br>FullName :"+name);
		pw.println("<br>EmailId :"+EmailId);
		pw.println("<br>Contact No :"+phone);
		pw.println("<br>Course :"+course);
		pw.println("<br>Mode Of Trainning :"+Mode);
	}
	public void destroy()
	{
		//no code
	}
	public ServletConfig getServletConfig()
	{
		return this.getServletConfig();
	}
	public String getServletInfo()
	{
		return "Second Servlet reading from HTML";
	}
}
