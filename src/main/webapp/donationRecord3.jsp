<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%
String id = request.getParameter("userid");
String driver = "com.mysql.cj.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3307/";
String database = "blockchain-based-charity-system";
String userid = "root";
String password = "root";
try {
	Class.forName(driver);
} 
catch (ClassNotFoundException e) {
	e.printStackTrace();
}
Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="donationRecord3.css">
<meta charset="ISO-8859-1">
<style>
.styled-table {
    border-collapse: collapse;
    margin: 25px 0;
    font-size: 0.9em;
    font-family: sans-serif;
    min-width: 400px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
}
.styled-table thead tr {
    background-color: #AF69EF;
    color: #ffffff;
    text-align: left;
}
.styled-table th,
.styled-table td {
    padding: 12px 15px;
}
.styled-table tbody tr {
    border-bottom: 1px solid #dddddd;
}

.styled-table tbody tr:nth-of-type(even) {
    background-color: #f3f3f3;
}

.styled-table tbody tr:last-of-type {
    border-bottom: 2px solid #AF69EF;
}
.styled-table tbody tr.active-row {
    font-weight: bold;
    color: #AF69EF;
}

.glow-on-hover {
    width: 220px;
    height: 50px;
    border: none;
    outline: none;
    color: #fff;
    background: #111;
    cursor: pointer;
    position: relative;
    z-index: 0;
    border-radius: 10px;
    top:5%;
    left:0%;
    
}

.glow-on-hover:before {
    content: '';
    background: linear-gradient(45deg, #ff0000, #ff7300, #fffb00, #48ff00, #00ffd5, #002bff, #7a00ff, #ff00c8, #ff0000);
    position: absolute;
    top: -2px;
    left:-2px;
    background-size: 400%;
    z-index: -1;
    filter: blur(5px);
    width: calc(100% + 4px);
    height: calc(100% + 4px);
    animation: glowing 20s linear infinite;
    opacity: 0;
    transition: opacity .3s ease-in-out;
    border-radius: 10px;
}

.glow-on-hover:active {
    color: #000
}

.glow-on-hover:active:after {
    background: transparent;
}

.glow-on-hover:hover:before {
    opacity: 1;
}

.glow-on-hover:after {
    z-index: -1;
    content: '';
    position: absolute;
    width: 100%;
    height: 100%;
    background: #111;
    left: 0;
    top: 0;
    border-radius: 10px;
}

@keyframes glowing {
    0% { background-position: 0 0; }
    50% { background-position: 400% 0; }
    100% { background-position: 0 0; }
}

</style>

<title>Transaction Record</title>
</head>
<body>
<div class='container'>
<div align ="center">
<h1>Transaction Record (Project ID: 1003) </h1>

<table class="styled-table">
	<thead>
		<tr>
			<td>Block Number</td>
			<td>User ID</td>
			<td>Current Hash Value</td>
			<td>Previous Hash Value</td>
			<td>Donate Amount(RM)</td>
			<td>Time Stamp</td>
			<td>User State</td>
		</tr>
	</thead>

<%
try{
connection = DriverManager.getConnection(connectionUrl+database, userid, password);
statement=connection.createStatement();
String sql = "SELECT * FROM transaction where project_id ='1003' and project_block = (select max(project_block) from transaction where project_id = '1003')";
//finding maximum number
resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tbody>
<tr>
<td><%=resultSet.getInt("project_block") %></td>
<td><%=resultSet.getInt("user_id") %></td>
<td><%=resultSet.getString("current_hash") %></td>
<td><%=resultSet.getString("prev_hash") %></td>
<td><%=resultSet.getLong("amount") %></td>
<td><%=resultSet.getTimestamp("timestamp") %></td>
<td><%=resultSet.getString("user_state") %></td>
</tr>
</tbody>
<%
}
connection.close();
} catch (Exception e) {
e.printStackTrace();
}
%>
</table> <br><br>

<button class="glow-on-hover" onclick="location.href ='logout.jsp'">Logout</button>
<br>
<br>

<button class="glow-on-hover" onclick="location.href ='charityRecord3.jsp'">View All Transaction Records (Project ID: 1003)</button>

</div>
</div>
</body>
</html>