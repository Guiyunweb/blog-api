package com.guiyunweb.model.support;

import com.google.gson.Gson;
import lombok.Data;

/**
 * @author Guiyun
 */
@Data
public class BaseResponse<T> {

    /**
     * 是否请求成功
     */
    private Boolean success;

    /**
     * 响应数据
     */
    private T data;

    private String message;


    public BaseResponse(Boolean success, T data, String message) {
        this.success = success;
        this.data = data;
        this.message = message;
    }

    public static <T> BaseResponse<T> success(T data){
        return new BaseResponse<T>(true,data,"请求成功");
    }

    public static <T> BaseResponse<T> success(String message){
        return new BaseResponse<T>(true,null,message);
    }

    public static <T> BaseResponse<T> success(T data,String message){
        return new BaseResponse<T>(true,data,message);
    }

    public static <T> BaseResponse<T> error(String message){
        return new BaseResponse<T>(false,null,message);
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
