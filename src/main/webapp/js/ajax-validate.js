$(document).ready(function() {
	$(document).ready(function() {
		
		$('#login').blur(function(event) {
            var login = $('#login').val();
            $.ajax({
            	url : 'signup',
            	method: 'POST',
            	data : {
            		login : login
            	},
            	success : function(responseText) {
    				$('#msg').text("222");
    			}
            });          
    });
		
        $('#passRpt').blur(function(event) {
                var password = $('#pass').val();
                var passwordRepeat = $('#passRpt').val();
               if (password == passwordRepeat) {
            	   $('#msgPassRpt').text("Ok!");
            	   $('#msgPassRpt').css({'color':'green'});            	   
               } else {
            	   $('#msgPassRpt').text("Password and Repeat Password do not match!");
            	   $('#msgPassRpt').css({'color':'red'});
               }
        });
        
	});	
});