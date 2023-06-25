package com.sale.exception;


import com.sale.enums.ResultEnum;

public class LoginException extends BaseException {

    public LoginException(ResultEnum resultEnum, String message){
        super(resultEnum, message);
    }

    public LoginException(ResultEnum resultEnum){
        super(resultEnum);
    }
}
