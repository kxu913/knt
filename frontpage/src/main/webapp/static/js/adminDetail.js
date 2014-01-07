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

function createTable(divName) {
	$.ajax({
				url : '/frontpage/userList',
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
						var tr = $("<tr ondblclick=\"getTDs(this)\"></tr>");
						tr.appendTo(table);
						$.each(v, function(j, val) {
							if (j === "username" || j === "password") {
								var td = $("<td>" + val
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
	var userName = tds[0].innerHTML;
	$.ajax({
		url : '/frontpage/userDetail',
		dataType : "json",
		success:function(data){
			$.each(data,function(i,v){
				alert(i+":"+v);
			});
		}
	});
}
function logoff(){
	window.location.href = "/frontpage/loginoff";
}

$(document).ready(function() {
	createTable("tableDiv");
});
