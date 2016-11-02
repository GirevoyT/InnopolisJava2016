/**
 * Created by Arxan on 30.10.2016.
 */
function Login() {}
Login.prototype.login = function () {
	$.ajax({
		type: "POST",
		url: "/j_spring_security_check",
		data: {j_username:$("#login").val(),
				j_password:$("#password").val()},
		success: function(html){
			location.reload();
		}
	});
}

var LOGIN = new Login();
