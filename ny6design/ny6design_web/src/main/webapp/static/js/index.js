function loadMessages() {
	$.ajax({
		url : '/ny6design_web/latestMessage',
		dataType : "json",
		success : function(data, status) {
			var appendDiv = $("#msg");
			$.each(data, function(i, v) {
				var _lable = $("<label>" + v.fdescription + "</label>");
				if (i % 2 === 0) {
					_lable.css("color", "white");
				} else {
					_lable.css("color", "orange");
				}
				_lable.appendTo(appendDiv);
			});
		}
	});
}

function loadToolBar() {
	$.ajax({
		url : '/ny6design_web/getToolBar',
		success : function(data, status) {
			$("#toolbar").html(data);
		}
	});
}

function loadCategories() {
	$.ajax({
		url : '/ny6design_web/getAllCategoryList',
		dataType : "json",
		success : function(data, status) {
			var appendDiv = "#mnCategory";
			$.each(data, function(key, val) {
				id = val["categoryId"];
				order = val["order"];
				pid = val["parentId"];
				name = val["name"];
				if (-1 == pid) {
					newItem = $(appendDiv).append(
							'<div><h3><a/></h3><div><ul></ul></div></div>');
					$(newItem).find('>div:last').attr('id', 'category' + id)
							.find("h3 a").text(name);

				} else {
					pNode = '#category' + pid;
					newItem = $(pNode).find('ul').append("<li><a/></li>");
					$(newItem).find('>li:last').attr('id', 'category' + id)
							.find("a").text(name);
				}
			});
			$(appendDiv).accordion({
				collapsible : true,
				navigation : true,
				clearStyle : true,
				heightStyle : "content",
				"icons" : null,
				header : "> div > h3"
			});
		}
	});
}

function loadProducts() {
	$.ajax({
		url : '/ny6design_web/getProductList',
		success : function(data, status) {
			$("#productList").html(data);
		}
	});
}

function login() {
	$.ajax({
		url : '/ny6design_web/doLogin',
		success : function(data, status) {
			$("#productList").html(data);
		}
	});
}

function doLogin() {
	var emailAddress = $("#inputEmail3").val();
	var password = $("#inputPassword3").val();
	$.ajax({
		url : '/ny6design_web/login',
		type : 'POST',
		data : {
			email : emailAddress,
			password : password,
			url : window.location.pathname
		},
		success : function(data, status) {
			if (typeof (data.errormsg) !== "undefined") {
				$("#errorMsg").html(data.errormsg);
			} else {
				window.location.href = data.url;
			}
		}
	});
}

function doRegister() {
	initSelect();
	$.ajax({
		url : '/ny6design_web/doRegist',
		success : function(data, status) {
			$("#ads").html("");
			$("#productList").html(data);
		}
	});
}
function gotoMyAccount() {
	location.href = '/ny6design_web/account.html';
}
function loginOut() {
	location.href = '/ny6design_web/loginOut';
}
$(document).ready(function() {
	loadToolBar();
	loadMessages();
	loadCategories();
	loadProducts();
});
