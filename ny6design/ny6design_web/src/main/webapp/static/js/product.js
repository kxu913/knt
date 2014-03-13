function addPordcut(){
	/*console.log($("#addProductForm").attr("action"));
	console.log("--------------")
	console.log($("#addProductForm").serialize())
	*/
	$.post($("#addProductForm").attr("action"), $("#addProductForm").serialize(), function(html) {
		$("#maintable").html(html);
	});
}

function bindOrder(){
	 $(".btn-link").click(function(){
         var order="ASC";
         var columnName= $(this).val();
         if($(this).hasClass("ASC")){
        	  $(this).removeClass("class", "ASC");
              $(this).attr("class", "DESC");
              order="DESC";
         }else{
        	  $(this).removeClass("class", "DESC");
              $(this).attr("class", "ASC");
              order="ASC";
         }
         var url="/ny6design_web/getProductList4Admin?orderColumnName="+columnName+"&orderBy="+order;
     	 $.ajax({
     		url : url,
     		success : function(data, status) {
     			$("#maintable").html(data);
     		}
     	 });
    });
}
//bindOrder();

function orderby(orderColumnName, elementObj){
	
	var orderby="ASC";
    if($(elementObj).hasClass("ASC")){
    	 $(this).removeClass("class", "ASC");
         $(elementObj).attr("class", "DESC");
         orderby="DESC";
    }else{
    	 $(this).removeClass("class", "DESC");
         $(elementObj).attr("class", "ASC");
         orderby="ASC";
    }
    
	var url="/ny6design_web/getProductList4Admin?orderColumnName="+orderColumnName+"&orderBy="+orderby;
	
	$.ajax({
		url : url,
		success : function(data, status) {
			$("#maintable").html(data);
		}
	});
}

function copyProduct(){
	var productIds = getCheckedUser();
	
	if($.trim(productIds)==""){
		alert("please choose at least one product!");
	}
	
	$.ajax({
		url : "/ny6design_web/copyproduct/"+productIds,
		success : function(data, status) {
			$("#maintable").html(data);
		}
	});
}

function delProduct(){
	var productIds = getCheckedUser();
	
	if($.trim(productIds)==""){
		alert("please choose at least one product!");
	}
	
	$.ajax({
		url : "/ny6design_web/delproduct/"+productIds,
		success : function(data, status) {
			$("#maintable").html(data);
		}
	});
}


function editProduct(productId){
	
	$.ajax({
		url : "/ny6design_web/editproduct/"+productId,
		success : function(data, status) {
			$("#maintable").html(data);
		}
	});
}

function getCheckedUser(){
	var str="";
	var listchk = $("input[name='productId[]']");
	for(i=0;i<listchk.length;i++){
	 if(listchk[i].checked){
	  str += listchk[i].value+',';
	 }
	}
//	console.log("checked: "+str);
	return str;
}

function productfilter(){
	var name = $("#filter_name").val();
	var model = $("#filter_model").val();
	var price = $("#filter_price").val();
	var quantity = $("#filter_quantity").val();
	var status = $("#filter_status").val();
	
	var url="/ny6design_web/productfilter?";
	if($.trim(name)!=""){
		url += "name="+name;
	}
	if($.trim(model)!=""){
		url += "model="+model;
	}
	if($.trim(price)!=""){
		url += "price="+price;
	}
	if($.trim(quantity)!=""){
		url += "quantity="+quantity;
	}
	if($.trim(status)!=""){
		url += "status="+status;
	}
	
	$.ajax({
		url : url,
		success : function(data, status) {
			$("#maintable").html(data);
		}
	});
}