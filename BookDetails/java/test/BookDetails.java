package test;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

@WebServlet("/add")
public class BookDetails implements Servlet{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return "Successfully..";
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
			PrintWriter pw=res.getWriter();
			res.setContentType("text/html");
			String bCode=req.getParameter("bCode");
			String bName=req.getParameter("bName");
			String bPrice=req.getParameter("bPrice");
			String bQty=req.getParameter("bQty");
			
			pw.println("*******Dispaly*******<br>");
			pw.println("<br>bCode :"+bCode);
			pw.println("<br>bName :"+bName);
			pw.println("<br>bPrice :"+bPrice);
			pw.println("<br>bQty :"+bQty);
			
	}

}
