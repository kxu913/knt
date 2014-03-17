function initSelect() {
	$.ajax({
		url : '/ny6design_web/getAllFromMessage',
		success : function(data, status) {
			var select = $("#hearUs");
			var initOption = $("<option value='-1'>Please choose!</option>");
			initOption.appendTo(select);
			$.each(data, function(key, val) {
				var id = val["fromid"];
				var description = val["description"];
				var option = $("<option id='" + id + "'>" + description
						+ "</option>");
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
				option = $("<option id='" + id + "'>" + description
						+ "</option>");
				option.appendTo(select);
			});
		}
	});

	$.ajax({
		url : '/ny6design_web/getAllCountries',
		success : function(data, status) {
			var select = $("#countryId");
			$.each(data, function(key, val) {
				var id = val["code"];
				var description = val["fdescription"];
				var option;
				if ('US' === id) {
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
}

function register(isUpdate) {
	var userid = $("#userid").val();
	var emailAddress = $("#inputEmail").val();
	var isPublicEmail = $("#publicEmail").attr("checked");
	var password = $("#inputPassword").val();
	var confirmedPassword = $("#inputConfirmedPassword").val();

	var firstName = $("#firstName").val();
	var lastName = $("#lastName").val();

	var address = $("#address").val();
	var town = $("#town").val();

	var state = $("#statedId option:selected").attr("id");

	var zipcode = $("#zipcode").val();
	var country = $("#countryId option:selected").attr("id");

	var telephone = $("#telephone").val();
	var isPublicTel = $("#publicTel").attr("checked");
	
	var fax = $("#fax").val();

	var taxId = $("#taxId").val();
	var hearUs = $("#hearUs option:selected").attr("id");
	$.ajax({
		url : '/ny6design_web/register',
		type : 'POST',
		data : {
			userid : userid,
			emailAddress : emailAddress,
			isPublicEmail : isPublicEmail,
			password : password,
			confirmedPassword : confirmedPassword,
			firstName : firstName,
			lastName : lastName,
			address : address,
			town : town,
			state : state,
			zipcode : zipcode,
			country : country,
			telephone : telephone,
			isPublicTel: isPublicTel,
			fax : fax,
			taxId : taxId,
			hearUs : hearUs,
			url : window.location.href

		},
		success : function(data, status) {
			if (typeof (data.errormsg) !== "undefined") {
				for (var i = 0; i < 14; i++) {
					var index = "#errorMsg" + i;
					if (i === data.index) {
						$(index).html(data.errormsg);
					} else {
						$(index).html("");
					}
				}
			} else {
				if (typeof (isUpdate) !== "undefined") {
					loadUsers();
				} else {
					window.location.href = data.url;
				}
			}
		}
	});

}