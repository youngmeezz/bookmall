package kr.co.itcen.bookmall.vo;

public class UserVo {
	
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "UserVo [no=" + no + ", userName=" + userName + ", phoneNumber=" + phoneNumber + ", email=" + email
				+ ", password=" + password + "]";
	}
	private Long no;
	private String userName;
	private String phoneNumber;
	private String email;
	private String password;
	
	
}
