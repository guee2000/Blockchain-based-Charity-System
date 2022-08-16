package next_xadmin.selectcharity.charity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CharityDao {
	
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
	
	
	
	public String insert(Block block) 
	{
		loadDriver(dbDriver);
		Connection con = getConnection();
		String result = "Transaction is successful!";
		String sql = " insert into transaction (project_id, current_hash,prev_hash,amount,timestamp,project_block,user_id,user_state)"+" values (?,?,?,?,?,?,?,?)";
//		String sql = " insert into transaction (project_id, current_hash,prev_hash,amount,timestamp,project_block)"+" values (?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, block.getProjectId());
		ps.setString(2, block.hash);
		ps.setString(3, block.previousHash);
		ps.setLong(4, block.getAmountInput());
//		ps.setTimestamp(5, (Timestamp) block.date1 );
		ps.setTimestamp(5, (Timestamp) block.date );
		ps.setInt(6, block.projectBlock);
		ps.setInt(7, block.user_id);
		ps.setString(8, block.state);
		ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "Transaction is not successful!";
		}
		
		return result;
	}
	
	public String showreceipt(Block block) 
	{
		loadDriver(dbDriver);
		Connection con = getConnection();
		String result = "Transaction is successful!";
		String sql = " insert into transaction (project_id, current_hash,prev_hash,amount,timestamp,project_block,user_id,user_state)"+" values (?,?,?,?,?,?,?,?)";
//		String sql = " insert into transaction (project_id, current_hash,prev_hash,amount,timestamp,project_block)"+" values (?,?,?,?,?,?)";
		PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, block.getProjectId());
		ps.setString(2, block.hash);
		ps.setString(3, block.previousHash);
		ps.setLong(4, block.getAmountInput());
//		ps.setTimestamp(5, (Timestamp) block.date1 );
		ps.setTimestamp(5, (Timestamp) block.date );
		ps.setInt(6, block.projectBlock);
		ps.setInt(7, block.user_id);
		ps.setString(8, block.state);
		ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "Transaction is not successful!";
			
		}
		
		return result;
	}
	
	
	
}

