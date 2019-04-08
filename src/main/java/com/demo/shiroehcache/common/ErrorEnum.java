package com.demo.shiroehcache.common;

/**
 * @author xin.rf
 * @date 2018/11/12 15:07
 * @Description TODO
 **/
public enum ErrorEnum {
    /**
     * 异常错误枚举类
     */
    LOGIN_OVERDUE(1000,"登陆已过期,请重新登陆"),
    Exception_Req(1001,"请求异常"),
    Lack_Req_Param(1002,"缺少必填参数"),
    Phone_Code_Error(1003,"验证码错误！"),
    Update_Fail(1004,"修改失败！"),
    DATA_IS_NULL(1005,"数据为空！"),
    DELETE_FAIL(1006,"删除失败"),
    File_Is_Null(1007,"上传文件不得为空"),
    Format_Convert_Fail(1008,"格式转换失败"),
    File_Is_Too_Large(1009,"上传文件过大，请压缩后上传"),
    Network_error(1010,"网络错误，请检查网络"),
    ENCRYPT_ERROR(1011,"加密异常"),
    Please_Perfect_Info(1012,"请完善个人资料"),
    Create_Token_Fail(1013,"创建token失败"),
    Token_Is_Invail(1014,"登录状态已失效，请重新登录"),
    Username_Password_Error(1015,"用户名或密码错误"),
    PASSWORD_ERROR_MORE_THAN_FIVE(1010,"密码输入错误超过五次，请1分钟后重试！"),
    USERNAME_PASSWORD_ERROR(1003,"用户名或密码错误"),
    EXCEPTION_REQ(1004,"请求异常")


    ;
    



    ;

    private Integer key;

    private String msg;

    ErrorEnum(Integer key, String msg) {
        this.key = key;
        this.msg = msg;
    }

    public Integer getKey() {
        return key;
    }

    public String getMsg() {
        return msg;
    }
}
