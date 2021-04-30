package com.eyrockscript.recaptchav3.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.eyrockscript.recaptchav3.exception.ForbiddenException;
import com.eyrockscript.recaptchav3.service.ICaptcha;
import com.eyrockscript.recaptchav3.service.ICaptchaValidatorService;

@Aspect
@Component
public class CaptchaAspect {

    @Autowired
    private ICaptchaValidatorService captchaValidator;

    @Around("@annotation(RequiresCaptcha)")
    public Object validateCaptcha(ProceedingJoinPoint joinPoint) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String captchaResponse = request.getHeader(ICaptcha.CAPTCHA_HEADER_NAME);
        boolean isValidCaptcha = captchaValidator.validateCaptcha(captchaResponse);
        if(!isValidCaptcha){
            throw new ForbiddenException("Invalid captcha");
        }
        return joinPoint.proceed();
    }

}