function login() {
	var loginName = $("#loginName").val();
	var password = $("#password").val();
	var verifyCode = $("#kaptcha").val();
	// $.post("/frontpage/login.do", {
	// loginName : loginName,
	// password : password,
	// captcha : verifyCode
	// },success: function(data,status){
	// location.href = "/admin/adminDetail";
	// });
	$.ajax({
		type : 'POST',
		url : '/frontpage/login.do',
		async : false,
		data : {
			loginName : loginName,
			password : password,
			captcha : verifyCode
		},
		success : function(data, status) {
			location.href = "/frontpage/admin/adminDetail";
		}
	// dataType: dataType
	});
	// window.location.href = "/frontpage/login?loginName=" + loginName
	// + "&password=" + password + "&captcha="+verifyCode;
}

function fulshKaptchaImage() {
	$("#kaptchaImage").attr("src",
			"/frontpage/kaptcha.jpg?" + Math.floor(Math.random() * 100));
}