package ua.com.service;

import org.hibernate.criterion.Restrictions;
import ua.com.dao.TaskDAO;
import ua.com.model.Task;
import ua.com.util.SessionConnector;

import java.util.List;

public class TaskService extends SessionConnector implements TaskDAO {
  @Override
  public void create(Task obj) {
    openTransaction();
    openSession().save(obj);
    closeTransaction();
  }

  @Override
  public List<Task> getAll() {
    openTransaction();
    List<Task> tasks = (List<Task>) openSession().createCriteria(Task.class).list();
    closeTransaction();
    return tasks;
  }

  @Override
  public Task update(Task obj) {
    openTransaction();
    openSession().update(obj);
    closeTransaction();
    return obj;
  }

  @Override
  public void delete(Task obj) {
    openTransaction();
    openSession().delete(obj);
    closeTransaction();
  }

  @Override
  public Task getById(Integer id){
    openTransaction();
    Task task = (Task) getSession().createCriteria(Task.class).add(Restrictions.eq("id", id)).uniqueResult();
    closeTransaction();
    return task;
  }
}
