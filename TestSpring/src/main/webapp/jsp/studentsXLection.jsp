<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: Arxan
  Date: 31.10.2016
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<script src="resources/scripts/Students_00001.js"></script>

<table>
    <tbody>
    <c:forEach items="${studentsXLectionArray}" var="item">
        <tr>
            <td>${item.student.firstaname} ${item.student.lastname}</td>
            <c:forEach items="${item.lectionBox}" var="box">
                <td>123</td>
            </c:forEach>
        </tr>
    </c:forEach>
    </tbody>
</table>

