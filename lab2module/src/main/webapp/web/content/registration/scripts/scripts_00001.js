/**
 * Created by Arxan on 30.10.2016.
 */
/**
 * Created by Arxan on 30.10.2016.
 */
function Registration() {}
Registration.prototype.success = function () {
	$.ajax({
		url: "/registration/success",
		data: {email:$("#regEmail").val(),
				password:$("#regPassword").val(),
				firstname:$("#regFirstname").val(),
				lastname:$("#regLastname").val(),
				middlename:$("#regMiddlename").val()},
		success: function(html){
			console.log (html);
			if (html == "OK") {
				window.location.reload();
			}
		}
	});
}
Registration.prototype.successRedact = function () {
	$.ajax({
		url: "/registration/successRedact",
		data: {email:$("#regEmail").val(),
			firstname:$("#regFirstname").val(),
			lastname:$("#regLastname").val(),
			middlename:$("#regMiddlename").val(),
			oldEmail:$("#oldEmail").val()},
		success: function(html){
			console.log (html);
			if (html == "OK") {
				$("#body").html(html);
				window.location.reload();
			}
		}
	});
}

var REGISTRATION = new Registration();
