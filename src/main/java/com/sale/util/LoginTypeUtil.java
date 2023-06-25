package com.sale.util;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName LoginTypeUtil
 * @Description: 登录类型工具类
 * @Author Serein
 * @Date 2019-12-05
 **/
public class LoginTypeUtil {

    /*
      帐套类型
     */
    public static final String BOOK_TYPE = "book";
    public static final Integer BOOK_VALUE = 1;

    /*
      供应商类型
     */
    public static final String SUPPLIER_TYPE = "supplier";
    public static final Integer SUPPLIER_VALUE = 2;

    /*
      承运商类型
     */
    public static final String CARRIER_TYPE = "carrier";
    public static final Integer CARRIER_VALUE = 3;

    /*
      会员类型
     */
    public static final String MEMBER_TYPE = "member";
    public static final Integer MEMBER_VALUE = 4;

    /*
      顾客类型
     */
    public static final String CUSTOMER_TYPE = "customer";
    public static final Integer CUSTOMER_VALUE = 5;


    /*
      用户类型
     */
    public static final String USER_TYPE = "user";
    public static final Integer USER_VALUE = 6;


    /*
       erp用户类型
     */
    public static final String ERP_USER_TYPE = "user";
    public static final Integer ERP_USER_VALUE = 1;


    /*
      erp顾客类型
     */
    public static final String ERP_CUSTOMER_TYPE = "customer";
    public static final Integer ERP_CUSTOMER_VALUE = 2;

    /*
       erp供应商类型
     */
    public static final String ERP_PROVIDER_TYPE = "provider";
    public static final Integer ERP_PROVIDER_VALUE = 3;

    /*
      类型List
    */
    public static List<String> typeHeaders = Arrays.asList(CUSTOMER_TYPE, SUPPLIER_TYPE, MEMBER_TYPE, CARRIER_TYPE, BOOK_TYPE);

    /*
      erp类型List
     */
    public static List<String> erpTypeHeaders = Arrays.asList(ERP_CUSTOMER_TYPE, ERP_PROVIDER_TYPE, ERP_USER_TYPE);

    /*
      当前业务用户类型
     */
    public static List<String> loginTypeHeaders = Arrays.asList(USER_TYPE, CUSTOMER_TYPE, ERP_PROVIDER_TYPE, CARRIER_TYPE, SUPPLIER_TYPE);

    /**
     * @MethodName: convertValue
     * @Description:  转换value
     * @param typeName 类型
     * @Return: java.lang.Integer
     * @Author: Serein
     * @Date: 2019-12-08
    **/
    public static Integer convertValue(String typeName){
        switch (typeName){
            case BOOK_TYPE:
                return BOOK_VALUE;
            case SUPPLIER_TYPE:
                return SUPPLIER_VALUE;
            case CARRIER_TYPE:
                return CARRIER_VALUE;
            case MEMBER_TYPE:
                return MEMBER_VALUE;
            case CUSTOMER_TYPE:
                return CUSTOMER_VALUE;
                default: return 0;
        }
    }
}
