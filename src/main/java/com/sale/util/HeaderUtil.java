package com.sale.util;

import com.sale.enums.HeaderEnum;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName HeaderUtil
 * @Description: 请求头工具类
 * @Author Serein
 * @Date 2019-12-07
 **/
public class HeaderUtil {

    /**
     * @MethodName: getToken
     * @Description:  获取请求头 token
     * @Return: java.lang.String
     * @Author: Serein
     * @Date: 2019-12-07
    **/
    public static String getToken(){
        HttpServletRequest request = HttpHelper.getRequest();
        if (request != null) {
            return request.getHeader(HeaderEnum.TOKEN.getName());
        }
        return null;
    }

    /**
     * @MethodName: getLoginType
     * @Description:  获取登录类型
     * @Return: java.lang.String
     * @Author: Serein
     * @Date: 2019-12-09
    **/
    public static String getLoginType(){
        HttpServletRequest request = HttpHelper.getRequest();
        return request.getHeader(HeaderEnum.LOGIN_TYPE.getName());
    }

    /**
     * @MethodName: getLoginIp
     * @Description:  获取登录Ip
     * @Return: java.lang.String
     * @Author: wangjian
     * @Date: 2020-04-26
     **/
    public static String getClientIp() {
        HttpServletRequest request = HttpHelper.getRequest();

        String ip = "";

        //X-Forwarded-For：Squid 服务代理
        String ipAddresses = request.getHeader("X-Forwarded-For");
        String unknown = "unknown";
        if (ipAddresses == null || ipAddresses.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
            //Proxy-Client-IP：apache 服务代理
            ipAddresses = request.getHeader("Proxy-Client-IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
            //WL-Proxy-Client-IP：weblogic 服务代理
            ipAddresses = request.getHeader("WL-Proxy-Client-IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
            //HTTP_CLIENT_IP：有些代理服务器
            ipAddresses = request.getHeader("HTTP_CLIENT_IP");
        }

        if (ipAddresses == null || ipAddresses.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
            //X-Real-IP：nginx服务代理
            ipAddresses = request.getHeader("X-Real-IP");
        }

        //有些网络通过多层代理，那么获取到的ip就会有多个，一般都是通过逗号（,）分割开来，并且第一个ip为客户端的真实IP
        if (ipAddresses != null && ipAddresses.length() != 0) {
            ip = ipAddresses.split(",")[0];
        }

        //还是不能获取到，最后再通过request.getRemoteAddr();获取
        if (ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ipAddresses)) {
            ip = request.getRemoteAddr();
        }

        return ip;
    }

    /**
     * @MethodName: getLoginClient
     * @Description:  获取登录客户端
     * @Return: java.lang.String
     * @Author: wangjian
     * @Date: 2020-04-26
     **/
    public static String getLoginClient(){
        HttpServletRequest request = HttpHelper.getRequest();
        return request.getHeader(HeaderEnum.LOGIN_CLIENT.getName());
    }

    public static String getAppId(){
        HttpServletRequest request = HttpHelper.getRequest();
        return request.getHeader(HeaderEnum.APPID.getName());
    }

    public static String getAppName(){
        HttpServletRequest request = HttpHelper.getRequest();
        return request.getHeader(HeaderEnum.APPNAME.getName());
    }

    public static String getRequestId(){
        HttpServletRequest request = HttpHelper.getRequest();
        return request.getHeader(HeaderEnum.REQUEST_ID.getName());
    }

    public static String getUserAgent(){
        HttpServletRequest request = HttpHelper.getRequest();
        return request.getHeader(HeaderEnum.USER_AGENT.getName());
    }

    public static String getExport(){
        HttpServletRequest request = HttpHelper.getRequest();
        return request.getHeader(HeaderEnum.EXPORT.getName());
    }

    public static String getGpsLocation(){
        HttpServletRequest request = HttpHelper.getRequest();
        return request.getHeader(HeaderEnum.GPS_LOCATION.getName());
    }

    public static String getOrigin(){
        HttpServletRequest request = HttpHelper.getRequest();
        return request.getHeader(HeaderEnum.ORIGIN.getName());
    }
}
