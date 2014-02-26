function addPordcut(){
	/*console.log($("#addProductForm").attr("action"));
	console.log("--------------")
	console.log($("#addProductForm").serialize())
	*/
	$.post($("#addProductForm").attr("action"), $("#addProductForm").serialize(), function(html) {
//		retrun false;
		//or add some success message
	});
}

function orderby(orderColumnName, a_id){
	
	var orderby = "ASC";
	if($("#"+a_id+" .ASC")){
		orderby="DESC";
		$( this ).toggleClass( "ASC" );
		$( this ).toggleClass( "DESC" );
	}
	if($("#"+a_id+" .DESC")){
		orderby="ASC";
		$( this ).toggleClass( "ASC" );
		$( this ).toggleClass( "DESC" );
	}
	
	var url="/ny6design_web/getProductList4Admin?orderColumnName="+orderColumnName+"&orderBy="+orderby;
	
	$.ajax({
		url : url,
		success : function(data, status) {
			$("#maintable").html(data);
		}
	});
}
