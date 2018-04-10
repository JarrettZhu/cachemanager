package com.iflytek.cachemanager.result;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;

/**
 * @author: tishen
 * @date: 2018/3/29
 * @description: 结果封装
 */
@NoArgsConstructor
public class Result<T> implements Serializable {

    /**
     * 状态码: 0-成功 1-失败
     */
    @Setter
    @Getter
    private int code;

    /**
     * 状态描述
     */
    @Setter
    @Getter
    private String msg;

    /**
     * 返回数据
     */
    @Setter
    @Getter
    private T data;

    /**
     * 异常信息
     */
    @Setter
    @Getter
    private Exception exception;

    public static <T> Result<T> newSuccess(T data) {
        Result<T> result = new Result<>();
        result.setCode(0);
        result.setMsg("操作成功");
        result.setData(data);
        return result;
    }

    public static <T> Result<T> newFailure(int code, String msg, T data, Exception exception) {
        Result<T> result = new Result<>();
        result.setCode(code != 0 ? code : 1);
        result.setMsg(msg != null ? msg : "操作失败");
        result.setData(data);
        result.setException(exception);
        return result;
    }

    public static <T> Result<T> newFailure(T data, Exception exception) {
        return newFailure(1, null, data, exception);
    }

    public boolean successOrNot() {
        return this.code == 0;
    }

    public boolean hasData() {
        return this.code == 0 && this.data != null;
    }

    public boolean hasException() {
        return this.exception != null;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Result ");
        if (this.data != null) {
            result.append("<" + this.data.getClass().getSimpleName() + "> ");
        }
        result.append("{code=" + this.code);
        if (this.msg != null) {
            result.append(", msg=" + this.msg);
        }
        if (this.data != null) {
            result.append(", data=" + this.data);
        }
        if (this.exception != null) {
            StringWriter stringWriter = new StringWriter();
            this.exception.printStackTrace(new PrintWriter(stringWriter));
            result.append(", exception=" + stringWriter.toString());
        }
        result.append(" }");
        return result.toString();
    }

}
