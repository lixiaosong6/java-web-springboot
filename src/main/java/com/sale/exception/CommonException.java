package com.sale.exception;

import com.sale.entity.ResultEntity;
import com.sale.enums.ResultEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommonException extends BaseException {
    private static final Logger log = LoggerFactory.getLogger(CommonException.class);

    private ResultEntity resultEntity;

    public CommonException(String message) {
        super(ResultEnum.COMMON_ERROR, message);
    }

    public CommonException(ResultEnum resultEnum) {
        super(resultEnum);
    }

    public CommonException(ResultEnum resultEnum, String message) {
        super(resultEnum, message);
    }

}
