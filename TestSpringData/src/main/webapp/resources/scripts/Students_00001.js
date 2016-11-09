/**
 * Created by Arxan on 30.10.2016.
 */
function Students() {}
Students.prototype.onstartup = function () {

}

Students.prototype.delete = function (id) {
	$.ajax({
		url: "/students/deleteRow",
		data: {studentId:id},
		success: function(html){
			$("#body").html(html);
		}
	});
}

Students.prototype.add = function () {
	$.ajax({
		url: "/students/addStudent",
		data: {studentFirstname:$("#inputFirstname").val(),
				studentLastname:$("#inputLastname").val(),
				studentSex:$("#inputSex").val(),
				studentBirthDate:$("#inputBirthDate").val()},
		success: function(html){
			$("#body").html(html);
		}
	});
}

var STUDENTS = new Students();
