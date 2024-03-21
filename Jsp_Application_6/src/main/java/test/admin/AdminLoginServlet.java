package test.admin;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/admin")
public class AdminLoginServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
	AdminBean ab = new AdminLoginDAO().login(req);
	if(ab==null) 
	{
		req.setAttribute("msg", "invalid login process....<br>");
		req.getRequestDispatcher("adminresponse.jsp").forward(req, res);
	}
	else
 	{
		HttpSession hs = req.getSession();//Session created
		hs.setAttribute("ab", ab);
		req.getRequestDispatcher("adminlogresponse.jsp").forward(req, res);
	}
   }
}
