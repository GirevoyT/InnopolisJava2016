/**
 * Created by Arxan on 30.10.2016.
 */
function StudentsXLection() {}
StudentsXLection.prototype.onstartup = function () {

}

StudentsXLection.prototype.apply = function (element) {
	console.log ();

	$.ajax({
		url: "/studentsXLection/applyChanges",
		data: {studentId:$(element).attr("studentId"),
				lectionId:$(element).attr("lectionId"),
				state:$(element).prop("checked")},
		success: function(){
		}
	});
}

var STUDENTXLECTION = new StudentsXLection();
