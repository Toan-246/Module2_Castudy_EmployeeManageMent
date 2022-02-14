package com.codegym.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserCheck {
    private static Pattern pattern;
    private static Matcher matcher;

    private static final String EMAIL_REGEX =   "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String PHONE_REGEX =   "^[0](\\+\\d{1,3}\\s?)?((\\(\\d{3}\\)\\s?)|(\\d{3})(\\s|-?))(\\d{3}(\\s|-?))(\\d{3})(\\s?(([E|e]xt[:|.|]?)|x|X)(\\s?\\d+))?";

    public UserCheck() {
    }
    public boolean emailValidate (String email){
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public boolean phoneNumValidate (String phoneNum){
        pattern = Pattern.compile(PHONE_REGEX);
        matcher = pattern.matcher(phoneNum);
        return matcher.matches();
    }
}
