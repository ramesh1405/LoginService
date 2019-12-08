package com.rest.validator;

public class AuthValidator {
	public static boolean isValid(String un, String pwd) {
		boolean flag = false;
		if ("raj".equalsIgnoreCase(un) && "raj".equals(pwd)) {

			flag = true;
		}
		if ("ram".equalsIgnoreCase(un) && "ram".equals(pwd)) {

			flag = true;
		}
		return flag;
	}
}
