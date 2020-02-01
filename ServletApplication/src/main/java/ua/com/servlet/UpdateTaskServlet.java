package ua.com.servlet;

import ua.com.model.Task;
import ua.com.service.TaskService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateTaskServlet extends HttpServlet {
  private final static String index = "/WEB-INF/view/update.jsp";

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setCharacterEncoding("UTF-8");
    TaskService taskService = new TaskService();
    int id = Integer.parseInt(req.getParameter("id"));
    Task taskById = taskService.getById(id);
    String name = req.getParameter("name");
    String description = req.getParameter("description");
    int mark = Integer.parseInt(req.getParameter("mark"));
    taskById.setName(name);
    taskById.setDescription(description);
    taskById.setMark(mark);
    taskService.update(taskById);

    resp.sendRedirect(req.getContextPath() + "/");
  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String id = req.getParameter("id");
    TaskService ts = new TaskService();
    Task task = ts.getById(Integer.parseInt(id));
    req.setAttribute("task", task);
    req.getRequestDispatcher(index).forward(req, resp);
  }
}
