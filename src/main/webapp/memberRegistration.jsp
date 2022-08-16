<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en" dir="ltr">
  <head>
    <meta charset="UTF-8">
    
    <title> Registration Form </title>
    <link rel="stylesheet" href="register(test).css">
  
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
   </head>
<body>
  <div class="container">
    <div class="title">Registration Form</div>
    <div class="content">
      <form action="register" method="post">
        <div class="user-details">
          <div class="input-box">
            <span class="details">Username (7 to 20 long)</span>
            <input type="text" placeholder="Enter your username" name="usrInput" required>
          </div>
          <div class="input-box">
            <span class="details">First Name </span>
            <input type="text" placeholder="Enter your first name" name="fnameInput" required>
          </div>
          <div class="input-box">
            <span class="details">Last Name </span>
            <input type="text" placeholder="Enter your last name" name="lnameInput" required>
          </div>
          <div class="input-box">
            <span class="details">State</span>
            <select name="stateInput" required>
            <option value="Johor">Johor</option>
			<option value="Kedah">Kedah</option>
			<option value="Kelantan">Kelantan</option>
			<option value="Malacca">Malacca</option>
			<option value="Negeri Sembilan">Negeri Sembilan</option>
			<option value="Pahang">Pahang</option>
			<option value="Penang">Penang</option>
			<option value="Perak">Perak</option>
			<option value="Perlis">Perlis</option>
			<option value="Sabah">Sabah</option>
			<option value="Sarawak">Sarawak</option>
			<option value="Selangor">Selangor</option>
			<option value="Terangganu">Terangganu</option>
          	</select>
          </div>
          <div class="input-box">
            <span class="details">Phone Number (E.g: 0123456789)</span>
            <input type="text" placeholder="Enter your phone number" name="phonenumInput" required>
          </div>
          <div class="input-box">
            <span class="details">Email (E.g: gjs@gmail.com)</span>
            <input type="text" placeholder="Enter your email" name="emailInput" required>
          </div>
          <div class="input-box">
            <span class="details">Password</span>
            <input type="password" placeholder="Enter your password" name="pwdInput" required>
          </div>
          <div class="input-box">
            <span class="details">Confirm Password</span>
            <input type="password" placeholder="Confirm your password" name="pwdInput2" required>
          </div>
        </div>
        
        <div class="button">
          <input type="submit" value="Register">
        </div>
        Already have an account? <a href="login.jsp">Click here</a>
      </form>
    </div>
  </div>

</body><body>

</body>
</html>