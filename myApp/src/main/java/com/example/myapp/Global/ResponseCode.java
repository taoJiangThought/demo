package com.example.myapp.Global;

/**
 * 系统返回码
 * @author jiangtaotao
 */
public class ResponseCode {

    public static final ResponseCode COMMON_SUCCESS = new ResponseCode("200", "成功");
    public static final ResponseCode COMMON_SYSTEM_ERROR = new ResponseCode("500", "系统异常");
    public static final ResponseCode COMMON_PARAMS_MISSING = new ResponseCode("100001", "请求参数不全");
    public static final ResponseCode COMMON_PARAMS_ILLEGAL = new ResponseCode("100002", "请求参数非法");

    /**
     * 错误码
     */
    private String errCode;
    /**
     * 错误信息
     */
    private String errMsg;

    public ResponseCode(String errCode, String errMsg) {
        super();
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    @Override
    public String toString() {
        return "ResponseCode [" + (errCode != null ? "errCode=" + errCode + ", " : "") + (errMsg != null ? "errMsg=" + errMsg : "") + "]";
    }
}


