<%--
  Created by IntelliJ IDEA.
  User: Валера3107
  Date: 30.01.2020
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>ServletApp</title>
</head>
<body>

<h2>Update task:</h2>

<form method="post" action="">
  <input type="hidden" name="id" value="${requestScope.task.id}">
  <label><input type="text" name="name" value="${requestScope.task.name}"></label>Name<br>
  <label><input type="text" name="description" value="${requestScope.task.description}"></label>Description<br>
  <label><input type="text" name="mark" value="${requestScope.task.mark}"></label>Mark<br>

  <input type="submit" value="Ok"/><br>
</form>

</body>
</html>
