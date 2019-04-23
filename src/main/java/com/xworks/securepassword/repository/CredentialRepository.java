package com.xworks.securepassword.repository;

import java.util.List;

import com.xworks.securepassword.entity.UserCredentialEntity;

public interface CredentialRepository {
	public void credential(UserCredentialEntity credentialEntity);
	public List<UserCredentialEntity> fetchAllCredentialRepository(String userName);

}
