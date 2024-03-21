package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/choice")
public class ChoiceServlet extends GenericServlet{
	public void service(ServletRequest req,ServletResponse res)throws ServletException,IOException
	{
		String s1=req.getParameter("s1");
		
		if(s1.equals("Add"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("ad");
			rd.forward(req, res);
		}
		
		else if(s1.equals("Sub"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("sb");
			rd.forward(req, res);
		}
		else if(s1.equals("Mul"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("mc");
			rd.forward(req, res);
		}
		else if(s1.equals("Div"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("dv");
			rd.forward(req, res);
		}
		else if(s1.equals("Mod"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("md");
			rd.forward(req, res);
		}
		else if(s1.equals("Greater"))
		{
			RequestDispatcher rd=req.getRequestDispatcher("gn");
			rd.forward(req, res);
		}
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("sn");
			rd.forward(req, res);
		}
	}
	

}
