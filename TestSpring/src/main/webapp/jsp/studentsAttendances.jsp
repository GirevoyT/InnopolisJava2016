<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: Girevoy.T
  Date: 01.11.2016
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<script src="resources/scripts/Students_00001.js"></script>--%>

<table>
    <thead>
    <td>id</td>
    <td>firstname</td>
    <td>lastname</td>
    <td>sex</td>
    <td>birt date</td>
    <td>attendances</td>
    </thead>
    <tbody>
    <c:forEach items="${studentsAttendancesArray}" var="item">
        <tr>
            <td>${item.student.id}</td>
            <td>${item.student.firstname}</td>
            <td>${item.student.lastname}</td>
            <td>${item.student.sex}</td>
            <td>${item.student.birthDate}</td>
            <td>${item.lectionCount}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
