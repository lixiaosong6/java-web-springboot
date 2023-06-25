package com.sale.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @ClassName ResultEnum
 * @Description: 错误字段
 * @Author Serein
 * @Date 2019-12-07
 **/
@Getter
@AllArgsConstructor
public enum ResultEnum {

    SUCCESS(1, "成功"),
    ERROR(-1, "系统异常"),
    COMMON_ERROR(-2, "业务通用错误"),
    COMMON_PARAM_ERROR(-3, "请求参数错误"),

    /*
      业务错误代码 1001 ~ 1099
     */
    ADD_ERROR(1001, "新增失败"),
    DEL_ERROR(1002, "删除失败"),
    UPDATE_ERROR(1003, "编辑失败"),
    QUERY_ERROR(1004, "查询失败"),
    PARAM_ERROR(1005, "参数错误"),


    /*
      系统异常
     */
    SYSTEM_RELOGIN(9000, "重新登录"),
    TOKEN_EXPIRED(9010, "token已过期，请重新获取"),
    TOKEN_ERROR(9011, "token不合法"),
    TOKEN_INVALID(9012, "token已失效"),

    /*
      系统错误
     */
    SYSTEM_HYSTRIX(10000, "系统异常，请管理员检查系统运行状态");

    private Integer code;

    private String desc;


}
