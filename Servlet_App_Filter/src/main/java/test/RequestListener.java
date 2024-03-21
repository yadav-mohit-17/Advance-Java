package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebListener
public class RequestListener implements ServletRequestListener,ServletRequestAttributeListener{
	public void requestInitialized(ServletRequestEvent sre)
	{
		System.out.println("Request Initialized...");
	}
	public void reqestDestroyed(ServletRequestEvent sre)
	{
		System.out.println("Request Destroyed...");
	}
	public void attributeAdded(ServletRequestAttributeEvent srae)
	{
		System.out.println("Request Added with attribute...");
	}
	public void attributeRemoved(ServletRequestAttributeEvent srae)
	{
		System.out.println("Attribute removed from request...");
	}
}
