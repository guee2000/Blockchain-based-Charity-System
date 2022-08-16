<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    <title> Login Form </title>
    <link rel="stylesheet" href="login.css">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
<body>
  <div class="container">
    <div class="title">Login Form</div>
    <div class="content">
      <form action="login" method="post">
        <div class="user-details">
          <div class="input-box">
            <span class="details">Username:</span>
            <input type="text" placeholder="Enter your username" name="usrInput" required>
          </div>
          
          <div class="input-box">
            <span class="details">Password</span>
            <input type="password" placeholder="Enter your password" name="pwdInput" required>
          </div>
        </div>
        <div class="button">
          <input type="submit" value="Login">
        </div>
        Don't have any account? <a href="memberRegistration.jsp">Click here</a>
      </form>
    </div>
  </div>

</body><body>

</body>
</html>