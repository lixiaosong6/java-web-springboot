package com.sale.exception;

import com.sale.enums.ResultEnum;
import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {

    private ResultEnum resultEnum;

    public BaseException(ResultEnum resultEnum, String message){
        super(message);
        this.resultEnum = resultEnum;
    }

    public BaseException(ResultEnum resultEnum){
        super(resultEnum.getDesc());
        this.resultEnum = resultEnum;
    }
}
