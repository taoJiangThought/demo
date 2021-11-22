package com.example.myapp.Global;



import java.io.Serializable;

/**
 * 接口返回
 * @author jiangtaotao
 */

public class Response<T> implements Serializable {

    private static final long serialVersionUID = -6806276312394164937L;

    /**
     * 是否成功 true是 false否
     */
    private boolean isSuccess;

    /**
     * 返回码
     */
    private String resCode;

    /**
     * 返回信息
     */
    private String resMsg;

    /**
     * 详情
     */
    private String detail;

    /**
     * 返回的具体内容
     */
    private T data;

    public Response() {

    }

    public Response(boolean isSuccess, String resCode, String resMsg, String detail, T data) {
        super();
        this.isSuccess = isSuccess;
        this.resCode = resCode;
        this.resMsg = resMsg;
        this.detail = detail;
        this.data = data;
    }

    public Response(boolean isSuccess, ResponseCode responseCode, String detail, T data) {
        super();
        this.isSuccess = isSuccess;
        this.resCode = responseCode.getErrCode();
        this.resMsg = responseCode.getErrMsg();
        this.detail = detail;
        this.data = data;
    }

    public String getdetail() {
        return detail;
    }

    public void setdetail(String detail) {
        this.detail = detail;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Response [isSuccess=" + isSuccess + ", " + (resCode != null ? "resCode=" + resCode + ", " : "") + (resMsg != null ? "resMsg=" + resMsg + ", " : "")
                + (detail != null ? "detail=" + detail + ", " : "") + (data != null ? "data=" + data : "") + "]";
    }
}


