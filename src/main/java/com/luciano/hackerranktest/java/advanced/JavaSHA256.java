package com.luciano.hackerranktest.java.advanced;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class JavaSHA256 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		in.close();

		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] digestedBytes = digest.digest(s.getBytes(StandardCharsets.UTF_8));
			String hash = String.format("%064x", new BigInteger(1, digestedBytes));
			System.out.println(hash);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
