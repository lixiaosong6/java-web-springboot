package com.sale.controller;

import com.sale.entity.ResultEntity;
import com.sale.enums.ResultEnum;
import com.sale.exception.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>Title: ExceptionController</p>
 * <p>Description: 统一异常处理类 </p>
 * <p>Copyright: Xi An BestTop Technologies, ltd. Copyright(c) 2018/p>
 * @author  coeus
 * @version 0.0.1
 * <pre>Histroy:
 *       2019/11/12 0012 11:11 Create by coeus
 *</pre>
*/
@Slf4j
@ResponseBody
@ControllerAdvice
public class ExceptionController {

    /**
     * @methodName exception
     * @description 处理未知异常
     * @param e
     * @return com.besttop.common.model.ResultEntity
     * @author coeus
     * @date 2019/11/12 0012 11:19
     */
    @ExceptionHandler(Exception.class)
    public ResultEntity exception(Exception e){
        log.error("系统发生未知异常: ", e);
        if (StringUtils.isNotBlank(e.getMessage())) {
            String result = exceptionIsMysql(e.getMessage());
            if (StringUtils.isNotBlank(result)) {
                return new ResultEntity(ResultEnum.ERROR,  String.format("数据库操作异常(%s)", result));
            }
            else {
                return new ResultEntity(ResultEnum.ERROR, e.getMessage());
            }
        }
        return new ResultEntity(ResultEnum.ERROR);
    }

    String exceptionIsMysql(String message) {
        if (message.contains("SQLIntegrityConstraintViolationException")) {
            return "键值重复";
        }
        if (message.contains("MyBatisSystemException")) {
            return "框架处理";
        }
        if (message.contains("java.sql.SQLException")) {
            return "sql出错";
        }
        if (message.contains("jdbc.exceptions.MySQLQueryInterruptedException")) {
            return "数据库高负载，您的请求已被限流，请稍后再试";
        }

        if (message.contains("org.apache.ibatis.executor")) {
            if (message.contains("Duplicate entry")) {
                return "键值重复";
            }
            return "sql出错";
        }

        return "";
    }

    /**
     * @methodName nullPointerException
     * @description 处理空指针抛出的异常
     * @param e
     * @return com.besttop.common.model.ResultEntity
     * @author wangjian
     * @date 2021/01/05 15:50
     */
    @ExceptionHandler(NullPointerException.class)
    public ResultEntity nullPointerException(NullPointerException e){
        log.error("空指针异常: ", e);
        return new ResultEntity(ResultEnum.ERROR, "系统异常(空指针)");
    }

    /**
     * @methodName methodArgumentNotValidException
     * @description 处理 @Validated 抛出的异常
     * @param e
     * @return com.besttop.common.model.ResultEntity
     * @author coeus
     * @date 2019/11/12 0012 11:11
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultEntity methodArgumentNotValidException(MethodArgumentNotValidException e){
        BindingResult bindingResult = e.getBindingResult();
        log.error("方法参数无效异常: ", e);
        return new ResultEntity(ResultEnum.PARAM_ERROR, bindingResult.getFieldError().getDefaultMessage());
    }

    /**
     * @methodName paramException
     * @description 处理参数不合法异常 (@Validated 无法校验的参数)
     * @param e
     * @return com.besttop.common.model.ResultEntity
     * @author coeus
     * @date 2019/11/12 0012 11:14
     */
    @ExceptionHandler(ParamException.class)
    public ResultEntity paramException(ParamException e){
        log.error("参数异常: ", e);
        return new ResultEntity(e.getResultEnum(), e.getMessage());
    }

    /**
     * @methodName loginException
     * @description 登录异常
     * @param e
     * @return com.besttop.common.model.ResultEntity
     * @author coeus
     * @date 2019/11/14 0014 11:09
     */
    @ExceptionHandler(LoginException.class)
    public ResultEntity loginException(LoginException e){
        return new ResultEntity(e.getResultEnum(), e.getMessage());
    }

    /**
     * @methodName payException
     * @description 支付异常
     * @param e
     * @return com.besttop.common.model.ResultEntity
     * @author wangjian
     * @date 2020/04/20 0014 11:09
     */
    @ExceptionHandler(PayException.class)
    public ResultEntity payException(PayException e){
        return new ResultEntity(e.getResultEnum(), e.getMessage());
    }

    /**
     * @methodName commonException
     * @description 通用异常
     * @param e
     * @return com.besttop.common.model.ResultEntity
     * @author wangjian
     * @date 2020/05/22 10:17
     */
    @ExceptionHandler(CommonException.class)
    public ResultEntity commonException(CommonException e){
        return new ResultEntity(e.getResultEnum(), e.getMessage());
    }

    /**
     * @methodName healthException
     * @description 健康检查异常
     * @param e
     * @return com.besttop.common.model.ResultEntity
     * @author wangjian
     * @date 2020/12/21 16:00
     */
    @ExceptionHandler(HealthException.class)
    public ResultEntity healthException(HealthException e) {
        throw e;
    }
}
