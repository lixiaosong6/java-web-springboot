package com.sale.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName ClassUtil
 * @Description: class工具类
 * @Author Serein
 * @Date 2019-12-05
 **/
public class ClassUtil {

    /**
     * @param obj
     * @MethodName: isJavaType
     * @Description: 判断是否是基本类型
     * @Return: boolean
     * @Author: Serein
     * @Date: 2019-12-05
     **/
    public static boolean isJavaType(Object obj) {
        //判断是否是基本类型
        if (obj.getClass().isPrimitive()) {
            return true;
        }

        return obj instanceof String || obj instanceof Integer || obj instanceof Long ||
                obj instanceof Double || obj instanceof Float || obj instanceof Boolean ||
                obj instanceof Byte || obj instanceof Character;
    }

    /**
     * @MethodName: isSuperClass
     * @Description:  判断class的父类是否包含packageName
     * @param clazz
     * @param packageName 包名称
     * @Return: boolean
     * @Author: Serein
     * @Date: 2019-12-08
    **/
    public static boolean isSuperClass(Class clazz, String packageName){
        Class superclass = clazz.getSuperclass();
        if (superclass == null || superclass.isAssignableFrom(Object.class)){
            return false;
        }

        if (superclass.getName().equals(packageName)){
            return true;
        } else
            return isSuperClass(superclass, packageName);
    }

    /**
     * @MethodName: getSuperClass
     * @Description:  获取指定父类Class对象
     * @param clazz
     * @param packageName 包名称
     * @Return: java.lang.Class
     * @Author: Serein
     * @Date: 2019-12-08
    **/
    public static Class getSuperClass(Class clazz, String packageName){
        Class superclass = clazz.getSuperclass();
        if (superclass == null){
            return clazz;
        }

        if (superclass.getName().equals(packageName)){
            return superclass;
        } else
            return getSuperClass(superclass, packageName);
    }

    /**
     * @MethodName: getAllFields
     * @Description:  获取class所有字段
     * @param clazz
     * @Return: java.util.List<java.lang.reflect.Field>
     * @Author: Serein
     * @Date: 2019-12-16
    **/
    public static List<Field> getAllFields(Class clazz){
        List<Field> fields = new ArrayList<>(Arrays.asList(clazz.getDeclaredFields()));
        recursiveGetFields(fields, clazz);
        return fields;
    }

    private static void recursiveGetFields(List<Field> fields, Class clazz){
        Class superclass = clazz.getSuperclass();
        if (superclass == null || superclass.isAssignableFrom(Object.class)){
            return;
        }
        fields.addAll(Arrays.asList(superclass.getDeclaredFields()));
        recursiveGetFields(fields, superclass);
    }

}
