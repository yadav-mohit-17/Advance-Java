package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/dis")
public class ServletDisplay extends HttpServlet{
	public int x;
	public int y;
	public ServletDisplay()
	{
		x++;
		y++;
	}
	public void init()throws ServletException
	{
		x++;
		y++;
	}
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String uName=req.getParameter("uname");
		pw.println("Welcome User :"+uName+"<br>");
		pw.println("The Value of x :"+x+"<br>");
		pw.println("The Value of y :"+y+"<br>");
	}
	public void destroy()
	{
		x=100;
		y=200;
	}
}
