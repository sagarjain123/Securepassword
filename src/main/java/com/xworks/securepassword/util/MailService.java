package com.xworks.securepassword.util;

import com.xworks.securepassword.entity.UserEntity;

public interface MailService {
	
	public void sendMail(UserEntity userentity);

}
