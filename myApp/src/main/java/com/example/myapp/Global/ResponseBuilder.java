package com.example.myapp.Global;

/**
 * 返回信息构建类
 */
public class ResponseBuilder {

    /**
     * 创建成功返回
     *
     * @param t
     * @return
     */
    public static <T> Response<T> createSuccessRes(T t) {
        return new Response<T>(true, ResponseCode.COMMON_SUCCESS, "成功", t);
    }
    /**
     * 创建成功返回
     *
     * @param msg
     * @return
     */
    public static <T> Response<T> createSuccessRes(String msg) {
        return new Response<T>(true, ResponseCode.COMMON_SUCCESS, msg, null);
    }

    /**
     * 创建成功返回
     * @param msg
     * @param t
     * @param <T>
     * @return
     */
    public static <T> Response<T> createSuccessRes(String msg,T t) {
        return new Response<T>(true, ResponseCode.COMMON_SUCCESS, msg, null);
    }

    /**
     * 创建系统错误返回
     *
     * @param detail
     * @return
     */
    public static <T> Response<T> createSysteErrorRes(String detail) {
        return new Response<T>(false, ResponseCode.COMMON_SYSTEM_ERROR, detail, null);
    }

    /**
     * 创建失败返回
     *
     * @param responseCode
     * @param detail
     * @return
     */
    public static <T> Response<T> createFailRes(ResponseCode responseCode, String detail) {
        return new Response<T>(false, responseCode, detail, null);
    }

    /**
     * 创建失败返回
     *
     * @param responseCode
     * @param detail
     * @param t
     * @return
     */
    public static <T> Response<T> createFailRes(ResponseCode responseCode, String detail, T t) {
        return new Response<T>(false, responseCode, detail, t);
    }

    /**
     * 创建失败返回
     *
     * @param resCode
     * @param resMsg
     * @param detail
     * @param t
     * @return
     */
    public static <T> Response<T> createFailRes(String resCode, String resMsg, String detail, T t) {
        return new Response<T>(false, resCode, resMsg, detail, t);
    }

    /**
     * 创建失败返回
     *
     * @param resCode
     * @param resMsg
     * @param detail
     * @return
     */
    public static <T> Response<T> createFailRes(String resCode, String resMsg, String detail) {
        return new Response<T>(false, resCode, resMsg, detail, null);
    }

    /**
     * 创建失败返回
     *
     * @param failRes
     * @return
     */
    public static <T> Response<T> createFailRes(Response<?> failRes) {
        return new Response<T>(false, failRes.getResCode(), failRes.getResMsg(), failRes.getdetail(), null);
    }

    /**
     * 创建失败返回
     *
     * @param response
     * @return
     */
    public static <T> Response<T> createFailRes(Response<?> response, T object) {
        return new Response<T>(false, response.getResCode(), response.getResMsg(), response.getdetail(), object);
    }

    /**
     * 异常返回
     *
     * @param e
     * @return
     */
    public static <T> Response<T> createExceptionRes(Exception e) {
        if (e instanceof RuntimeException) {
            RuntimeException exception = (RuntimeException) e;
            return new Response<T>(false, ResponseCode.COMMON_SYSTEM_ERROR, exception.getMessage(), null);
        } else {
            return createSysteErrorRes(e.getMessage());
        }
    }
}


