package next_xadmin.register;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import next_xadmin.login.bean.LoginBean;

public class RegisterDao {
	
	private String dbUrl = "jdbc:mysql://localhost:3307/blockchain-based-charity-system";
	private String dbUname = "root";
	private String dbPassword = "root";
	private String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection()
	{
		Connection con = null;
		try {
			con = DriverManager.getConnection(dbUrl, dbUname,dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	
	
	public String insert(User user) 
	{
		loadDriver(dbDriver);
		Connection con = getConnection();
		String result = "Data is entered successfully";
		String sql = " insert into user (user_username, user_fname,user_lname,user_state,user_phonenum,user_email,user_pwd)"+" values (?,?,?,?,?,?,?)";
		
		PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, user.getUsrInput());
		ps.setString(2, user.getFnameInput());
		ps.setString(3, user.getLnameInput());
		ps.setString(4, user.getStateInput());
		ps.setString(5, user.getPhonenumInput());
		ps.setString(6, user.getEmailInput());
		ps.setString(7, user.getPwdInput());
		ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "Data is not entered";
			
		}
		
		return result;
		
	}
	
	public boolean checkexsist(User user) {
		loadDriver(dbDriver);
		Connection con = getConnection();
		boolean status = false;
		String sql = "select * FROM user where user_username = ?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, user.getUsrInput());
		
		ResultSet rs = ps.executeQuery();
		status = rs.next();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return status;
		
	}
	
	public boolean validateEmail(String input) {
		String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
		Pattern emailPat = Pattern.compile(emailRegex,Pattern.CASE_INSENSITIVE);
		Matcher matcher = emailPat.matcher(input);
		return matcher.find();
	}
	
	public boolean validatePhone(String input) {
		return input.charAt(0) == '0' && input.charAt(1) =='1' && (input.length() == 10 || input.length() == 11) && input.matches("[0-9]+");
//		return input.charAt(0) == '0' && input.charAt(1) =='1' && input.length() == 10 && input.matches("[0-9]+");
	}

	public boolean isWord(String input) {
		return Pattern.matches("[a-zA-Z]+", input);
	}


	public boolean checkusername(String input) {
//		String regex = "^[a-zA-Z0-9]+$";
		String regex = "^[a-zA-Z0-9].{6,20}+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		return matcher.find();
	}

	public boolean checkpass(String input) {
//		String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
		String regex = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,20}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		return matcher.find();
	}
	
}
