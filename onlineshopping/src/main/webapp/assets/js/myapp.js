$(function() {
	switch (menu) {
		case 'About Us':
			$('#about').addClass('active');
			break;
		case 'Contact Us':
			$('#contact').addClass('active');
			break;
		case 'All Products':
			$('#listProducts').addClass('active');
			break
		case 'Manage Products':
			$('#manageProducts').addClass('active');
			break
		case 'User Cart':
			$('#userCart').addClass('active');
		break
		default:
			if (menu == "home") break;
			$('#listProducts').addClass('active');
			$('#a_' + menu).addClass('active');
			break;
	}
	//--------------------------------------------------------------
	// to tackle the csrf token
	var token = $('meta[name="_csrf"]').attr('content');
	var header= $('meta[name="_csrf_header"]').attr('content');
	
	if(token.length > 0 && header.length > 0){
		$(document).ajaxSend(function(e, xhr , options){
			xhr.setRequestHeader(header, token);
		});
	}
	
var $table = $('#productListTable');

if ($table.length) {

	var jsonUrl = '';
	if (window.categoryId == '') {
		jsonUrl = window.contextRoot + '/json/data/all/products';
	} else {
		jsonUrl = window.contextRoot + '/json/data/category/' + window.categoryId + '/products';
	}

	$table.DataTable({
		lengthMenu: [[3, 5, 10, -1], ['3 Records', '5 Records', '10 Records', 'All Records']],
		pageLength: 5,
		ajax: {
			url: jsonUrl,
			dataSrc: ''
		},
		columns: [
			{
				data: 'code',
				mRender: function(data, type, row) {
					return '<img src ="' + window.contextRoot + '/resources/img/' + data + '.jpg" class="dataTableImg">';
				}
			},
			{
				data: 'name'
			},
			{
				data: 'brand'
			},
			{
				data: 'unitPrice',
				mRender: function(data, type, row) { return '&#8377;' + data }
			},
			{
				data: 'quantity',
				mRender: function(data, type, row) {
					if (data < 1) {
						return '<span style="color:red">Out of stock!</span>';
					}
					return data;
				}
			},
			{
				data: 'id',
				bSortable: false,
				mRender: function(data, type, row) {
					var str = '';
					str += '<a href="' + window.contextRoot + '/show/' + data + '/product" class="btn btn-primary"><span class="glyphicon glyphicon-eye-open"></a>&#160;';
   					
   					if(userRole == 'ADMIN'){
						str += '<a href="' + window.contextRoot + '/manage/' + data + '/product" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></a>';
						}else{
					if (row.quantity < 1) {
						str += '<a href="javascript:void(0)" class="btn btn-success disabled"><span class="glyphicon glyphicon-shopping-cart"></a>';
					} else {
							str += '<a href="' + window.contextRoot + '/cart/add/' + data + '/product" class="btn btn-success"><span class="glyphicon glyphicon-shopping-cart"></a>';
						}
						
					}

					return str;
				}
			}

		]
	});
}


//dismissing the start after  

var $alert = $('.alert');

if ($alert.length) {

	setTimeout(function() {
		$alert.fadeOut('slow');

	}, 3000)
}


////-----------------------------------------------------------------


/*$('.switch input[type="checkbox"]').on('change',function(){
	var checkbox = $(this);
	var checked = checkbox.prop('checked');
	var dMsg = (checked)? 'You want to activated the product?':'You want to deactivate the product?';
	var value = checkbox.prop('value');
	bootbox.confirm({
		size : 'medium',
		title: 'Product activation & Deactivation',
		message: dMsg,
		callback: function(confirmed){
			if(confirmed){
				bootbox.alert({
					size: 'medium',
					title: 'Information',
					message: 'You are going to perform opertion on product' +value
				});
			}else{
				checkbox.prop('checked',!checked);
			}
		}
	});
});
*/
//--------------------------------------------
//--------Data Table for Admin----------------
//--------------------------------------------


var $productslistTable = $('#productsListTable');

if ($productslistTable.length) {

	var jsonUrl = window.contextRoot + '/json/data/admin/all/products';

	console.log(jsonUrl);
	$productslistTable.DataTable({
		lengthMenu: [[10, 30, 50, -1], ['10 Records', '30 Records', '50 Records', 'All Records']],
		pageLength: 30,
		ajax: {
			url: jsonUrl,
			dataSrc: ''
		},
		columns: [
			{
				data: 'id',
			},

			{
				data: 'code',
				bSortable: false,
				mRender: function(data, type, row) {
					return '<img src ="' + window.contextRoot
						+ '/resources/img/' + data
						+ '.jpg" class="dataTableImg">';
				}
			},
			{
				data: 'name'
			},
			{
				data: 'brand'
			},
			{
				data: 'quantity',
				mRender: function(data, type, row) {
					if (data < 1) {
						return '<span style="color:red">Out of stock!</span>';
					}
					return data;
				}
			},
			{
				data: 'unitPrice',
				mRender: function(data, type, row) {
					return '&#8377; ' + data
				}
			},
			{
				data: 'active',
				bSortable: false,
				mRender: function(data, type, row) {
					var str = '';

					if (data) {
						str += '<label class="switch"><input type="checkbox" checked="checked" value="' + row.id + '"><div class="slider round"></div></label>';
					} else {
						str += '<label class="switch"><input type="checkbox"  value="' + row.id + '"><div class="slider round"></div></label>';
					}


					return str;
				}
			},

			{
				data: 'id',
				bSortable: false,
				mRender: function(data, type, row) {
					var str = '';
					str += '<a href="'+ window.contextRoot +'/manage/'
						+ data + '/product" class="btn btn-warning"><span class="glyphicon glyphicon-pencil"></span></a>';
					return str;
				}
			}
		],

		initComplete: function() {
			var api = this.api();
			api.$('.switch input[type="checkbox"]').on('change', function() {
				var checkbox = $(this);
				var checked = checkbox.prop('checked');
				var dMsg = (checked) ? 'You want to activated the product?' : 'You want to deactivate the product?';
				var value = checkbox.prop('value');
				bootbox.confirm({
					size: 'medium',
					title: 'Product activation & Deactivation',
					message: dMsg,
					callback: function(confirmed) {
						/*if (confirmed) {
							$.ajax({
								type:'GET',
								url: window.contextRoot +'/manage/product/' +checkbox.prop('value')+'/activation',
								timeout:100000,
								success :function(data){
									bootbox.alert(data);
								},
								error:function(e){
									bootbox.alert('Error ' +e);
								}
							});
						}*/
					if (confirmed) {
		                            console.log(value);	                            
		                            var activationUrl = window.contextRoot+'/manage/product/'+value+'/activation';	                            
		                            $.post(activationUrl, function(data) {
			                            bootbox.alert({
			                                size: 'medium',
			                                title: 'Information',
			                                message: data
			                            });	                            	
		                            });
		                            
		                        } else {
							checkbox.prop('checked', !checked);
						}
					}
				});
			});

		}

	});
}



//------------------------------------------------------
// validation code for category

var $categoryForm = $('#categoryForm');
if($categoryForm.length){
	$categoryForm.validate({
		rules : {
				name : {
					required: true,
					minlength:2
				},
				description : {
					required : true,
				}
			},
			messages : {
				name : {
					required : 'Please add the category name',
					minlength: 'The category name should not be less than two characters'
				},
				description : {
					required: 'Please add discription'
				}
			},
				errorElement: 'em',
				errorPlacement :function(error, element){
					error.addClass("help-block");
					error.insertAfter(element);
				}
	});
}

//------------------------------------------------------------
//-----validation for login form
var $loginForm = $('#loginForm');
if($loginForm.length){
	$loginForm.validate({
		rules : {
				username : {
					required: true,
					email:true
				},
				password : {
					required : true,
				}
			},
			messages : {
				username : {
					required : 'Please enter the username',
					email: 'Please enter valid email address'
				},
				password : {
					required : 'Please enter the password',
				},
				
			},
			errorElement: 'em',
				errorPlacement :function(error, element){
					error.addClass("help-block");
					error.insertAfter(element);
				}
	});
}
  //------------------------------------------------------

	$('button[name = "refreshCart"]').click(function(){
		
		//fetch the cart line id
		
		var cartLineId = $(this).attr('value');
		var countElement = $('#count_'+cartLineId);
		
		var orignalCount = countElement.attr('value');
		var currentCount = countElement.val();
		
		if(currentCount < 1 || currentCount >3){
			countElement.val(orignalCount);
			bootbox.alert({
				size:'medium',
				title: 'Error',
				message:'Product count shound be minimum 1 and maximum 3 !'
			});
		}else{
			var updateUrl = window.contextRoot + '/cart/' + cartLine + 'update?count=' +currentCount;
			window.location.href = updateUrl; 
		}
		
	});
	
	
	
	//-------------------------------------------------------------
});



