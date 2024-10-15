package com.sample;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Encoder;

public class PwdUtils {
	static String plainText = "Mukund@#123";

	public static void main(String[] args) throws NoSuchAlgorithmException {
		System.out.println("Original Text String::" + plainText);
		String encodeString = encryptData(plainText);
		System.out.println("Encoded + Digested Text :: " + encodeString);
	}

	/**
	 * This method is used to encrypt data
	 * 
	 * @param text
	 * @return String
	 */
	public static String encryptData(String text) throws NoSuchAlgorithmException {
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		messageDigest.reset();
		messageDigest.update(text.getBytes());
		byte[] digestArray = messageDigest.digest();
		System.out.println("Digested Text :: " + new String(digestArray));

		Encoder encoder = Base64.getEncoder();
		byte[] encoderDigestArray = encoder.encode(digestArray);
		String encoderString = new String(encoderDigestArray);
		return encoderString;
	}
}
