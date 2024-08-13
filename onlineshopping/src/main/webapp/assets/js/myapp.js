$(function(){
	switch(menu){
		case 'About Us':
			$('#about').addClass('active');
			break;
		case 'Contact Us':
			$('#contact').addClass('active');
			break;
		default:
			$('#home').addClass('active');
			break;	
	}
});


var products =[
	
	['1','abc'],
	['2','bbc'],
	['3','dbc'],
	['4','lsc'],
	['5','ccc'],
	['6','aaa'],
	['7','nnc'],
	['8','ppp']
];

var $table = $('#productListTable');

if($table.length){
	$table.DataTable({
		data:products
	});
}