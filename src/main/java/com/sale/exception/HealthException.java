package com.sale.exception;

import com.sale.enums.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HealthException extends BaseException{
    private static final Logger log = LoggerFactory.getLogger(HealthException.class);

    public HealthException(String message) {
        super(ResultEnum.COMMON_ERROR, message);
    }
}
