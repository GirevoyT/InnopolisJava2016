/**
 * Created by Arxan on 30.10.2016.
 */
function Main() {}
Main.prototype.onstartup = function () {
	$.ajax({
		url: "/login",
		data: {todo:"simple"},
		success: function(html){
			$("#login").html(html);
		}
	});
}
Main.prototype.logout = function () {
	$.ajax({
		url: "/login",
		data: {todo:"logout"},
		success: function(html){
			$("#login").html(html);
		}
	});
}
Main.prototype.registration = function () {
	$.ajax({
		url: "/registration",
		data: {},
		success: function(html){
			$("#body").html(html);
		}
	});
}
Main.prototype.redact = function () {
	$.ajax({
		url: "/registration/redact",
		data: {},
		success: function(html){
			$("#body").html(html);
		}
	});
}
Main.prototype.login = function() {
	$.ajax({
		url: "/login",
		data: {todo:"login",email:$("#email").val(),password:$("#password").val()},
		success: function(html){
			$("#login").html(html);
		}
	});
}

var MAIN = new Main();
