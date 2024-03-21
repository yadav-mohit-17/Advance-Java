package test;
import java.io.*;
import java.util.*;
import javax.servlet.*;
public class DisplayFilter implements Filter{
	public FilterConfig fcf=null;
	public void init(FilterConfig fcf) throws ServletException
	{
		this.fcf=fcf;
	}
	public void doFilter(ServletRequest req,ServletResponse res,FilterChain chain) throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		String uName=req.getParameter("uname");
		pw.println("Welcome User :"+uName+"<br>");
		pw.println("FilterName :"+fcf.getFilterName()+"<br>");
		Enumeration<String> e=fcf.getInitParameterNames();
		while(e.hasMoreElements())
		{
			String el=e.nextElement();
			pw.println("Value Of "+el+" is "+fcf.getInitParameter(el)+"<br>");
		}
	}
}
