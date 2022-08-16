<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<div class="navbar">
  <a href="menu.jsp">Home</a> 
  <a href="Nutrition.html">Nutrition</a> 
  <a href="Fitness.html">Fitness</a> 
  <a href="contactform/">Contact Us</a> 
  <a class="button" style="float:right" href="menu.jsp">
  <div class="logout.jsp">Log Out</div>
    </a>
</div>
<style>	
.left .button-64 {
    align-items: center;
    background-image: linear-gradient(144deg,#AF40FF, #5B42F3 50%,#00DDEB);
    border: 0;
    border-radius: 8px;
    box-shadow: rgba(151, 65, 252, 0.2) 0 15px 30px -5px;
    box-sizing: border-box;
    color: #FFFFFF;
    display: flex;
    font-family: Phantomsans, sans-serif;
    font-size: 20px;
    justify-content: center;
    line-height: 1em;
    max-width: 100%;
    min-width: 140px;
    padding: 3px;
    text-decoration: none;
    user-select: none;
    -webkit-user-select: none;
    touch-action: manipulation;
    white-space: nowrap;
    cursor: pointer;
}

.left .button-64:active,
.left .button-64:hover {
  outline: 0;
}

.left .button-64 span {
    background-color: rgb(5, 6, 45);
    padding: 16px 24px;
    border-radius: 6px;
    width: 100%;
    height: 100%;
    transition: 300ms; 
}

.left .button-64:hover span {
    background: none;
}

@media (min-width: 1500px) {
  .left .button-64 {
    font-size: 24px;
    min-width: 196px;
  }
}

    
.middle .button-64 {
    align-items: center;
    background-image: linear-gradient(144deg,#AF40FF, #5B42F3 50%,#00DDEB);
    border: 0;
    border-radius: 8px;
    box-shadow: rgba(151, 65, 252, 0.2) 0 15px 30px -5px;
    box-sizing: border-box;
    color: #FFFFFF;
    display: flex;
    font-family: Phantomsans, sans-serif;
    font-size: 20px;
    justify-content: center;
    line-height: 1em;
    max-width: 100%;
    min-width: 140px;
    padding: 3px;
    text-decoration: none;
    user-select: none;
    -webkit-user-select: none;
    touch-action: manipulation;
    white-space: nowrap;
    cursor: pointer;
}

.middle .button-64:active,
.middle .button-64:hover {
    outline: 0;
}

.middle .button-64 span {
    background-color: rgb(5, 6, 45);
    padding: 16px 24px;
    border-radius: 6px;
    width: 100%;
    height: 100%;
    transition: 300ms;
}

.middle .button-64:hover span {
    background: none;
}

@media (min-width: 1500px) {
  .middle .button-64 {
    font-size: 24px;
    min-width: 196px;
  }
}

    
.right .button-64 {
    align-items: center;
    background-image: linear-gradient(144deg,#AF40FF, #5B42F3 50%,#00DDEB);
    border: 0;
    border-radius: 8px;
    box-shadow: rgba(151, 65, 252, 0.2) 0 15px 30px -5px;
    box-sizing: border-box;
    color: #FFFFFF;
    display: flex;
    font-family: Phantomsans, sans-serif;
    font-size: 20px;
    justify-content: center;
    line-height: 1em;
    max-width: 100%;
    min-width: 140px;
    padding: 3px;
    text-decoration: none;
    user-select: none;
    -webkit-user-select: none;
    touch-action: manipulation;
    white-space: nowrap;
    cursor: pointer;
}

.right .button-64:active,
.right .button-64:hover {
    outline: 0;
}

.right .button-64 span {
    background-color: rgb(5, 6, 45);
    padding: 16px 24px;
    border-radius: 6px;
    width: 100%;
    height: 100%;
    transition: 300ms;
}

.right .button-64:hover span {
    background: none;
}

@media (min-width: 1500px) {
  .right .button-64 {
    font-size: 24px;
    min-width: 196px;
  }
}

</style>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
<link rel="stylesheet" href="selectCharity.css">
<title>Charity Project</title>

</head>
<body>



<div class="container">
	<div class="title">Select the Charity Project</div>
	<div class="userid"><strong>User ID: <%=request.getAttribute("showuserid1")%></strong></div>
	
	<div class="left">
	<img src="images/orphan1.jpg" alt="Image" height="250" width="300"><br>
	<button class="button-64"  name="projectId" role="button" value="1001" onclick= "location.href ='detailofcharity1.jsp'"><span class="text">Project ID: 1001</span></button>
	<br>
	<h3><strong>LoveKids(Orphan Organisation)</strong></h3>
	</div>
	
	<div class="middle">
	<img src="images/of.jpg" alt="Image" height="250" width="300"><br>
	<button class="button-64"  name="projectId" role="button" value="1002" onclick= "location.href ='detailofcharity2.jsp'"><span class="text">Project ID: 1002</span></button>
    <br>
	<h3><strong>HappyHome(Old Folks Organisation)</strong></h3>
	</div>
	
	<div class="right">
	<img src="images/sd.jpg" alt="Image" height="250" width="300"><br>
	<button class="button-64"  name="projectId" role="button" value="1003" onclick= "location.href ='detailofcharity3.jsp'"><span class="text">Project ID: 1003</span></button>
	<br>
	<h3><strong>EqualWorld (Down Syndrome</strong></h3>
	<h3><strong>Organisation)</strong></h3>
	</div>
	<br><br><a href = "logout.jsp">Logout</a>

</div>


</body>
</html>