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

var MAIN = new Main();
