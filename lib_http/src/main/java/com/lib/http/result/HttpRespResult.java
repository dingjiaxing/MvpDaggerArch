package com.lib.http.result;

/**
 * <p>Description:
 *
 * <p>Created by Devin Sun on 2017/3/25.
 */

public class HttpRespResult<T> {

    private static final int SUCCESS_CODE = 1000;

    private String message;
    private Integer code;
    private T data;

    public boolean isSuccess() {
        return code != null && code == SUCCESS_CODE;
    }

    public String getMessage() {
        return message;
    }

    public Integer getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "HttpResponseResult{" +
                "msg='" + message + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
