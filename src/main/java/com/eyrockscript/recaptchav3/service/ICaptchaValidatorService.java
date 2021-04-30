package com.eyrockscript.recaptchav3.service;

public interface ICaptchaValidatorService extends ICaptcha {
	
	public boolean validateCaptcha(String captchaResponse);
	
}