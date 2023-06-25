package com.sale.exception;


import com.sale.enums.ResultEnum;

public class PayException extends BaseException {

    public PayException(ResultEnum resultEnum, String message){
        super(resultEnum, message);
    }

    public PayException(ResultEnum resultEnum){
        super(resultEnum);
    }

}
