var tab = 0;
function loadUserPanel() {
	$('#mnCategory').empty();
	$.ajax({
		url : '/ny6design_web/loadUserPanel',
		success : function(data, status) {
			$("#mnCategory").html(data);
		}
	});
}

function gotoMyAccount() {
	loadUserPanel();
	loadUser();
}

function loadUser() {
	if (tab !== 1) {
		loadUserPanel();
		tab = 1;
	}
	$.ajax({
		url : '/ny6design_web/getUserByIdForAcct',
		success : function(data, status) {
			$("#productList").html(data);
			var countryCode = $("#_countryCode").val();
			var stateCode = $("#_stateCode").val();
			$.ajax({
				url : '/ny6design_web/getAllCountries',
				success : function(data, status) {
					var select = $("#countryId");
					$.each(data, function(key, val) {
						var id = val["code"];
						var description = val["fdescription"];
						var option;
						if (countryCode === id) {
							option = $("<option id='" + id + "' selected>" + description + "</option>");
						} else {
							option = $("<option id='" + id + "'>" + description + "</option>");
						}
						option.appendTo(select);
					});
				}
			});

			$.ajax({
				url : '/ny6design_web/getAllStates',
				success : function(data, status) {
					var select = $("#statedId");
					var initOption = $("<option value='-1'>Please choose!</option>");
					initOption.appendTo(select);
					$.each(data, function(key, val) {
						var id = val["code"];
						var description = val["fdescription"];
						var option;
						if (stateCode === id) {
							option = $("<option id='" + id + "' selected>" + description + "</option>");
						} else {
							option = $("<option id='" + id + "'>" + description + "</option>");
						}
						option.appendTo(select);
					});
				}
			});
		}
	});
}
function loginOut() {
	location.href = '/ny6design_web/loginOut';
}
function loadToolBar() {
	$.ajax({
		url : '/ny6design_web/getToolBar',
		success : function(data, status) {
			$("#toolbar").html(data);
		}
	});
}

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

function loadCategories() {
	$.ajax({
		url : '/ny6design_web/getAllCategoryList',
		dataType : "json",
		success : function(data, status) {
			$('#mnCategory').empty();
			$('#mnCategory').append("<div id='child'></div>");
			var appendDiv = "#child";
			$.each(data, function(key, val) {
				id = val["categoryId"];
				order = val["order"];
				pid = val["parentId"];
				name = val["name"];
				if (-1 == pid) {
					newItem = $(appendDiv).append('<div><h3><a/></h3><div><ul></ul></div></div>');
					$(newItem).find('>div:last').attr('id', 'category' + id).find("h3 a").text(name);

				} else {
					pNode = '#category' + pid;
					newItem = $(pNode).find('ul').append("<li><a/></li>");
					$(newItem).find('>li:last').attr('id', 'category' + id).find("a").text(name);
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

function login() {
	if (tab !== 0) {
		loadCategories();
		tab = 0;
	}
	$.ajax({
		url : '/ny6design_web/doLogin',
		success : function(data, status) {
			$("#productList").html(data);
		}
	});
}

function doRegister() {
	if (tab !== 0) {
		loadCategories();
		tab = 0;
	}
	$.ajax({
		url : '/ny6design_web/doRegist',
		success : function(data, status) {
			$("#ads").html("");
			initSelect();
			$("#productList").html(data);
		}
	});
}

$(document).ready(function() {
	loadToolBar();
	loadMessages();
	loadCategories();
	loadProducts();
});
