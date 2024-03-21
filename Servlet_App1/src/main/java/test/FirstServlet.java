package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

@WebServlet("/first")
public class FirstServlet implements Servlet {
	public void init(ServletConfig sc) throws ServletException {
		// no code
	}

	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		String name = req.getParameter("uname");
		String mailId = req.getParameter("mid");
		pw.println("******Display from Servlet******");
		pw.println("<br>UserName :" + name);
		pw.println("<br>MailID :" + mailId);
	}

	public void destroy() {
		// no code
	}

	public ServletConfig getServletConfig() {
		return this.getServletConfig(); // demo code
	}

	public String getServletInfo() {
		return "FirstServlet Reading data from html "; // demo code
	}
}
