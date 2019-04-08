package com.demo.shiroehcache.config;

import com.demo.shiroehcache.common.CodeException;
import com.demo.shiroehcache.common.ErrorEnum;
import com.demo.shiroehcache.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xin.rf
 * @date 2019/2/13 19:10
 * @Description TODO
 **/
@ControllerAdvice
public class GlobalControllerAdvice {
    /**
     * 全局异常捕捉处理
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Result errorHandler(Exception ex) {
        return Result.error(ErrorEnum.EXCEPTION_REQ);
    }

    /**
     * 拦截捕捉自定义异常 MyException.class
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = CodeException.class)
    public Result myErrorHandler(CodeException ex) {
        Result result=new Result();
        result.setMsg(ex.getMsg());
        result.setCode(ex.getCode());
        return result;
    }
}
