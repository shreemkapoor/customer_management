package ems.utils;

import java.security.MessageDigest;

public class PassEncryption { // utility to encrypt password.

	public static String encrypt(String userPwd)
	{
		String passwordToHash = userPwd;
			try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(passwordToHash.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            userPwd=sb.toString();
			}
			catch(Exception e)
			{
				System.out.print(e);
			}
		
		return userPwd;
	}
	
}
