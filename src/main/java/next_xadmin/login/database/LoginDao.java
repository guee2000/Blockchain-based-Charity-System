package next_xadmin.login.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import next_xadmin.login.bean.LoginBean;
import next_xadmin.register.User;

public class LoginDao {
	
	private static String dbUrl = "jdbc:mysql://localhost:3307/blockchain-based-charity-system";
	private static String dbUname = "root";
	private static String dbPassword = "root";
	private static String dbDriver = "com.mysql.cj.jdbc.Driver";
	
	public static void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection()
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
	
	public boolean validate(LoginBean loginBean) {
		loadDriver(dbDriver);
		Connection con = getConnection();
		boolean status = false;
		String sql = "select * FROM user where user_username = ? and user_pwd=?";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, loginBean.getUsrInput());
			ps.setString(2, loginBean.getPwdInput());
		
		ResultSet rs = ps.executeQuery();
		status = rs.next();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return status;
		
	}
	
	public static int showUserId(LoginBean loginBean) 
	{
		loadDriver(dbDriver);
		Connection con = getConnection();
		int userid = 0;
		String sql2 = "select user_id from user where user_username=? and user_pwd=?";
	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql2);
			ps.setString(1, loginBean.getUsrInput());
			ps.setString(2, loginBean.getPwdInput());
		
			ResultSet rs1 = ps.executeQuery();
			while (rs1.next()) {
				userid = rs1.getInt("user_id");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return userid;
		
	}
	
	public static String showuserstate(LoginBean loginBean) 
	{
		loadDriver(dbDriver);
		Connection con = getConnection();
		String state = null;
		String sql3 = "select user_state from user where user_username=? and user_pwd=?";
	
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql3);
			ps.setString(1, loginBean.getUsrInput());
			ps.setString(2, loginBean.getPwdInput());
		
			ResultSet rs2 = ps.executeQuery();
			while (rs2.next()) {
				state = rs2.getString("user_state");
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return state;
		
	}
	

}
