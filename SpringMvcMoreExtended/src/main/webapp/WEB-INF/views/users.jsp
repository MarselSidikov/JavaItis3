<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <c:forEach items="${requestScope.users}" var="currentUser">
        <tr>
            <td><c:out value="${currentUser.name}" /><td>
            <td><c:out value="${currentUser.age}" /><td>
        </tr>
    </c:forEach>

    <form:form modelAttribute="user" action="users" method="post">
        <form:input path="name" />
        <form:input path="age" />
        <input type="submit" value="Submit" />
    </form:form>

</body>
</html>
