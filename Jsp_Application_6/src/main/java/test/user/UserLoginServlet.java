package test.user;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/user")
public class UserLoginServlet extends HttpServlet{
protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
{
	UserBean ub=new UserLoginDAO().login(req);
	if(ub==null)
	{
		req.setAttribute("msg", "Invalid Login Process...<br>");
		req.getRequestDispatcher("response.jsp").forward(req, res);
	}
	else
	{
		HttpSession hs=req.getSession();
		hs.setAttribute("ub", ub);
		req.getRequestDispatcher("userlogin.jsp").forward(req, res);
	}
}
}
