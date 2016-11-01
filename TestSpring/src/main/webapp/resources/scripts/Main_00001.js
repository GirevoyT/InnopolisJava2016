/**
 * Created by Arxan on 30.10.2016.
 */
function Main() {}
Main.prototype.onstartup = function () {
	$.ajax({
		url: "/students/studentTable",
		data: {},
		success: function(html){
			$("#body").html(html);
		}
	});
}

Main.prototype.buttonPanelClick = function (button) {
	$.ajax({
		url: button.getAttribute("url"),
		data: {},
		success: function(html){
			$("#body").html(html);
		}
	});
}

var MAIN = new Main();
