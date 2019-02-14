$(document).ready(function() {
		
		$('#login').blur(function(event) {
            var login = $('#login').val();
            if (!login){
            	 $('#msgLogin').text(" Please, enter your login!");
            	 $('#msgLogin').css({'color':'red'});
            } else {
            
            $.ajax({
            	url : 'signup',
            	method: 'POST',
            	data : {
            		action : "checkLogin",
            		login : login
            	},
            	success : function(responseText) {
            		var jsonData = JSON.parse(responseText);
            		
            		 if (!jsonData[0]) {
            			 $('#msgLogin').text(" Ok!");
            			 $('#msgLogin').css({'color':'green'});  
            		 } else {
            			 $('#msgLogin').html("");
            			 for (var i = 0; i < jsonData.length; i++) {
	            			$('#msgLogin').append('<br />').append(jsonData[i]);
            			 }
            			 $('#msgLogin').css({'color':'red'});
            		 }
    			}
            });  
        }
    });
		
		$('#email').blur(function(event) {
            var email = $('#email').val();
            if (!email){
            	 $('#msgEmail').text(" Please, enter your email!");
            	 $('#msgEmail').css({'color':'red'});
            } else {
            
            $.ajax({
            	url : 'signup',
            	method: 'POST',
            	data : {
            		action : "checkEmail",
            		email : email
            	},
            	success : function(responseText) {
            		var jsonData = JSON.parse(responseText);
            		
            		 if (!jsonData[0]) {
            			 $('#msgEmail').text(" Ok!");
            			 $('#msgEmail').css({'color':'green'});  
            		 } else {
            			 $('#msgEmail').html("");
            			 for (var i = 0; i < jsonData.length; i++) {
	            			$('#msgEmail').append('<br />').append(jsonData[i]);
            			 }
            			 $('#msgEmail').css({'color':'red'});
            		 }
    			}
            });  
        }
    });
		
		$('#pass').blur(function(event) {
            var pass = $('#pass').val();
            if (!pass){
            	 $('#msgPass').text(" Please, enter your password!");
            	 $('#msgPass').css({'color':'red'});
            } else {
            
            $.ajax({
            	url : 'signup',
            	method: 'POST',
            	data : {
            		action : "checkPass",
            		pass : pass
            	},
            	success : function(responseText) {
            		var jsonData = JSON.parse(responseText);
            		
            		 if (!jsonData[0]) {
            			 $('#msgPass').text(" Ok!");
            			 $('#msgPass').css({'color':'green'});  
            		 } else {
            			 $('#msgPass').html("");
            			 for (var i = 0; i < jsonData.length; i++) {
	            			$('#msgPass').append('<br />').append(jsonData[i]);
            			 }
            			 $('#msgPass').css({'color':'red'});
            		 }
    			}
            });  
        }
    });
		
				
        $('#passRpt').blur(function(event) {
                var password = $('#pass').val();
                var passwordRepeat = $('#passRpt').val();
                if (!passwordRepeat) {
                	$('#msgPassRpt').text(" Please, reenter your password!");
               	 	$('#msgPassRpt').css({'color':'red'});
                } else {
                
	               if (password == passwordRepeat) {
	            	   $('#msgPassRpt').text(" Ok!");
	            	   $('#msgPassRpt').css({'color':'green'});            	   
	               } else {
	            	   $('#msgPassRpt').text("Password and Repeat Password do not match!");
	            	   $('#msgPassRpt').css({'color':'red'});
	               }
                }
        });
        
});	