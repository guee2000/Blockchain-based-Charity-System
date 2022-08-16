package next_xadmin.login.bean;

import java.security.MessageDigest;

import next_xadmin.register.StringUtil;

public class LoginBean {
	private String usrInput;
	private String pwdInput;
	public String getUsrInput() {
		return hashing(usrInput);
	}
	public void setUsrInput(String usrInput) {
		this.usrInput = usrInput;
	}
	public String getPwdInput() {
		return hashing(pwdInput);
	}
	public void setPwdInput(String pwdInput) {
		this.pwdInput = pwdInput;
	}
	
	//hashing 
   public String hashing(String data) {
      data = StringUtil.applySha256(data);
      return data;
   }
	
	
	public static String applySha256(String input){
		
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        
			byte[] hash = digest.digest(input.getBytes("UTF-8"));
	        
			StringBuffer hexString = new StringBuffer(); // This will contain hash as hexidecimal
			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if(hex.length() == 1) hexString.append('0');
				hexString.append(hex);
			}
			return hexString.toString();
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}


