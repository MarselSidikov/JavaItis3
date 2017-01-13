<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <c:forEach items="${requestScope.users_list}" var="currentUser">
        <tr>
            <td>
                <c:out value="${currentUser.name}" />
                <c:out value="${currentUser.surname}"/>
            </td>
        </tr>
    </c:forEach>

    <form action="users" method="post">
        <input type="text" name="name">
        <input type="text" name="surname">
        <input type="submit" value="add">
    </form>
</body>
</html>
