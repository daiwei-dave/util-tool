package Validation.entity;

import java.io.Serializable;


public class ResultData<T> implements Serializable {
    public static final String SUCCESS = "0";
    private static final long serialVersionUID = 0L;
    private String code = "0";
    private String msg;
    private T data;

    public ResultData() {
    }

    public ResultData(String code) {
        this.code = code;
        this.msg = "SUCCESS";
    }

    public ResultData(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultData(T data, String code) {
        this.data = data;
        this.code = code;
    }

    public ResultData(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> ResultData<T> newSuccessResultData() {
        return new ResultData();
    }

    public static <T> ResultData<T> newResultData(String code) {
        return new ResultData(code);
    }

    public static <T> ResultData<T> newResultData(String code, String msg) {
        return new ResultData(code, msg);
    }

    public static <T> ResultData<T> newResultData(T data) {
        return new ResultData("0", "SUCCESS", data);
    }

    public static <T> ResultData<T> newResultData(String code, String msg, T data) {
        return new ResultData(code, msg, data);
    }

    public static boolean isSuccess(ResultData t) {
        return t != null && "0".equals(t.getCode());
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        if ("0".equals(this.code)) {
            this.msg = "SUCCESS";
        }

        if (this.msg == null) {
            this.msg = "操作失败";
        }

        return this.msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ResultData [code=");
        builder.append(this.code);
        builder.append(", msg=");
        builder.append(this.getMsg());
        builder.append(", data=");
        builder.append(this.data);
        builder.append("]");
        return builder.toString();
    }


}
