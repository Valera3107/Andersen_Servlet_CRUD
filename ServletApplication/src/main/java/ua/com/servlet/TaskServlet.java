package ua.com.servlet;

import ua.com.model.Task;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TaskServlet extends HttpServlet {

  private final static String index = "/WEB-INF/view/index.jsp";

  private List<Task> tasks;

  @Override
  public void init() throws ServletException {
    Object tasks = getServletContext().getAttribute("tasks");

    if (tasks == null | !(tasks instanceof List))
      throw new IllegalStateException("Your repo does not initialize.");
    else
     this.tasks = (List<Task>) tasks;
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

    req.setAttribute("tasks", tasks);
    req.getRequestDispatcher(index).forward(req, resp);
  }
}
