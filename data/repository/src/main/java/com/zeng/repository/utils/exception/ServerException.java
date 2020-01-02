package com.zeng.repository.utils.exception;

public class ServerException extends RuntimeException {

    public static int NORMAL_RETURN_CODE = 10000;
    public static int TOKEN_FAILURE_CODE = 20000;
    public static int PARAMETER_ERROR_CODE = 30000;
    public static int FUNCTION_ERROR_CODE = 40000;

    public static int SERVER_ERROR_CODE = 50000;


    private String code;
    private String msg;

    public ServerException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {

        switch (code) {
            case "200":
                return NORMAL_RETURN_CODE;
            case "01":
                return TOKEN_FAILURE_CODE;
            case "02":
                return PARAMETER_ERROR_CODE;
            case "405":
                return FUNCTION_ERROR_CODE;
            case "500":
            case "501":
                return SERVER_ERROR_CODE;
            default:
                return NORMAL_RETURN_CODE;
        }
    }

    public String getMsg() {
        return msg;
    }


}