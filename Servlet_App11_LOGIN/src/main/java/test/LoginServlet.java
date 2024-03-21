package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/log")
public class LoginServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		UserBean ub=new LoginDAO().login(req);
		if(ub==null)
		{
			pw.println("Invalid Login Process...<br>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		else
		{
			ServletContext sct=this.getServletContext();
			sct.setAttribute("ub", ub);
			Cookie ck=new Cookie("fname",ub.getfName());
			res.addCookie(ck); //serialization Process
			pw.println("Welcome User :"+ub.getfName()+"<br>");
			RequestDispatcher rd=req.getRequestDispatcher("link.html");
			rd.include(req, res);
		}
	}
}
