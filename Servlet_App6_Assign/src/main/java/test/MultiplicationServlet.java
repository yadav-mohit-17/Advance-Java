package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/mc")
public class MultiplicationServlet extends GenericServlet{
	public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		try
		{
			int v1=Integer.parseInt(req.getParameter("v1"));
			int v2=Integer.parseInt(req.getParameter("v2"));
			int v3=v1*v2;
			pw.println("Multiply :"+v3+"<br>");
		}
		catch(NumberFormatException nfe)
		{
			pw.println("Enter Only Integer Values...");
		}
		RequestDispatcher rd=req.getRequestDispatcher("input.html");
		rd.include(req, res);
	}
}