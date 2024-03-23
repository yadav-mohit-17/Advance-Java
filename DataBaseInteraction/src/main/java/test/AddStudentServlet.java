package test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;

@SuppressWarnings("serial")
@WebServlet("/add")
public class AddStudentServlet extends GenericServlet{
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");
		
		StudentBean sb = new StudentBean();
		sb.setId(req.getParameter("id"));
		sb.setFirstName(req.getParameter("fn"));
		sb.setLastName(req.getParameter("ln"));
		sb.setFatherName(req.getParameter("fthn"));
		sb.setMotherName(req.getParameter("mthn"));
		sb.setCourse(req.getParameter("cr"));
		sb.setBloodGroup(req.getParameter("bg"));
		sb.setEmail(req.getParameter("ei"));
		sb.setMobile(req.getParameter("mb"));
		sb.setCollegeName(req.getParameter("cn"));
		sb.setUniversityName(req.getParameter("un"));
		
		int k=new InsertStudentDAO().insert(sb);
		if(k>0) {
			pw.println("Student Details Added Successfully....<br>");
			RequestDispatcher rd = req.getRequestDispatcher("StudentDetails.html");
			rd.include(req, res);
		}
		
		
		
	}

}
