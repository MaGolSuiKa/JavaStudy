package com.geekaca.controller;

import com.geekaca.exception.BusinessException;
import com.geekaca.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
//学会模仿
//@RestControllerAdvice用于标识当前类为REST风格对应的异常处理器

/**
 * 核心！！！
 * 针对 @RestController抛出的异常，可以由这个AOP来拦截
 */
@RestControllerAdvice
public class ProjectExceptionAdvice {
    //@ExceptionHandler用于设置当前处理器类对应的异常类型
    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,ex对象发送给开发人员
        return new Result(ex.getCode(),null,ex.getMessage());
    }
    //handler：处理器   参数指定 要处理的异常
    @ExceptionHandler(BusinessException.class)
    public Result doBusinessException(BusinessException ex){
        //构造一个统一的接口数据格式对象，返回给前端
        //log 日志写文件，写DB
        return new Result(ex.getCode(),null,ex.getMessage());
    }

    //除了自定义的异常处理器，保留对Exception类型的异常处理，用于处理非预期的异常
    @ExceptionHandler(Exception.class)
    public Result doOtherException(Exception ex){
        //记录日志
        //发送消息给运维
        //发送邮件给开发人员,ex对象发送给开发人员
        return new Result(Code.SYSTEM_UNKNOW_ERR,null,"系统繁忙，请稍后再试！");
    }
}
