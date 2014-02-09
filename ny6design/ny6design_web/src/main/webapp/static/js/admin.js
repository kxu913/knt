function loadUsers() {
	$.ajax({
		url : '/ny6design_web/getAllUsers',
		success : function(data, status) {
			$("#maintable").html(data);
		}
	});
}

function searchUser(){
	var keyword = $("#keyword").val();
	$.ajax({
		url : '/ny6design_web/searchUsers',
		data : {
			keyword : keyword
		},
		success : function(data, status) {
			$("#maintable").html(data);
		}
	});
}
function backIndex(){
	location.href = '/ny6design_web/loginOut';
}
function editUser(_td) {
	var userId = _td.parentElement.children[0].innerHTML;
	$.ajax({
		url : '/ny6design_web/getUserById',
		data : {
			userId : userId
		},
		success : function(data, status) {
			$("#maintable").html(data);
			var countryCode = $("#_countryCode").val();
			var stateCode =$("#_stateCode").val();
			$.ajax({
				url : '/ny6design_web/getAllCountries',
				success : function(data, status) {
					var select = $("#countryId");
					$.each(data, function(key, val) {
						var id = val["code"];
						var description = val["fdescription"];
						var option;
						if (countryCode === id) {
							option = $("<option id='" + id + "' selected>"
									+ description + "</option>");
						} else {
							option = $("<option id='" + id + "'>" + description
									+ "</option>");
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
						if(stateCode === id){
							option = $("<option id='" + id + "' selected>" + description
								+ "</option>");
						} else {
							option = $("<option id='" + id + "'>" + description
									+ "</option>");
						}
						option.appendTo(select);
					});
				}
			});
			
		}
	});
}