package next_xadmin.register;

public class User {
	private String usrInput, fnameInput, lnameInput, stateInput, phonenumInput, emailInput, pwdInput;

	public User() {
		super();
	}

	public User(String usrInput, String fnameInput, String lnameInput, String stateInput, String phonenumInput,
			String emailInput, String pwdInput) {
		super();
		this.usrInput = hashing(usrInput);
		this.fnameInput = hashing(fnameInput);
		this.lnameInput = hashing(lnameInput);
		this.stateInput = stateInput;
		this.phonenumInput = hashing(phonenumInput);
		this.emailInput = hashing(emailInput);
		this.pwdInput = hashing(pwdInput);
	}

	public String getUsrInput() {
		return usrInput;
	}

	public void setUsrInput(String usrInput) {
		this.usrInput = usrInput;
	}

	public String getFnameInput() {
		return fnameInput;
	}

	public void setFnameInput(String fnameInput) {
		this.fnameInput = fnameInput;
	}

	public String getLnameInput() {
		return lnameInput;
	}

	public void setLnameInput(String lnameInput) {
		this.lnameInput = lnameInput;
	}

	public String getStateInput() {
		return stateInput;
	}

	public void setStateInput(String stateInput) {
		this.stateInput = stateInput;
	}

	public String getPhonenumInput() {
		return phonenumInput;
	}

	public void setPhonenumInput(String phonenumInput) {
		this.phonenumInput = phonenumInput;
	}

	public String getEmailInput() {
		return emailInput;
	}

	public void setEmailInput(String emailInput) {
		this.emailInput = emailInput;
	}

	public String getPwdInput() {
		return pwdInput;
	}

	public void setPwdInput(String pwdInput) {
		this.pwdInput = pwdInput;
	}
	
	//hashing 
   public String hashing(String data) {
      data = StringUtil.applySha256(data);
      return data;
   }
}
