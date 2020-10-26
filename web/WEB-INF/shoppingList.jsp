<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>Hello, ${username} <a href="?action=logout">Logout</a></p>
        <h2>List</h2>
        
        <form action="ShoppingList" method="post">
            Add item: <input type="text" name="item">
            <input type="submit" name="action" value="add">
        </form>
        
        <form action="ShoppingList" method="post">
            <c:forEach var="item" items="${items}">
                <input type="radio" name="item" value="${item}">${item}<br>
            </c:forEach>
            <input type="submit" name="action" value="delete">
        </form>
    </body>
</html>