package com.zeng.repository.utils.exception;

public class ServerException extends RuntimeException {

    public static int NORMAL_RETURN_CODE = 10000;
    public static int EXPECT_PARAM_CLIENT = 4001;
    public static int TOKEN_FAILURE_CODE = 20000;
    public static int PARAMETER_ERROR_CODE = 30000;
    public static int FUNCTION_ERROR_CODE = 40000;

    public static int SERVER_ERROR_CODE = 50000;


    private int code;
    private String msg;

    public ServerException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {

        switch (code) {
            case 200:
                return NORMAL_RETURN_CODE;
            case 4001:
                return EXPECT_PARAM_CLIENT;
            case 404:
            case 405:
                return FUNCTION_ERROR_CODE;
            default:
                return SERVER_ERROR_CODE;
        }
    }

    public String getMsg() {
        return msg;
    }


}