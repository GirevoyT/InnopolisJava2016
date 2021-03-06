<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page session="true"%>

<script src="resources/scripts/LoginZone_00001.js"></script>

<c:if test="${not empty error}">
	<div class="error">${error}</div>
</c:if>
<c:if test="${not empty msg}">
	<div class="msg">${msg}</div>
</c:if>

<input id="token" type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
<sec:authorize access="hasAnyRole('ROLE_USER', 'ROLE_ADMIN')">
	Добро пожаловать ${username}!
	<button onclick="LOGINZONE.logout()">Logout</button>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_ANONYMOUS')">
	<input id="login" type="email">
	<input id="password" type="password">
