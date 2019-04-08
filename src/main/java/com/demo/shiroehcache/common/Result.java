package com.demo.shiroehcache.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class Result<T> {
    @ApiModelProperty(value = "响应信息")
    private String msg;
    @ApiModelProperty(value = "响应码")
    private Integer code;
    @ApiModelProperty(value = "数据")
    private T data;

    public Result() {
        this.msg = Constants.SUCCESS_MSG;
        this.code = Constants.SUCCESS_CODE;
    }

    public Result(T data) {
        this.msg = Constants.SUCCESS_MSG;
        this.code = Constants.SUCCESS_CODE;
        this.data = data;
    }

    public Result(String msg, Integer code, T data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public static Result error(ErrorEnum errorEnum) {
        Result result = new Result();
        result.setCode(errorEnum.getKey());
        result.setMsg(errorEnum.getMsg());
        return result;
    }

    public static Result ok (){
        Result result = new Result();
        result.setCode(Constants.SUCCESS_CODE);
        result.setMsg(Constants.SUCCESS_MSG);
        return result;
    }

    public static Result ok (Object data){
        Result result = new Result();
        result.setCode(Constants.SUCCESS_CODE);
        result.setMsg(Constants.SUCCESS_MSG);
        result.setData(data);
        return result;
    }
}
