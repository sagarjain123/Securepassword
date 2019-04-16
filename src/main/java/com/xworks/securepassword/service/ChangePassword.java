package com.xworks.securepassword.service;

import com.xworks.securepassword.entity.ChangePasswordEntity;

public interface ChangePassword {
	 public boolean findByUserName(String userName);
	 public boolean changePassword(ChangePasswordEntity passwordEntity);
	//public void changePasswordByUser(ChangePasswordEntity passwordEntity);

}
