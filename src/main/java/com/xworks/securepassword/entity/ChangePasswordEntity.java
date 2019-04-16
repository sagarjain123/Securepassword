package com.xworks.securepassword.entity;

import java.io.Serializable;

public class ChangePasswordEntity  implements Serializable{
	
	private String userName;
	private String oldPassword;
	private String newPassword;
    private String confirmPassword;
    private String securePhase;
    
    public ChangePasswordEntity() {
		System.out.println(this.getClass().getSimpleName()+"created");
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getSecurePhase() {
		return securePhase;
	}

	public void setSecurePhase(String securePhase) {
		this.securePhase = securePhase;
	}

	@Override
	public String toString() {
		return "ChangePasswordEntity [userName=" + userName + ", oldPassword=" + oldPassword + ", newPassword="
				+ newPassword + ", confirmPassword=" + confirmPassword + ", securePhase=" + securePhase
				+ ", getUserName()=" + getUserName() + ", getOldPassword()=" + getOldPassword() + ", getNewPassword()="
				+ getNewPassword() + ", getConfirmPassword()=" + getConfirmPassword() + ", getSecurePhase()="
				+ getSecurePhase() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
    
    
}
