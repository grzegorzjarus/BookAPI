<%--
  Created by IntelliJ IDEA.
  User: grzesiek
  Date: 11.08.2022
  Time: 23:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/books/addBook" method="POST">
<%--    id:--%>
<%--    <input type="text" name="id"/>--%>
    isbn:
    <input type="text" name="isbn"/>
    title:
    <input type="text" name="title"/>
    author:
    <input type="text" name="author"/>
    publisher:
    <input type="text" name="publisher"/>
    type:
    <input type="text" name="type"/>


    <input type="submit" value="Wyślij"/>
    </select>
</form>
</body>
</html>