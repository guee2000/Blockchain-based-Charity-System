<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-2.1.3.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert-dev.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/1.1.3/sweetalert.css">
<script type="text/javascript">
	//function alertName(){
		//alert("You have been successfully logout!");
		////will get back to login page after clicking 'ok' in alert form
		//window.location= "login.jsp";
		
		//swal({
		    //title: "Log out",
		    //text: "Successful!",
		    //type: "success"
		//}).then(function() {
		    //location = "login.jsp";
		//});

    setTimeout(function() {
        swal({
            title: "Log out",
            text: "Successful!",
            type: "success"
        }, function() {
            window.location = "menu.jsp";
        });
    }, 1000);
</script>
	    	

<% session.invalidate();%>
<script type="text/javascript"> window.onload = alertName; </script>
<%--<% response.sendRedirect("login.jsp");%>--%>
</body>
</html>