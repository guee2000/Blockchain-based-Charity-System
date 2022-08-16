package next_xadmin.selectcharity.charity;
import java.util.Date;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.text.SimpleDateFormat;


public class Block  {
	
	private String project_id;
	public String hash;
	String previousHash;
	private long amount;
	Date date = new Date();
	int projectBlock;
	int user_id;
	String state;
    


//    public String projectId = getProjectId();
//    public String currentHash = getHash();
//    public long AmountInput = getAmountInput();
//    public String previous_hash = getPrevhash();
//    public Date date1 = time();
//	public int block = getProjectblock();
    public int block;
    
    
    public Block() {
		super();
	}
    // Constructor for Block
    public Block(String project_id,Long amount, int user_id, String state) {
//    public Block(String project_id,Long amount) {
    	super();
        this.project_id = project_id;
        this.hash = getHash();
        this.previousHash = getPrevhash();
        this.amount = amount;
        this.date = new Timestamp(date.getTime());
        this.projectBlock = getProjectblock();  
        this.user_id = user_id; 
        this.state = state;


    }

	public String getProjectId() {
		return project_id;
	}
	public void setProjectId(String project_id) {
		this.project_id = project_id;
	}

	public String getHash() {
	
        String calculatedhash = StringUtil.applySha256(project_id +previousHash + date + Long.toString(amount) + Integer.toString(user_id)+ state + Integer.toString(projectBlock));
        return calculatedhash;
	}
	
	 public String getPrevhash(){
	        //select from db
			int countt;
	        try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3307/blockchain-based-charity-system", "root", "root")) {
				// "jdbc:mysql://mysql14.000webhost.com/id18522466_blockchainbasedcharitysystem", "id18522466_root", "Jiansing.0530")) {
	   
				if (conn != null) {
					System.out.println("Connected to the database!");
		
					//select from db
					Statement stmt = conn.createStatement();
					ResultSet rs;

					PreparedStatement statement = conn.prepareStatement("select count(project_id) from transaction where project_id =?");
					statement.setString(1, getProjectId());
					rs = statement.executeQuery();

					while (rs.next()){
						countt = rs.getInt("count(project_id)");
						
					if (countt <1 ){
						previousHash = "0";
						System.out.println(previousHash);
						return previousHash;
					}
					else{
						//to retrieve the latest project block from db
						PreparedStatement statementsss = conn.prepareStatement("select project_block from transaction where project_id =?");
						statementsss.setString(1, getProjectId());
						ResultSet ars = statementsss.executeQuery();
						while (ars.next()){
							countt = ars.getInt("project_block");
							
						}
						PreparedStatement statements = conn.prepareStatement("select current_hash from transaction where project_id =? and project_block =?");
						statements.setString(1, getProjectId() );
						statements.setInt(2, countt);
						System.out.println(getProjectId());
						System.out.println(countt);
						ResultSet rrs = statements.executeQuery();
						
						while ( rrs.next() ) {
							// previous hash for new block
							String new_previoushash = rrs.getString("current_hash");
							return new_previoushash;
						}
					}
				}   
				}
				else {
					System.out.println("Failed to make connection!");
				}
	   
			} catch (SQLException e) {
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return previousHash;
	    }

		public long getAmountInput() {
			return amount;
		}
		public void setAmountInput(long amount) {
			this.amount = amount;
		}
	 
//    public Timestamp time() {
//    	Timestamp ttime = new Timestamp(date.getTime());
//		return ttime;
//    }
    
    public int getProjectblock() {
		//select from db
		int blockcount;
        try (Connection conn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3307/blockchain-based-charity-system", "root", "root")) {
			// "jdbc:mysql://mysql14.000webhost.com/id18522466_blockchainbasedcharitysystem", "id18522466_root", "Jiansing.0530")) {
   
			if (conn != null) {
				System.out.println("Connected to the database!");
	
				//select from db
				Statement stmt = conn.createStatement();
				ResultSet rs;

				PreparedStatement statement = conn.prepareStatement("select count(project_id) from transaction where project_id =?");
				statement.setString(1, getProjectId());
				rs = statement.executeQuery();

				while (rs.next()){
					blockcount = rs.getInt("count(project_id)");
					blockcount++;
					// System.out.println(blockcount);
					return blockcount;
				}   
			}
			else {
				System.out.println("Failed to make connection!");
			}
   
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return block;

	}
    public int getUserId() {
		return user_id;
	}
	public void setUserId(int user_id) {
		this.user_id = user_id;
	}

    public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
//	public String getEmailInput() {
//		return emailInput;
//	}
//
//	public void setEmailInput(String emailInput) {
//		this.emailInput = emailInput;
//	}

}

