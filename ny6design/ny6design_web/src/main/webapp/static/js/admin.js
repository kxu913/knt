function loadProductList() {
	$.ajax({
		url : '/ny6design_web/getProductList4Admin',
		success : function(data, status) {
			$("#maintable").html(data);
		}
	});
}

function insertProduct() {
	$.ajax({
		url : '/ny6design_web/insertProduct',
		success : function(data, status) {
			$("#maintable").html(data);
		}
	});
}


function loadUsers() {
	$.ajax({
		url : '/ny6design_web/getAllUsers',
		success : function(data, status) {
			$("#maintable").html(data);
		}
	});
}
/* for question */
function loadQuestions() {
	$.ajax({
		url : '/ny6design_web/getUnrepliedQuestions',
		success : function(data, status) {
			$("#maintable").html(data);
		}
	});
}

function searchQuestion(keyword) {
	var keyword = $("#keyword").val();
	$.ajax({
		url : '/ny6design_web/searchQuestion?keyword=' + keyword,
		success : function(data, status) {
			$("#maintable").html(data);
		}
	});
}
/* question end! */

/* for feedback */
function loadFeedback() {
	$.ajax({
		url : '/ny6design_web/listFeedbackForAdminpage',
		success : function(data, status) {
			$("#maintable").html(data);
		}
	});
}

function updateRecommend(_a, recommend) {
	var feedbackId = _a.parentElement.parentElement.children[0].innerHTML;
	$.ajax({
		url : '/ny6design_web/updateRecommend',
		data : {
			feedbackId : feedbackId,
			recommend : recommend
		},
		success : function(data, status) {
			if (data == 1) {
				loadFeedback();
			}
		}
	});
}

function searchFeedback(keyword) {
	var keyword = $("#keyword").val();
	$.ajax({
		url : '/ny6design_web/searchFeedback?keyword=' + keyword,
		success : function(data, status) {
			$("#maintable").html(data);
		}
	});
}
/* feedback end! */
function searchUser() {
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
function backIndex() {
	location.href = '/ny6design_web/loginOut';
}
function editUser(_td) {
	var userId = _td.parentElement.children[0].innerHTML;
	$
			.ajax({
				url : '/ny6design_web/getUserById',
				data : {
					userId : userId
				},
				success : function(data, status) {
					$("#maintable").html(data);
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
									option = $("<option id='" + id
											+ "' selected>" + description
											+ "</option>");
								} else {
									option = $("<option id='" + id + "'>"
											+ description + "</option>");
								}
								option.appendTo(select);
							});
						}
					});

					$
							.ajax({
								url : '/ny6design_web/getAllStates',
								success : function(data, status) {
									var select = $("#statedId");
									var initOption = $("<option value='-1'>Please choose!</option>");
									initOption.appendTo(select);
									$
											.each(
													data,
													function(key, val) {
														var id = val["code"];
														var description = val["fdescription"];
														var option;
														if (stateCode === id) {
															option = $("<option id='"
																	+ id
																	+ "' selected>"
																	+ description
																	+ "</option>");
														} else {
															option = $("<option id='"
																	+ id
																	+ "'>"
																	+ description
																	+ "</option>");
														}
														option.appendTo(select);
													});
								}
							});

				}
			});
}