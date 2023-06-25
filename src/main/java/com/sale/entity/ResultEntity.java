package com.sale.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sale.enums.ResultEnum;
import com.sale.util.ClassUtil;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@SuppressWarnings("unchecked")
public class ResultEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int flag;

    private String message;

    private T data = (T) new HashMap<>();

    public ResultEntity(ResultEnum resultEnum, T data, String message){
        this.flag = resultEnum.getCode();
        this.message = message;

        if (data != null){
            if (ClassUtil.isJavaType(data)){
                data = (T) toSimpleMap(data);
            }
            this.data = data;
        }
    }

    public ResultEntity(ResultEnum resultEnum, T data){
        this.flag = resultEnum.getCode();
        this.message = resultEnum.getDesc();

        if (data != null){
            if (ClassUtil.isJavaType(data)){
                data = (T) toSimpleMap(data);
            }
            this.data = data;
        }
    }

    public ResultEntity(ResultEnum resultEnum){
        this.flag = resultEnum.getCode();
        this.message = resultEnum.getDesc();
    }

    public ResultEntity(ResultEnum resultEnum, String message){
        this.flag = resultEnum.getCode();
        this.message = message;
    }

    @JsonIgnore
    public boolean isSuccess(){
        return this.flag == ResultEnum.SUCCESS.getCode();
    }

    private Map<String, Object> toSimpleMap(Object obj){
        Map<String, Object> data = new HashMap<>(1);
        data.put("data", obj);
        return data;
    }
}
