package com.xworks.securepassword.repository;

import com.xworks.securepassword.entity.LoginEntity;
import com.xworks.securepassword.entity.UserEntity;

public interface LoginRepository {
	
	public UserEntity loginRepository(LoginEntity loginEntity);

	public UserEntity getByUsername(String username);

}
