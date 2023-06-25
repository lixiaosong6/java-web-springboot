package com.sale.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

/**
 * @ClassName HttpHelper
 * @Description: 请求工具类
 * @Author Serein
 * @Date 2019-12-05
 **/
@Slf4j
public class HttpHelper {

    /**
     * @MethodName: getSession
     * @Description:  获取session容器
     * @param
     * @Return: javax.servlet.http.HttpSession
     * @Author: Serein
     * @Date: 2019-12-05
    **/
    public static HttpSession getSession() {
        HttpServletRequest request = getRequest();
        return request == null ? null : request.getSession();
    }

    /**
     * @MethodName: getRequest
     * @Description:  获取request容器
     * @param
     * @Return: javax.servlet.http.HttpServletRequest
     * @Author: Serein
     * @Date: 2019-12-05
    **/
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.
                getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }

    /**
     * @MethodName: getResponse
     * @Description:  获取response容器
     * @param
     * @Return: javax.servlet.http.HttpServletResponse
     * @Author: Serein
     * @Date: 2019-12-05
    **/
    public static HttpServletResponse getResponse() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.
                getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getResponse();
    }

    public static String getBodyString() {
        StringBuilder sb = new StringBuilder();
        InputStream inputStream = null;
        BufferedReader reader = null;
        try {
            inputStream = getRequest().getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return sb.toString();
    }

    /**
     * @MethodName: getIpAddr
     * @Description:  获取ip地址
     * @param
     * @Return: java.lang.String
     * @Author: Serein
     * @Date: 2019-12-05
    **/
    public static String getIpAddr() {
        HttpServletRequest request = HttpHelper.getRequest();
        String ipAddress = request.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = request.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                //根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }
        }
        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) { //"***.***.***.***".length() = 15
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }

}
