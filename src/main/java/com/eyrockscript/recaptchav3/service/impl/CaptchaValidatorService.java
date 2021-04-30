package com.eyrockscript.recaptchav3.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.client.RestTemplate;

import com.eyrockscript.recaptchav3.model.CaptchaResponse;
import com.eyrockscript.recaptchav3.service.ICaptchaValidatorService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@CrossOrigin(origins = "*")
@Service
public class CaptchaValidatorService implements ICaptchaValidatorService {

    @Value("${google.recaptcha.secret}")
    private String recaptchaSecret;

	public boolean validateCaptcha(String captchaResponse){
		log.info("request validate captcha {}", captchaResponse);
        RestTemplate restTemplate = new RestTemplate();

        MultiValueMap<String, String> requestMap = new LinkedMultiValueMap<>();
        requestMap.add(SECRET, recaptchaSecret);
        requestMap.add(RESPONSE, captchaResponse);

        CaptchaResponse apiResponse = restTemplate.postForObject(GOOGLE_RECAPTCHA_ENDPOINT, requestMap, CaptchaResponse.class);
        log.info("Captcha api response {}", apiResponse);

        if(apiResponse == null){
            return false;
        }

        return Boolean.TRUE.equals(apiResponse.getSuccess());
    }

}
