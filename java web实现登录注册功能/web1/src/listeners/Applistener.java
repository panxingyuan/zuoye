package listeners;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import src.util.JDBCUtils;

@WebListener
public class Applistener implements ServletContextListener {
 @Override
 public void contextDestroyed(ServletContextEvent e) {
 }
 @Override
 public void contextInitialized(ServletContextEvent e) {
  //e.getServletContext().setAttribute("onLineCount", 0);
 // e.getServletContext().setAttribute("maxOnLineCount", 0);
	 String path = e.getServletContext().getRealPath("/");
	 
JDBCUtils.load();
 }

}