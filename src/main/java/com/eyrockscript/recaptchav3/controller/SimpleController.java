package com.eyrockscript.recaptchav3.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eyrockscript.recaptchav3.aspect.RequiresCaptcha;
import com.eyrockscript.recaptchav3.model.SimpleRequest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class SimpleController {

	@RequiresCaptcha
	@CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/simple-request")
    public @ResponseBody SimpleRequest simpleRequest( @RequestBody SimpleRequest request ) {
		log.info("Request: {} ", request);
        return request;
    }
	
}
