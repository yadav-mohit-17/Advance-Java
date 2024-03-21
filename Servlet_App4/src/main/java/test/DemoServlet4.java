package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/four")
public class DemoServlet4 implements Servlet{
	public void init(ServletConfig sc) throws ServletException
	{
		//no code
	}
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String BookCode=req.getParameter("bc");
		String BookName=req.getParameter("bn");
		String BookAuthor=req.getParameter("ba");
		String BookPrice=req.getParameter("bp");
		String BookQty=req.getParameter("bq");
		
		pw.println("*****BookDetails*****");
		pw.println("<br>BookCode :"+BookCode);
		pw.println("<br>BookName :"+BookName);
		pw.println("<br>BookAuthor :"+BookAuthor);
		pw.println("<br>BookPrice :"+BookPrice);
		pw.println("<br>BookQty :"+BookQty);
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
		return "Fourth Servlet reading data from HTML "; //Demo code
	}
}
