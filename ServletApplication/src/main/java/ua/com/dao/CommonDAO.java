package ua.com.dao;

import java.util.List;

public interface CommonDAO<T> {
  void create(T obj);
  List<T> getAll();
  T update(T obj);
  void delete(T obj);
  T getById(Integer id);
}
