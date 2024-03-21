package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/dis")
public class DisplayServlet extends GenericServlet{
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String uName=req.getParameter("uname");
		pw.println("Welcome :"+uName);
		
		ServletContext sct=this.getServletContext();
		pw.println("<br>ServerInfo :"+sct.getServerInfo());
		
		Enumeration<String> e=sct.getInitParameterNames();
		while(e.hasMoreElements())
		{
			String str=e.nextElement();
			pw.println("<br>"+str+":"+sct.getInitParameter(str));
		}
	}
}
