package com.guiyunweb.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

/**
 * @author wnkj
 */
@Slf4j
public class JsonUtils {

    public static String toJSONString(Object object){
        return new Gson().toJson(object);
    }

    public static <T> T parse(String string,Class<T> tClass) {
        return new Gson().fromJson(string,tClass);
    }

}
