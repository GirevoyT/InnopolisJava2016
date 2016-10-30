<%--
  Created by IntelliJ IDEA.
  User: Arxan
  Date: 30.10.2016
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="web/content/registration/scripts/scripts_00001.js"></script>

<input id ="oldEmail" type="text" value="${email}" hidden>

Email:  <input id="regEmail" type="email" value="${email}">
Имя:  <input id="regFirstname" type="text" value="${firstname}">
Фамилия:  <input id="regLastname" type="text" value="${lastname}">
Отчество:  <input id="regMiddlename" type="text" value="${middlename}">

<button onclick="REGISTRATION.successRedact()">OK</button>