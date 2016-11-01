<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: Girevoy.T
  Date: 01.11.2016
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table>
    <thead>
    <td>id</td>
    <td>topic</td>
    <td>description</td>
    <td>duration</td>
    <td>date</td>
    </thead>
    <tbody>
    <c:forEach items="${lectionArray}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.topic}</td>
            <td>${item.description}</td>
            <td>${item.duration}</td>
            <td>${item.date}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>