package test.user;
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@WebServlet("/view")
public class ViewProductServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		HttpSession hs=req.getSession();
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired..<br>");
			req.getRequestDispatcher("Response.jsp").forward(req, res);
		}
		else
		{
			ArrayList<ProductBean> al=new ViewProductDAO().retrieve();
			hs.setAttribute("al", al);
			req.getRequestDispatcher("ViewProducts.jsp").forward(req, res);
		}
	}
}
