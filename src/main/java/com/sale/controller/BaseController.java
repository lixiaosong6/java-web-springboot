package com.sale.controller;


import com.sale.entity.ResultEntity;
import com.sale.enums.ResultEnum;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

@Slf4j
public abstract class BaseController {

    public final ResultEntity success(){
        return new ResultEntity(ResultEnum.SUCCESS);
    }

    public final ResultEntity success(String message){
        return new ResultEntity(ResultEnum.SUCCESS, message);
    }

    public final <T> ResultEntity success(T data){
        return new ResultEntity<>(ResultEnum.SUCCESS, data);
    }

    public final <T> ResultEntity success(T data, String message){
        return new ResultEntity<>(ResultEnum.SUCCESS, data, message);
    }

    public final ResultEntity error(ResultEnum resultEnum){
        return new ResultEntity(resultEnum);
    }

    public final <T> ResultEntity error(ResultEnum resultEnum, T data){
        return new ResultEntity<>(resultEnum, data);
    }

    public final ResultEntity error(ResultEnum resultEnum, String message){
        return new ResultEntity(resultEnum, message);
    }

    public final ResultEntity paramError(String message){
        return error(ResultEnum.PARAM_ERROR, message);
    }

    public final Map<String, Object> convertMap(String column, Object value){
        Map<String, Object> data = new HashMap<>(1);
        data.put(column, value);
        return data;
    }
}
