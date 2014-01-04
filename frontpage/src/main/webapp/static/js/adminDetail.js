function adminManage() {
	$(".active").removeClass("active");
	$("#admin").addClass("active");
	createTable("tableDiv", 5, 6);

}

function userManage() {
	// removeClass("active");
	$(".active").removeClass("active");
	$("#user").addClass("active");
	$("#tableDiv").empty();
}

function orderList() {
	$(".active").removeClass("active");
	$("#order").addClass("active");
	$("#tableDiv").empty();
}

function createTable(divName, rowCount, cellCount) {
	$("#" + divName).empty();
	var table = $("<table class=\"table table-striped table-bordered table-hover\">");
	table.appendTo($("#" + divName));
	var tr = $("<tr></tr>");
	tr.appendTo(table);
	for (var i = 0; i < cellCount; i++) {
		var th = $("<th> th " + i + "</th>");
		th.appendTo(tr);
	}

	for (var i = 0; i < rowCount; i++) {
		var tr = $("<tr onclick=\"getTDs(this)\"></tr>");
		tr.appendTo(table);
		for (var j = 0; j < cellCount; j++) {
			var td = $("<td id=\"id" + j + "\">" + i * j + "</td>");
			td.appendTo(tr);
		}
	}
	$("#" + divName).append("</table>");
}

function createTableUnsync(divName) {
	$
			.ajax({
				url : '/frontpage/getUserList',
				dataType : "json",
				success : function(data) {
					$("#" + divName).empty();
					var table = $("<table class=\"table table-striped table-bordered table-hover\">");
					table.appendTo($("#" + divName));
					var tr = $("<tr></tr>");
					tr.appendTo(table);
					var th = $("<th>用户名</th>");
					th.appendTo(tr);
					var th = $("<th>密码 </th>");
					th.appendTo(tr);
					$.each(data, function(i, v) {
						var tr = $("<tr onclick=\"getTDs(this)\"></tr>");
						tr.appendTo(table);
						$.each(v, function(j, val) {
							if (j === "username" || j === "password") {
								var td = $("<td id=\"id" + val + "\">" + val
										+ "</td>");
								td.appendTo(tr);
							}
						});
					});
					$("#" + divName).append("</table>");
				}
			});

}

function getTDs(tr) {
	var tds = tr.children;
	for (i = 0; i < tds.length; i++) {
		alert(tds[0].getValue());
	}
}
function logoff(){
	window.location.href = "/frontpage/loginoff";
}

$(document).ready(function() {
	createTableUnsync("tableDiv");
});
