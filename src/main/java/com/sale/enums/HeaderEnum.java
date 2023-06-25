package com.sale.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HeaderEnum {

    TOKEN("Authorization", "登录态标识"),
    LOGIN_TYPE("LoginType", "系统登录类型"),
    LOGIN_CLIENT("login-client", "登录客户端类型"),
    USER_AGENT("User-Agent", "用户代理"),
    REQUEST_ID("request-id", "请求ID"),
    GPS_LOCATION("gps-location", "当前登录请求客户端的经纬度"),
    APPNAME("appname", "应用名称"),
    APPID("appid", "应用ID"),
    EXPORT("export", "前端页面数据导出"),
    ORIGIN("Origin", "请求的域名url")
            ;

    private String name;

    private String desc;
}
