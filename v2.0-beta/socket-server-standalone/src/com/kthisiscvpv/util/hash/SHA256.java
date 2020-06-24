package com.kthisiscvpv.util.hash;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * @author https://www.baeldung.com/sha-256-hashing-java
 */
public class SHA256 {

	public static void main(String[] args) throws Exception {
		String origin = "kThisIsCvpv";
		String hashed = encrypt(origin);
		System.out.printf("Standard: %s\nSHA-256: %s", origin, hashed);
	}

	/**
	 * Encrypts a given String using SHA-256 and returns the Base64 conversion output.
	 * @param origin The original string
	 * @return Base64 SHA-256 encrypted string
	 */
	public static String encrypt(String origin) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] originBytes = origin.getBytes(StandardCharsets.UTF_8);
			byte[] encodedBinary = digest.digest(originBytes);
			return new String(Base64.getEncoder().encode(encodedBinary));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return origin;
		}
	}
}