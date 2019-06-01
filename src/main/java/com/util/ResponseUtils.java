package com.util;

import org.springframework.util.StringUtils;

public class ResponseUtils {

    private int code;

    private String message;

    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static ResponseUtils success() {
        ResponseUtils responseUtils = new ResponseUtils();
        responseUtils.setCode(ResponseEnum.SUCCESS.getValue());
        responseUtils.setMessage(ResponseEnum.SUCCESS.getName());
        return responseUtils;
    }

    public static ResponseUtils success(Object data) {
        ResponseUtils responseUtils = new ResponseUtils();
        responseUtils.setCode(ResponseEnum.SUCCESS.getValue());
        responseUtils.setMessage(ResponseEnum.SUCCESS.getName());
        responseUtils.setData(data);
        return responseUtils;
    }

    public static ResponseUtils fail(ResponseEnum responseEnum, String errorDes) {
        ResponseUtils responseUtils = new ResponseUtils();
        responseUtils.setCode(responseEnum.getValue());
        if (StringUtils.isEmpty(errorDes)) {
            responseUtils.setMessage(responseEnum.getName());
        } else {
            responseUtils.setMessage(errorDes);
        }

        return responseUtils;
    }

}
