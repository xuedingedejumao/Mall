package com.aurora.mallcommon.api;

public class R<T> {
    private long code;
    private String message;
    private T data;

    protected R(){
    }

    protected R(long code,String message,T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> R<T> success(T data){
        return new R<T>(RCode.SUCCESS.getCode(),RCode.SUCCESS.getMessage(),data);
    }

    public static <T> R<T> success(T data,String message){
        return new R<>(RCode.SUCCESS.getCode(), message,data);
    }

    public static <T> R<T> failed(IErrorCode errorCode){
        return new R<T>(errorCode.getCode(),errorCode.getMessage(),null);
    }

    public static <T> R<T> failed(IErrorCode errorCode,String message){
        return new R<>(errorCode.getCode(), message,null);
    }

    public static <T> R<T> failed(String message){
        return new R<T>(RCode.FAILED.getCode(), message,null);
    }

    public static <T> R<T> failed(){return failed(RCode.FAILED);}

    public static <T> R<T> validateFailed(){
        return failed(RCode.VALIDATE_FAILED);
    }

    public static <T> R<T> validateFailed(String message){
        return new R<T>(RCode.VALIDATE_FAILED.getCode(), message,null);
    }

    public static <T> R<T> unauthorized(T data){
        return new R<T>(RCode.UNAUTHORIZED.getCode(), RCode.UNAUTHORIZED.getMessage(),data);
    }

    public static <T> R<T> forbidden(T data){
        return new R<T>(RCode.FORBIDDEN.getCode(), RCode.FORBIDDEN.getMessage(),data);
    }

    public long getCode(){return code;}
    public void setCode(long code){this.code=code;}
    public String getMessage(){return message;}
    public void setMessage(String message){this.message=message;}
    public T getData(){return data;}
    public void setData(T data){this.data=data;}
}
