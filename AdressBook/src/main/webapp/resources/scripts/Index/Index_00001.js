/**
 * Created by Arxan on 30.10.2016.
 */
function Index() {}
Index.prototype.onstartup = function () {
	$.ajax({
		url: "/MainBookPage",
		data: {},
		success: function(html){
			$("#body").html(html);
		}
	});
	// $.ajax({
	// 	url: "/login",
	// 	data: {},
	// 	success: function(html){
	// 		$("#loginZone").html(html);
	// 	}
	// });
}

Index.prototype.buttonPanelClick = function (button) {
	$.ajax({
		url: button.getAttribute("url"),
		data: {},
		success: function(html){
			$("#body").html(html);
		},
		error: function(resp){
			console.log (resp)
			$("#body").html(resp.responseText);
		}
	});
}

Index.prototype.login = function () {
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

var INDEX = new Index();
