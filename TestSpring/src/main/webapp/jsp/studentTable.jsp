<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: Arxan
  Date: 31.10.2016
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<table>
	<thead>
	<td>id</td>
	<td>firstname</td>
	<td>lastname</td>
	<td>sex</td>
	<td>birt date</td>
	</thead>
	<tbody>
		<c:forEach items="${studentArray}" var="item">
		<tr>
			<td>${item.id}</td>
			<td>${item.firstname}</td>
			<td>${item.lastname}</td>
			<td>${item.sex}</td>
			<td>${item.birthDate}</td>
		</tr>
		</c:forEach>
	</tbody>

</table>

