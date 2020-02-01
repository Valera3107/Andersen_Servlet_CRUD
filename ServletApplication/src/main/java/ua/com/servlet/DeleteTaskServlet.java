package ua.com.servlet;

import ua.com.model.Task;
import ua.com.service.TaskService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class DeleteTaskServlet extends HttpServlet {

  private List<Task> tasks;

  @Override
  public void init() throws ServletException {
    Object tasks = getServletContext().getAttribute("tasks");

    if (tasks == null | !(tasks instanceof ConcurrentHashMap))
      throw new IllegalStateException("Your repo does not initialize.");
    else
      this.tasks = (List<Task>) tasks;
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    TaskService ts = new TaskService();

    if (!isNumber(req)) {
      resp.sendRedirect(req.getContextPath() + "/");
    } else {
      Task task = ts.getById(Integer.parseInt(req.getParameter("id")));
      ts.delete(task);
      resp.sendRedirect(req.getContextPath() + "/");
    }
  }

  private boolean isNumber(HttpServletRequest req) {
    try {
      Integer integer = Integer.parseInt(req.getParameter("id"));
      return true;
    } catch (Exception ex) {
      System.out.println("Invalid input!");
    }
    return false;
  }
}
