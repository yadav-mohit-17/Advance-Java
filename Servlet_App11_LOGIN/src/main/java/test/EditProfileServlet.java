package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditProfileServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		Cookie c[]=req.getCookies();
		if(c==null)
		{
			pw.println("Session Expired....<br>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		else
		{
			ServletContext sct=this.getServletContext();
			UserBean ub=(UserBean) sct.getAttribute("ub");
			pw.println("<form action='update' method='post'>");
			pw.println("Address :<input type='text'name='addr'value='"+ub.getAddr()+"'><br>");
			pw.println("MailId :<input type='text'name='mid'value='"+ub.getmId()+"'><br>");
			pw.println("PhoneNo :<input type='text'name='phno'value='"+ub.getPhNo()+"'><br>");
			pw.println("<input type='submit'value='Update'>");
			pw.println("</form>");
		}
	}
}
