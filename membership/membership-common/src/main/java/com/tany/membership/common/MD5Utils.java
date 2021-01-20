package com.tany.membership.common;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Base64;

public class MD5Utils {
	public static String getMD5Str(String strValue) {
		String newstr = "";
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			newstr = Base64.encodeBase64String(md5.digest(strValue.getBytes()));
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		return newstr;
	}

	public static void main(String[] args) {
		try {
			String md5 = getMD5Str("sjhlco");
			System.out.println(md5);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
