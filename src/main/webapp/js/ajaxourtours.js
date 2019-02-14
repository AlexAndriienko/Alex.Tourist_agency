$(document).ready(function() {
	$(".addTourBtn").click(function() {
		var id = $(this).attr('id');
		
		 $.ajax({
         	url : 'account',
         	method: 'POST',
         	data : {
         		formParam : "4",
         		tourId : id
         	},
         	
         	success : function(responseText) {
         		alert(responseText)
         		$("#" + id).parent().html('<a href="account"> <img class = "tickmark" src="images/tick-mark.png" alt="mark"></a>');
 			}
         });  
		
		
	});		
});	