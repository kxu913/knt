function loadUsers() {
	$.ajax({
		url : '/ny6design_web/getAllUsers',
		success : function(data, status) {
			$("#maintable").html(data);
		}
	});
}
$(document).ready(function() {
	// loadAdminCategories();
});