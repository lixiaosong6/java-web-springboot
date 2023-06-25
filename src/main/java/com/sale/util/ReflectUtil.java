package com.sale.util;

import java.lang.reflect.Method;

/**
 * @ClassName ReflectUtil
 * @Description: 反射工具类
 * @Author Serein
 * @Date 2019-12-09
 **/
public class ReflectUtil {

    public static Method getMethod(Object obj, String methodName) throws NoSuchMethodException {
        if (obj == null){
            throw new NullPointerException("reflect object can not be null");
        }
        Class<?> objClass = obj.getClass();
        return objClass.getMethod(methodName);
    }

    /**
     * @MethodName: getGetterMethod
     * @Description:  获取getter方法
     * @param obj
     * @param filedName
     * @Return: java.lang.reflect.Method
     * @Author: Serein
     * @Date: 2019-12-10
    **/
    public static Method getGetterMethod(Object obj, String filedName) throws NoSuchMethodException {
        return getMethod(obj, convertGetMethodName(filedName));
    }

    /**
     * @MethodName: getSetterMethod
     * @Description:  获取setter方法
     * @param obj
     * @param filedName
     * @Return: java.lang.reflect.Method
     * @Author: Serein
     * @Date: 2019-12-10
    **/
    public static Method getSetterMethod(Object obj, String filedName) throws NoSuchMethodException {
        return getMethod(obj, convertSetMethodName(filedName));
    }


    private static String convertGetMethodName(String methodName){
        return convertMethodName("get", methodName);
    }

    private static String convertSetMethodName(String methodName){
        return convertMethodName("set", methodName);
    }

    private static String convertMethodName(String prefix, String methodName){
        String firstStr = methodName.substring(0, 1);
        return prefix + methodName.replaceFirst(firstStr, firstStr.toUpperCase());
    }
}
