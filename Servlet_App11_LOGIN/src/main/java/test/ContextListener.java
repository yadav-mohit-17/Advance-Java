package test;
import javax.servlet.*;
import javax.servlet.annotation.*;
@WebListener
public class ContextListener implements ServletContextListener,ServletContextAttributeListener{
	public void contextInitialized(ServletContextEvent sce)
	{
		System.out.println("Context Initialized...");
	}
	public void contextDestroyed(ServletContextEvent sce)
	{
		System.out.println("Context destroyed.....");
	}
	public void attributeAdded(ServletContextAttributeEvent scae)
	{
		System.out.println("Attribute added to Context....");
	}
	public void attributeRemoved(ServletContextAttributeEvent scae)
	{
		System.out.println("Attribute Removed from Context....");
	}
}
