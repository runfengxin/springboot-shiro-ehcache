package com.demo.shiroehcache.common;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @author xin.rf
 * @date 2018/11/12 15:44
 * @Description 异常结果返回类
 **/
@Data
public class CodeException extends RuntimeException{

    private Integer code;

    private String msg;

    private JSONObject resultJson;

    public CodeException(JSONObject resultJson) {
        this.resultJson = resultJson;
    }

    public CodeException(ErrorEnum errorEnum){
        this.code=errorEnum.getKey();
        this.msg=errorEnum.getMsg();
    }

    public CodeException(Integer code, String msg) {
        this.code=code;
        this.msg=msg;
    }
}
