package com.json.util;


/**
 * @author json
 * 返回枚举
 *
 */
public enum ResultCode {

    SUCCESS("10001","操作成功"),
    Fail("10002","操作失败");

    private String code;
    private String msg;

    ResultCode(String code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
