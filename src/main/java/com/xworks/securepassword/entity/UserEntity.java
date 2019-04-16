package com.xworks.securepassword.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name="user_table")
@NamedQueries({@NamedQuery(name="fetchByUserName",query="from UserEntity user where user.userName=:un")})
public class UserEntity implements Serializable
{
	@Column(name="u_email")
	private String email;
	@Id
	
	@Column(name="u_userName")
	private String userName;
	
	@Column(name="u_mobileNo")
	private long mobileNo;
	
	@Column(name="u_type")
	private String type;
	
	@Column(name="u_password")
	private String password;
	
	@Column(name="u_failedLogin")
	private int failedLogin;
	
	@Column(name="u_newUser")
	private boolean newUser;
	
	@Column(name="secure_Phase")
	private String securePhase;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getFailedLogin() {
		return failedLogin;
	}
	public void setFailedLogin(int failedLogin) {
		this.failedLogin = failedLogin;
	}
	public boolean getNewUser() {
		return newUser;
	}
	public void setNewUser(boolean newUser) {
		this.newUser = newUser;
	}
	
	public String getSecurePhase() {
		return securePhase;
	}
	public void setSecurePhase(String securePhase) {
		this.securePhase = securePhase;
	}
	@Override
	public String toString() {
		return "UserEntity [email=" + email + ", userName=" + userName + ", mobileNo=" + mobileNo + ", type=" + type
				+ ", password=" + password + ", failedLogin=" + failedLogin + ", newUser=" + newUser + ", securePhase="
				+ securePhase + ", getEmail()=" + getEmail() + ", getUserName()=" + getUserName() + ", getMobileNo()="
				+ getMobileNo() + ", getType()=" + getType() + ", getPassword()=" + getPassword()
				+ ", getFailedLogin()=" + getFailedLogin() + ", getNewUser()=" + getNewUser() + ", getSecurePhase()="
				+ getSecurePhase() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	
}

