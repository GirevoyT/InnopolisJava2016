<%--
  Created by IntelliJ IDEA.
  User: Arxan
  Date: 31.10.2016
  Time: 19:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
	<script src="resources/scripts/Main_00001.js"></script>
	<script src="resources/scripts/jquery-3.1.1.min.js"></script>
	<title>Super Student Table</title>
</head>
<body>
<div id="head">
	<div id="buttonPanel">
		<button url="/admin_page" onclick="MAIN.buttonPanelClick(this)">admin_page</button>
		<button url="/user_page" onclick="MAIN.buttonPanelClick(this)">user_page</button>
		
		<div id="loginZone">

		</div>
	</div>
</div>
<div id="body"></div>
<div id="foot"></div>
<img src="AAAAAAA.jpg" onerror="MAIN.onstartup()" hidden>
</body>
</html>
