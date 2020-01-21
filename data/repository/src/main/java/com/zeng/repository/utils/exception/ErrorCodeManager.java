package com.zeng.repository.utils.exception;

import com.zeng.model.BaseApiResult;

public class ErrorCodeManager<T> {


    public T getError(BaseApiResult<T> response) {
        return realError(response.getStatus(), response.getMsg(), response.getData());
    }

    private T realError(int ret, String message, T data) {
        switch (ret) {
            case 200:
                //  00 成功
                return data;

            case 405:
                // 方法错误
                throw new ServerException(ret, "系统错误，请稍后重试!");
            case 404:
                //地址错误
                throw new ServerException(ret, "系统错误，请稍后重试!");
            case 500:
                // 系统错误
                throw new ServerException(ret, "系统错误，请稍后重试!");
            case 503:
                throw new ServerException(ret, "访问人数过多，请稍后重试!");
            default:
                throw new ServerException(ret, message);
        }
    }


}