package com.xworks.securepassword.repository;

import com.xworks.securepassword.entity.ChangePasswordEntity;
import com.xworks.securepassword.entity.UserEntity;

public interface ChangedPasswordRepository {
	public UserEntity checkByUserName( String userName);
	public boolean changePassword(ChangePasswordEntity passwordEntity);
	
	

}
