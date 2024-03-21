package test.user;
import java.io.*;
@SuppressWarnings("serial")
public class UserBean implements Serializable{
	private String userName,password,firstName,lastName,address,email_Id;
	private long phonoNo;
	
	public UserBean()
	{
		
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail_Id() {
		return email_Id;
	}

	public void setEmail_Id(String email_Id) {
		this.email_Id = email_Id;
	}

	public long getPhonoNo() {
		return phonoNo;
	}

	public void setPhonoNo(long phonoNo) {
		this.phonoNo = phonoNo;
	}
	
}
