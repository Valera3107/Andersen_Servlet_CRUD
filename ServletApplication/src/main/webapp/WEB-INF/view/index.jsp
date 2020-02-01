<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>TaskApp</title>

</head>
<body>

<h1>All tasks:</h1><br/>

<c:forEach var="task" items="${requestScope.tasks}">
  <ul>

    <li>Name: <c:out value="${task.name}"/></li>
    <li>Description: <c:out value="${task.description}"/></li>
    <li>Mark: <c:out value="${task.mark}"/></li>

    <form action="update" method="get">
      <input type="text" hidden name="id" value="${task.id}">
      <input type="submit" value="Update">
    </form>

    <form action="delete" method="post">
      <input type="text" hidden name="id" value="${task.id}">
      <input type="submit" value="Delete">
    </form>
  </ul>
  <hr/>

</c:forEach>

<h2>Create new task:</h2><br/>

<form method="post" action="add">

  <label><input type="text" name="name"></label>Name<br>
  <label><input type="text" name="description"></label>Description<br>
  <label><input type="text" name="mark"></label>Mark<br>

  <input type="submit" value="Ok"/><br>
</form>

</body>
</html>
