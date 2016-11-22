<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <script src="resources/scripts/Index/Index_00001.js"></script>
    <script src="resources/scripts/Lib/jquery-3.1.1.min.js"></script>
    <%--<script src="resources/scripts/tablesorter/jquery.tablesorter.min.js"></script>--%>
    <title>Adress Book</title>
</head>
<body>
<div id="head">
    <div id="buttonPanel">
        <button url="/MainBookPage" onclick="INDEX.buttonPanelClick(this)">AdressBook</button>

        <div id="loginZone">
        </div>
    </div>
</div>
<div id="body"></div>
<div id="foot">FOOTER</div>
<img src="/resources/IMG/loader.jpg" onload="INDEX.onstartup()" hidden>
</body>
</html>
