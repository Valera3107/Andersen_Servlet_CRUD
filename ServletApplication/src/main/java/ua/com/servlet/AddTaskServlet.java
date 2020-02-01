package ua.com.servlet;

import ua.com.model.Task;
import ua.com.service.TaskService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddTaskServlet extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {
    TaskService ts = new TaskService();

    req.setCharacterEncoding("UTF-8");

    if (requestIsValid(req)) {
      final String name = req.getParameter("name");
      final int mark = Integer.parseInt(req.getParameter("mark"));
      final String description = req.getParameter("description");
      Task task = new Task(name, description, mark);
      ts.create(task);
    }

    resp.sendRedirect(req.getContextPath() + "/");
  }

  private boolean requestIsValid(final HttpServletRequest req) {
    final String name = req.getParameter("name");
    final String description = req.getParameter("description");
    final String mark = req.getParameter("mark");

    return name != null && name.length() > 0 &&
      description != null && description.length() > 0 &&
      mark != null && mark.length() > 0 &&
      mark.matches("[+]?\\d+");
  }
}
