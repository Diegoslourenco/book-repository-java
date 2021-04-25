package com.gft.book.model.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Book --- represents a password hash.
 * 			based on https://www.viralpatel.net/java-md5-hashing-salting-password/
 * @author    Diego da Silva Lourenco
 */

public class PasswordHash {
	
	private static final String salt = "asdf";
	
	public static String getHash(String password) {
		
		String hash = null;
		String saltedPassword = applySalt(password);
		
		if (null == password) {
			return null;
		}
		
		try {
			// Create MessageDigest object for MD5
			MessageDigest digest = MessageDigest.getInstance("MD");
			
			// Update input string in message digest
			digest.update(saltedPassword.getBytes(), 0, saltedPassword.length());
			
			// Convert message digest value in base 16 (hex)
			hash = new BigInteger(1, digest.digest()).toString(16);
		} catch (NoSuchAlgorithmException error) {
			error.printStackTrace();
		}
		
		return hash;
	}
	
	private static String applySalt(String password) {
		return password + salt;
	}

	public static boolean isValidPassword(String password, String hash) {
		
		String hashedPassword = getHash(password);
		return hashedPassword.equals(hash);
	}
}
