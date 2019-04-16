package com.xworks.securepassword.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userCeredential_table")
public class UserCredentialEntity implements Serializable {
	
	public UserCredentialEntity() {
		System.out.println(this.getClass().getSimpleName()+"created");
	}
	@Id
	@Column(name="name")
	private String name;
	@Column(name="loggedUser")
	private String loggedUser;
	@Column(name="url")
	private String url;
	@Column(name="userId")
	private String userId;
	@Column(name="password")
	private String password;
	@Column(name="note")
	private String note;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoggedUser() {
		return loggedUser;
	}
	public void setLoggedUser(String loggedUser) {
		this.loggedUser = loggedUser;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	@Override
	public String toString() {
		return "UserCredentialEntity [name=" + name + ", loggedUser=" + loggedUser + ", url=" + url + ", userId="
				+ userId + ", password=" + password + ", note=" + note + ", getName()=" + getName()
				+ ", getLoggedUser()=" + getLoggedUser() + ", getUrl()=" + getUrl() + ", getUserId()=" + getUserId()
				+ ", getPassword()=" + getPassword() + ", getNote()=" + getNote() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
