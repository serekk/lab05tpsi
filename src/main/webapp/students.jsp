<%-- 
    Document   : students
    Created on : 2020-03-18, 17:01:53
    Author     : Karol
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page session="true" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Students</title>
    </head>
    <body>
        <h3>licznik wyświetleń: ${sessionScope.counter}</h3>


        <!--tutaj wyświetlanie-->
        <table border="1">
            <tr>
                <td>name</td>
                <td>lastName</td>
                <td>email</td>
            </tr>
    <tbody>
        <c:forEach items="${sessionScope.studentList}" var="student">
            <tr>
                <td>${student.name}</td>
                <td>${student.lastName}</td>
                <td>${student.email}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>


<form action='StudentsTable' method='post'>
    Przedstaw się ładnie: <br>
    <input type='text' name='namePOST'> imie <br>
    <input type='text' name='lastNamePOST'> nazwisko <br>
    <input type='text' name='emailPOST'> email <br>
    <input type='submit'>
</form>

</body>
</html>
