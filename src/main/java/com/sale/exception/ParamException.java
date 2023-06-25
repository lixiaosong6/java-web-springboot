package com.sale.exception;

import com.sale.enums.ResultEnum;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ParamException extends BaseException {

    public ParamException(String message){
        super(ResultEnum.PARAM_ERROR, message);
    }

}
