<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: Arxan
  Date: 31.10.2016
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<script src="resources/scripts/StudentsXLection_00001.js"></script>

<table>
    <thead>
        <td></td>
        <c:forEach items="${studentsXLectionArray[0].lectionBox}" var="box">
            <td>${box.lection.topic}</td>
        </c:forEach>
    </thead>
    <tbody>
    <c:forEach items="${studentsXLectionArray}" var="item">
        <tr>
            <td>${item.student.firstname} ${item.student.lastname}</td>
            <c:forEach items="${item.lectionBox}" var="box">
                <td><input type="checkbox"
                           class="stdXlec"
                           studentId="${item.student.id}"
                           lectionId="${box.lection.id}"
                           <c:if test="${box.presence == true}">checked</c:if>
                           onchange="STUDENTXLECTION.apply(this)"> </td>
            </c:forEach>
        </tr>
    </c:forEach>
    </tbody>
</table>

