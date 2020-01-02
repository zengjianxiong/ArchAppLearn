package com.zeng.repository.utils.exception;


import com.google.gson.JsonParseException;
import com.google.gson.stream.MalformedJsonException;

import org.json.JSONException;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.text.ParseException;

import retrofit2.HttpException;

public class ExceptionEngine {

    //对应HTTP的状态码
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;


    /**
     * 未知错误
     */
    private static final int UN_KNOWN_ERROR = 1000;
    /**
     * 解析(服务器)数据错误
     */
    private static final int ANALYTIC_SERVER_DATA_ERROR = 1001;
    //解析(客户端)数据错误
//    public static final int ANALYTIC_CLIENT_DATA_ERROR = 1002;
    /**
     * 网络连接错误
     */
    private static final int CONNECT_ERROR = 1003;
    /**
     * 网络连接超时
     */
    private static final int TIME_OUT_ERROR = 1004;

    public static ApiException handleException(Throwable e) {

        ApiException ex;
        //HTTP错误
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            ex = new ApiException(e, httpException.code());
            switch (httpException.code()) {
                case UNAUTHORIZED:
                case FORBIDDEN:
                case NOT_FOUND:
                case REQUEST_TIMEOUT:
                case GATEWAY_TIMEOUT:
                case INTERNAL_SERVER_ERROR:
                case BAD_GATEWAY:
                case SERVICE_UNAVAILABLE:
                default:
                    ex.setMsg("网络错误");
                    return ex;
            }
        }
        //服务器返回的错误
        else if (e instanceof ServerException) {
            ServerException serverExc = (ServerException) e;
            ex = new ApiException(serverExc, serverExc.getCode());
            ex.setMsg(serverExc.getMsg());
            return ex;
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException
                || e instanceof MalformedJsonException) {  //解析数据错误
            ex = new ApiException(e, ANALYTIC_SERVER_DATA_ERROR);
            ex.setMsg("解析错误");
            return ex;

        }
        //连接网络错误
        else if (e instanceof ConnectException) {
            ex = new ApiException(e, CONNECT_ERROR);
            ex.setMsg("连接失败");
            return ex;
        }
        //网络超时
        else if (e instanceof SocketTimeoutException) {
            ex = new ApiException(e, TIME_OUT_ERROR);
            ex.setMsg("网络超时");
            return ex;
        } else if (e instanceof NullPointerException) {
            ex = new ApiException(e, UN_KNOWN_ERROR);
            ex.setMsg("未知错误");
            return ex;
        }
        //未知错误
        else {
            ex = new ApiException(e, UN_KNOWN_ERROR);
            ex.setMsg("未知错误");
            return ex;
        }
    }

}