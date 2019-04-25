package com.xworks.securepassword.service;

import java.util.List;

import com.xworks.securepassword.entity.UserCredentialEntity;

public interface CredentialService {
	
	public void credential(UserCredentialEntity credentialentity);
	public List<UserCredentialEntity> fetchAllCredentialService(String userName);
    public UserCredentialEntity editCredentialService(String name,String user);
}
