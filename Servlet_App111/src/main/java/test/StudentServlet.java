package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/login")
public class StudentServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		
		StudentBean sb=new StudentDAO().login(req);
		if(sb==null)
		{
			pw.println("Invalid Login Process...<br>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		else
		{
			ServletContext sct=this.getServletContext();
			sct.setAttribute("sb", sb);
			Cookie ck=new Cookie("name",sb.getName());
			res.addCookie(ck); //serialization Process
			pw.println("Welcome User :"+sb.getName()+"<br>");
			
			RequestDispatcher rd=req.getRequestDispatcher("link.html");
			rd.include(req, res);
		}
	}

}
