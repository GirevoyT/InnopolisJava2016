<%--
  Created by IntelliJ IDEA.
  User: Arxan
  Date: 30.10.2016
  Time: 21:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% if (new Boolean("false").equals(request.getAttribute("isCorrectLogin"))) {%>
Некоректный логин или пароль
<%}%>

<% if (request.getAttribute("userName") != null) { %>
Добро пожаловать ${userName}
<button onclick="MAIN.redact()">Редактировать профиль</button>
<button onclick="MAIN.logout()">Выйти</button>
<%} else {%>
<button onclick="MAIN.registration()">Регистрация</button>
Email:  <input id="email" type="email">
Пароль: <input id="password" type="password" >
<button onclick="MAIN.login()">Войти</button>
<%}%>
