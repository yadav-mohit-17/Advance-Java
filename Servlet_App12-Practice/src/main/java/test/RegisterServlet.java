package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/reg")
public class RegisterServlet extends HttpServlet{
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		RegisterBean rb=new RegisterBean();
		rb.setuName(req.getParameter("uname"));
		rb.setpWord(req.getParameter("pword"));
		rb.setfName(req.getParameter("fname"));
		rb.setlName(req.getParameter("lname"));
		rb.seteId(req.getParameter("eid"));
		rb.setAddress(req.getParameter("addr"));
		rb.setPhNo(Long.parseLong(req.getParameter("phno")));
		
		int k=new RegisterDAO().register(rb);
		if(k>0)
		{
			pw.println("User Registration Successfull.....<br>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
	}
}
