<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Form</title>
    <link rel="stylesheet" href="payment.css">
   

</head>
<body>

<form action ="charity" method="post">
    <div class="container">
        <h1>Confirm Your Payment</h1>
        <div class="first-row">
            <div class="name">
                <h3>Full Name</h3>
                <div class="input-field">
                    <input type="text" required>
                </div>
            </div>
            <div class="cvv">
                <h3>CVV</h3>
                <div class="input-field">
                    <input type="password" required>
                </div>
            </div>
        </div>
        <div class="second-row">
            <div class="card-number">
                <h3>Card Number</h3>
                <div class="input-field">
                    <input type="text" required>
                </div>
            </div>
        </div>
        <div class="third-row">
            <h3>Expiry Date</h3>
            <div class="selection">
                <div class="date">
                    <select name="months" id="months">
                        <option value="Jan">Jan</option>
                        <option value="Feb">Feb</option>
                        <option value="Mar">Mar</option>
                        <option value="Apr">Apr</option>
                        <option value="May">May</option>
                        <option value="Jun">Jun</option>
                        <option value="Jul">Jul</option>
                        <option value="Aug">Aug</option>
                        <option value="Sep">Sep</option>
                        <option value="Oct">Oct</option>
                        <option value="Nov">Nov</option>
                        <option value="Dec">Dec</option>
                      </select>
                      <select name="years" id="years">
                        <option value="2028">2028</option>
                        <option value="2027">2027</option>
                        <option value="2026">2026</option>
                        <option value="2025">2025</option>
                        <option value="2024">2024</option>
                        <option value="2023">2023</option>
                      </select>
                </div>
                <div class="cards">
                    <img src="images/mc.png" alt="">
                    <img src="images/vi.png" alt="">
                    
                </div>
            </div>
			    <jsp:declaration>
					String projectId="";
					String AmountInput = "";
				</jsp:declaration>
				
				<jsp:scriptlet>
					projectId = request.getParameter("projectId");
					AmountInput = request.getParameter("AmountInput");
				</jsp:scriptlet>
				<strong>
					Project ID: <jsp:expression>projectId</jsp:expression><br><br>
					Donate Amount: RM<jsp:expression>AmountInput</jsp:expression>
				</strong> 
		<%                          
            session.setAttribute("projectId", String.valueOf(projectId));
            session.setAttribute("AmountInput", String.valueOf(AmountInput));
        %>  
		
        </div>
        
       <!--  <a href="charity">Confirm</a> -->
   	<input type="submit" value="Confirm">
	<button onclick="history.back()">Cancel</button>
	</div>
	
	</form>
	
	
	
</body>
</html>