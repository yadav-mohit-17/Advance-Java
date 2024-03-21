package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebFilter("/log")
public class LoginFilter implements Filter{
	@Override
	public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain)throws ServletException,IOException
	{
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		UserBean ub = new LoginDAO().login(req);
		if(ub==null) 
		{
			pw.println("Invalid Login Process...<br>");
			RequestDispatcher rd =req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		else 
		{
			req.setAttribute("fName", ub.getfName());
			req.setAttribute("lName", ub.getlName());
			req.setAttribute("addr", ub.getAddr());
			req.setAttribute("mid", ub.getmId());
			req.setAttribute("phno",String.valueOf(ub.getPhNo()));
			chain.doFilter(req, res);//Linking Servlet
		}
	}
}