package test;
import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/delete")
public class DeleteProductServlet extends HttpServlet{
	@SuppressWarnings({ "unchecked", "unused" })
	protected void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		HttpSession hs=req.getSession(false);
		if(hs==null)
		{
			pw.println("Session Expired....");
			RequestDispatcher rd=req.getRequestDispatcher("home.html");
			rd.include(req, res);
		}
		else
		{
			AdminBean ab=(AdminBean)hs.getAttribute("ab");
			pw.println("Page Belongs To :"+ab.getfName()+"<br>");
			ArrayList<ProductBean> al =(ArrayList<ProductBean>)hs.getAttribute("al");
			ProductBean pb=new ProductBean();
			String code = req.getParameter("pcode");
			int k=new DeleteProductDAO().delete(pb);
			if(k>0)
			{
				pw.println("Product Deleted Successfully....<br>");
			}
			RequestDispatcher rd =req.getRequestDispatcher("link1.html");
			rd.include(req, res);
		}
	}
}
