package com.sale.util;

import org.apache.shiro.codec.Base64;

public class PasswordUtil {

    public static String getPlainPassword(String encryPassword) {
        String password     = "";
        Integer startIndex  = 0;
        try {
            password = new String(Base64.decode(encryPassword.getBytes("utf-8")));
            startIndex = Integer.valueOf(password.substring(password.length()-1));
            password = password.substring(0, password.length()-1);
        }
        catch (Exception e) {
            return "";
        }

        if (password.length() <= startIndex) {
            return "";
        }

        String realPassword = "";
        for (int index = startIndex; index < password.length();) {
            realPassword += password.substring(index, index+1);
            index += 2;
        }
        return realPassword;
    }

}
