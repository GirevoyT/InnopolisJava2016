/**
 * Created by Arxan on 30.10.2016.
 */
function Main() {}
Main.prototype.onstartup = function () {
	$.ajax({
		url: "/index/studentTable",
		data: {},
		success: function(html){
			$("#body").html(html);
		}
	});
}
Main.prototype.delete = function (id) {
	$.ajax({
		url: "/index/deleteRow",
		data: {studentId:id},
		success: function(html){
			$("#body").html(html);
		}
	});
}
Main.prototype.add = function () {
	$.ajax({
		url: "/index/addStudent",
		data: {studentFirstname:$("#inputFirstname").val(),
				studentLastname:$("#inputLastname").val(),
				studentSex:$("#inputSex").val(),
				studentBirthDate:$("#inputBirthDate").val()},
		success: function(html){
			$("#body").html(html);
		}
	});
}

var MAIN = new Main();
