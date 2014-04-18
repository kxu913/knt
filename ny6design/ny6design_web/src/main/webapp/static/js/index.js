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
function hideAds() {
	$("#ads").html("");
	$("#ads").hide();
}
function gotoMyAccount() {
	hideAds();
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
			loadCountry();
			loadStates();

		}
	});
}

function loadCountry() {
	var countryCode = $("#_countryCode").val();
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
}

function loadStates() {
	var stateCode = $("#_stateCode").val();
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
function loginOut() {
	location.href = '/ny6design_web/loginOut';
	getOrderCount();
}

function resetPassword() {
	$.ajax({
		url : '/ny6design_web/loadReset',
		success : function(data, status) {
			$("#productList").html(data);
		}
	});
}

function doReset() {
	var email = $("#inputEmailForReset").val();
	$.ajax({
		url : '/ny6design_web/doReset?email=' + email,
		success : function(data, status) {
			alert(data);
			loginOut();
		}
	});
}
function loadToolBar() {
	$.ajax({
		url : '/ny6design_web/getToolBar',
		success : function(data, status) {
			$("#toolbar").html(data);
			getOrderCount();
			getWishListTotalNum();
			$('#questionId').leanModal({
				top : 100,
				closeButton : ".modal_close"
			});
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

			$("#child div ul li a").each(
					function() {
						$(this).click(
								function() {
									var catId = $(this).parent().attr("id")
											.replace("category", "");
									loadProducts(catId);
								});
					});

		}
	});

}

function loadIndexProducts() {
	$.ajax({
		url : '/ny6design_web/getIndexProductList4FE',
		success : function(data, status) {
			$("#productList").html(data);
		}
	});
}

function loadProducts(categoryId) {
	if (categoryId != undefined && $.trim(categoryId) != "") {
		$.ajax({
			url : '/ny6design_web/getCategoryProductList4FE/' + categoryId,
			success : function(data, status) {
				$("#productList").html(data);
			}
		});
	}
}

function viewProduct(url) {
	$.ajax({
		url : '/ny6design_web/' + url,
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
			hideAds();
			initSelect();
			$("#productList").html(data);
		}
	});
}

function showFeedback() {
	$.ajax({
		url : '/ny6design_web/listFeedback?page=1',
		success : function(data, status) {
			hideAds();
			$("#productList").html(data);
			var options = {
				currentPage : 1,
				totalPages : $("#feedbackTotalPage").val(),
				onPageClicked : feedBackPageClick
			};
			$('#feedbackpager').bootstrapPaginator(options);
			$('#feedbackId').leanModal({
				top : 100,
				closeButton : ".modal_close"
			});
		}
	});

}

/**
 * for feedback pager
 */
var feedBackPageClick = function(event, originalEvent, type, page) {
	$.ajax({
		url : '/ny6design_web/listFeedback?page=' + page,
		success : function(data, status) {
			$("#ads").hide();
			$("#productList").html(data);
			var options = {
				currentPage : page,
				totalPages : $("#feedbackTotalPage").val(),
				onPageClicked : feedBackPageClick
			};
			$('#feedbackpager').bootstrapPaginator(options);
			$('#feedbackId').leanModal({
				top : 100,
				closeButton : ".modal_close"
			});
		}
	});
};

function init() {
	loadToolBar();
	loadMessages();
	loadCategories();
	loadIndexProducts();
}

function closeModal(id) {
	$("#lean_overlay").fadeOut(200);
	$("#" + id).css({
		"display" : "none"
	});
}

function submitFeedback() {
	var firstName = $("#firstName").val();
	var lastName = $("#lastName").val();

	var tel = $("#tel").val();
	var email = $("#email").val();

	var address = $("#address").val();
	var extra = $("#extra").val();

	$.ajax({
		url : '/ny6design_web/submitFeedback',
		type : 'POST',
		data : {
			firstName : firstName,
			lastName : lastName,
			tel : tel,
			email : email,
			address : address,
			extra : extra
		},
		success : function(data, status) {
			if (data === 0) {
				alert("Your feedback submit successful!");
				closeModal("addFeedback");
				showFeedback();
			} else {
				alert("Your question submit failed! please check your input");
			}
		}
	});
}

function submitQeustion() {
	var firstName = $("#firstNameFor").val();
	var lastName = $("#lastNameFor").val();

	var tel = $("#telFor").val();
	var email = $("#emailFor").val();

	var address = $("#addressFor").val();
	var extra = $("#extraFor").val();

	$.ajax({
		url : '/ny6design_web/submitQuestion',
		type : 'POST',
		data : {
			firstName : firstName,
			lastName : lastName,
			tel : tel,
			email : email,
			address : address,
			extra : extra
		},
		success : function(data, status) {
			if (data === 0) {
				alert("Your question submit successful!");
				closeModal("addQuestion");
			} else {
				alert("Your question submit failed! please check your input");
			}
		}
	});
}
/* for address */
function loadAddress() {

	$.ajax({
		url : '/ny6design_web/listAddress',
		success : function(data, status) {
			hideAds();
			$("#productList").html(data);
			loadCountry();
			loadStates();
			$('#addressId').leanModal({
				top : 100,
				closeButton : ".modal_close"
			});
		}
	});
}

function submitAddress() {
	var firstName = $("#firstName").val();
	var lastName = $("#lastName").val();

	var tel = $("#tel").val();
	var email = $("#email").val();

	var address = $("#address").val();
	var town = $("#town").val();

	var country = $("#countryId option:selected").attr("id");
	var zipcode = $("#zipcode").val();
	var statedId = $("#statedId option:selected").attr("id");
	$.ajax({
		url : '/ny6design_web/submitAddress',
		type : 'POST',
		data : {
			firstName : firstName,
			lastName : lastName,
			tel : tel,
			email : email,
			address : address,
			town : town,
			country : country,
			zipcode : zipcode,
			statedId : statedId
		},
		success : function(data, status) {
			if (data === 0) {
				alert("Your Address submit successful!");
				closeModal("addAddress");
				loadAddress();
			} else {
				alert("Your Address submit failed! please check your input");
			}
		}
	});
}

function setDefault(_a) {
	var addressId = _a.parentElement.parentElement.children[0].innerHTML;
	$.ajax({
		url : '/ny6design_web/updateDefault?addressId=' + addressId,
		success : function(data, status) {
			if (data === 0) {
				alert("Your default Address update successful!");
				closeModal("addAddress");
				loadAddress();
			} else {
				alert("Your Address update failed!");
			}
		}
	});

}

/* address end! */

/** * wish list start */
function viewWishList() {
	$.ajax({
		url : '/ny6design_web/wishList',
		success : function(data, status) {
			$("#productList").html(data);
		}
	});
}

function removeFromWishList(productId) {
	$.ajax({
		url : '/ny6design_web/wishList/removeproduct?productId=' + productId,
		success : function(data, status) {
			$("#productList").html(data);
			$(".glyphicon-heart").next().html($("#wishListSize").val());
		}
	});
}

function getWishListTotalNum() {
	$.ajax({
		url : 'wishlist/gettotalnum',
		success : function(data, status) {
			$(".glyphicon-heart").next().html(data);
		}
	});
}
/** * wish list end */

/** shopping cart start */

function loginForShip(){
	var emailAddress = $("#inputEmail3").val();
	var password = $("#inputPassword3").val();
	$.ajax({
		url : 'login',
		type : 'POST',
		data : {
			email : emailAddress,
			password : password,
			url : "shoppingcart/ship"
		},
		success : function(data, status) {
			if (typeof (data.errormsg) !== "undefined") {
				$("#errorMsg").html(data.errormsg);
			} else {
				loadToolBar();
				gotoShip();
			}
		}
	});
}

function getOrderCount() {
	$.ajax({
		url : 'shoppingcart/orderCount',
		success : function(data, status) {
			$("#shopping-cart-count").html(data);
		}
	});
}
function openShoppingCart() {
	$.ajax({
		url : 'shoppingcart/open',
		success : function(data, status) {
			hideAds();
			$("#productList").html(data);
		}
	});

}
/** shopping cart end */
$(document).ready(function() {
	init();
});

function checkout() {
	$.ajax({
		url : 'shoppingcart/checkout',
		success : function(data, status) {
			hideAds();
			$("#productList").html(data);
		}
	});
}

function gotoShip() {
	$.ajax({
		url : 'shoppingcart/ship',
		success : function(data, status) {
			hideAds();
			$("#productList").html(data);
		}
	});
}

function gotoDiscount() {
	$.ajax({
		url : 'shoppingcart/discount',
		success : function(data, status) {
			hideAds();
			$("#productList").html(data);
		}
	});
}

function gotShipmethod() {
	$.ajax({
		url : 'shoppingcart/shipmethod',
		success : function(data, status) {
			hideAds();
			$("#productList").html(data);
		}
	});
}

function gotoPaymethod() {
	$.ajax({
		url : 'shoppingcart/paymethod',
		success : function(data, status) {
			hideAds();
			$("#productList").html(data);
		}
	});
}

function submit(){
	$.ajax({
		url : 'shoppingcart/submit',
		success : function(data, status) {
			window.location.href = "index.html";
			getOrderCount();
		}
	});
}

function gotoOrderList(){
	$.ajax({
		url : 'order/listForUser',
		success : function(data, status) {
			hideAds();
			$("#productList").html(data);
		}
	});
}