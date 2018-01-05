package com.luciano.hackerranktest.java.advanced;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class JavaMD5 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		in.close();

		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.reset();
			byte[] sBytes = s.getBytes("UTF-8");
			byte[] digestedBytes = md5.digest(sBytes);
			String hash = new BigInteger(1, digestedBytes).toString(16);
			System.out.println(hash);
		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}
}

