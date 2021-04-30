package com.eyrockscript.recaptchav3.service;

public interface ICaptcha {

	public static final String SECRET = "secret";
	public static final String RESPONSE = "response";
	public static final String CAPTCHA_HEADER_NAME = "captcha-response";
	public static final String GOOGLE_RECAPTCHA_ENDPOINT = "https://www.google.com/recaptcha/api/siteverify";
	
}
