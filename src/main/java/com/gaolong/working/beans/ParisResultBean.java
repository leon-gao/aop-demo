package com.gaolong.working.beans;

import com.gaolong.working.enums.ParisExceptionEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author zl
 * @Date 2019-02-28
 * @Des ${todo}
 */
@Data
public class ParisResultBean<T> implements Serializable {


    private String errorMessage; // 错误消息

    private int errorCode; // 错误码

    private String errorDetail; // 消息的详情信息

    private T data;
    public ParisResultBean(){}

    public ParisResultBean(String errorMessage, int errorCode,String errorDetail, T data){
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
        this.data = data;
        this.errorDetail = errorDetail;
    }

    public static <T> ParisResultBean build() {
        return ParisResultBean.build(ParisExceptionEnum.SUCCESS);
    }

    public static <T> ParisResultBean build(ParisExceptionEnum exceptionEnum) {
        return new ParisResultBean(exceptionEnum.getCode(), exceptionEnum.getMessage());
    }

    public static <T> ParisResultBean<T> build(T data) {
        return ParisResultBean.build(ParisExceptionEnum.SUCCESS, data);
    }

    public static <T> ParisResultBean<T> build(ParisExceptionEnum exceptionEnum, T data) {
        return ParisResultBean.build(exceptionEnum, null, data);
    }

    public static <T> ParisResultBean<T> build(ParisExceptionEnum exceptionEnum, String errorDetail, T data) {
        ParisResultBean<T> resultBean = new ParisResultBean<T>(exceptionEnum.getCode(), exceptionEnum.getMessage(), errorDetail, data);
        return resultBean;
    }

    private ParisResultBean(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    private ParisResultBean(int errorCode, String errorMessage, String errorDetail, T data) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorDetail = errorDetail;
        this.data = data;
    }


    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }

    public static void main(){

    }


}
