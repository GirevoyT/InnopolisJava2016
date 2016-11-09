function LoginZone() {}
LoginZone.prototype.onstartup = function () {}

LoginZone.prototype.login = function () {
	var arr = {};
	arr["j_username"] = $("#login").val();
	arr["j_password"] = $("#password").val();
	arr[$("#token").attr("name")] = $("#token").val();

	$.ajax({
		type: "POST",
		url: "/j_spring_security_check",
		data: arr,
		success: function(html){
			$("#loginZone").html(html);
		}
	});
}
LoginZone.prototype.logout = function () {
	var arr = {};
	arr["j_username"] = $("#login").val();
	arr["j_password"] = $("#password").val();
	arr[$("#token").attr("name")] = $("#token").val();

	$.ajax({
		type: "POST",
		url: "/j_spring_security_check",
		data: arr,
		success: function(html){
			$("#loginZone").html(html);
		}
	});
}

var LOGINZONE = new LoginZone();
