function login() {
	$(function() {
		$.get("/frontpage/user/login", {
			loginName : $("#loginName").val(),
			password : $("#password").val()
		}
//		, function(data) {
//			// data contains the result
//				// Assign result to the sum id
//				$("#sum").replaceWith('<span id="sum">' + data + '</span>');
//			}
		);
	});
}