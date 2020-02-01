package ua.com.servlet;

import ua.com.model.Task;
import ua.com.service.TaskService;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class ContextServlet implements ServletContextListener {

  private List<Task> tasks;

  @Override
  public void contextInitialized(ServletContextEvent servletContextEvent) {
    ServletContext sc = servletContextEvent.getServletContext();
    TaskService ts = new TaskService();
    tasks = ts.getAll();
    sc.setAttribute("tasks", tasks);
  }

  @Override
  public void contextDestroyed(ServletContextEvent servletContextEvent) {
    tasks = null;
  }
}
