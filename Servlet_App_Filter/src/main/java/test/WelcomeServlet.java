package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/log")
public class WelcomeServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String fName = (String)req.getAttribute("fName");
		String lName = (String)req.getAttribute("lName");
		String addr = (String)req.getAttribute("addr");
		String mId = (String)req.getAttribute("mid");
		String phNo = (String)req.getAttribute("phno");
		pw.println("Welcome User : "+fName+"<br>");
		pw.println(fName+"&nbsp&nbsp&nbsp"
				+lName+"&nbsp&nbsp&nbsp"
				+addr+"&nbsp&nbsp&nbsp"
				+mId+"&nbsp&nbsp&nbsp"
				+phNo+"<br>");
		RequestDispatcher rd =req.getRequestDispatcher("login.html");
		rd.include(req, res);
	}
}