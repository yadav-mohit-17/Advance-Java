package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebServlet("/third")
public class DemoServlet3 implements Servlet{
	public void init(ServletConfig sc) throws ServletException
	{
		//no code
	}
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String code=req.getParameter("pc");
		String name=req.getParameter("pn");
		String price=req.getParameter("pp");
		String Qty=req.getParameter("pq");
		
		pw.println("****Display Product Details****");
		pw.println("<br>Product Code :"+code);
		pw.println("<br>Product Name :"+name);
		pw.println("<br>Product Price :"+price);
		pw.println("<br>Product Qty :"+Qty);
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
		return "Third Servlet reading data from HTML "; //Demo code
	}
	
}
