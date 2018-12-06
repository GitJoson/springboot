package com.json.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

/**
 * @author json
 * @descripe 返回
 * @param <T>
 */
@ApiModel
public class Result<T> implements Serializable {

    private static final long serialVersionUID = -7424426799887924229L;

    @ApiModelProperty(value = "错误码")
    private String code;

    @ApiModelProperty(value = "数据对象")
    private T data;

    @ApiModelProperty(value = "错误码描述")
    private String message;


    public Result(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private static Result instance = null;

    public static <E> Result<E> success(String code, String message, E data) {
        if(instance == null){
            instance = new Result(code,message,data);
        }
        return instance;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "result [code=" + code + ", data=" + data + ", message="
                + message + "]";
    }
}
