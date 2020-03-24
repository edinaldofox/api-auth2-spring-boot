package com.yoshi.api.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	public static void main(String[] args) {
		BCryptPasswordEncoder passowrdEncode = new BCryptPasswordEncoder();
		System.out.println(passowrdEncode.encode("123"));
	}

}
