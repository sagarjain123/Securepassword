package com.xworks.securepassword.service;

import com.xworks.securepassword.entity.LoginEntity;
import com.xworks.securepassword.entity.UserEntity;

public interface LoginService {
      public UserEntity loginService(LoginEntity loginEntity);
      public UserEntity getByUsername(String username);
}
