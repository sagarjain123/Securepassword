package com.xworks.securepassword.util;

import java.security.SecureRandom;

import org.springframework.stereotype.Component;

@Component
public class PasswordGenerator {
 private static SecureRandom random=new SecureRandom();
     
     private static final String  ALPHA_CAPS="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
     private static final String ALPHA ="abcdefghijklmnopqrstuvwxyz";
     private static final String NUMERIC="0123456789";
     private static final String SPECIAL_CHAR="!@#$%^&*_=+-/";
     
     public static String generatePassword()
     {
    	 int length=8;
    	 String pattern=ALPHA_CAPS+ALPHA+SPECIAL_CHAR+NUMERIC;
    	 String result="";
    	 
    	 for(int i=0;i<length;i++){
    		 int index= random.nextInt(pattern.length());
    		 result=result+pattern.charAt(index);
    	 }
    	 return result;
     }

}
