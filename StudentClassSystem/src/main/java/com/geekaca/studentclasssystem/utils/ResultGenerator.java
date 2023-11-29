package com.geekaca.studentclasssystem.utils;

import org.springframework.util.StringUtils;

/**
 * 响应结果生成工具
 *
 
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";
    private static final String DEFAULT_FAIL_MESSAGE = "FAIL";
    private static final int RESULT_CODE_SUCCESS = 200;
    private static final int RESULT_CODE_SERVER_ERROR = 500;

    public static com.geekaca.studentclasssystem.utils.Result genSuccessResult() {
        com.geekaca.studentclasssystem.utils.Result result = new com.geekaca.studentclasssystem.utils.Result();
        result.setResultCode(RESULT_CODE_SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        return result;
    }

    public static com.geekaca.studentclasssystem.utils.Result genSuccessResult(String message) {
        com.geekaca.studentclasssystem.utils.Result result = new com.geekaca.studentclasssystem.utils.Result();
        result.setResultCode(RESULT_CODE_SUCCESS);
        result.setMessage(message);
        return result;
    }

    public static com.geekaca.studentclasssystem.utils.Result genSuccessResult(Object data) {
        com.geekaca.studentclasssystem.utils.Result result = new com.geekaca.studentclasssystem.utils.Result();
        result.setResultCode(RESULT_CODE_SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        result.setData(data);
        return result;
    }

    public static com.geekaca.studentclasssystem.utils.Result genFailResult(String message) {
        com.geekaca.studentclasssystem.utils.Result result = new com.geekaca.studentclasssystem.utils.Result();
        result.setResultCode(RESULT_CODE_SERVER_ERROR);
        if (!StringUtils.hasText(message)) {
            result.setMessage(DEFAULT_FAIL_MESSAGE);
        } else {
            result.setMessage(message);
        }
        return result;
    }

    public static com.geekaca.studentclasssystem.utils.Result genErrorResult(int code, String message) {
        com.geekaca.studentclasssystem.utils.Result result = new com.geekaca.studentclasssystem.utils.Result();
        result.setResultCode(code);
        result.setMessage(message);
        return result;
    }
}
