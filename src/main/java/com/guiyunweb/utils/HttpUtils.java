package com.guiyunweb.utils;

import com.sun.javafx.logging.Logger;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;


/**
 * @author wnkj
 */
@Slf4j
public class HttpUtils {

    private static OkHttpClient client = new OkHttpClient();

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    public static final MediaType XFORM = MediaType.get("application/x-www-form-urlencoded; charset=utf-8");

    public static final MediaType PLAIN = MediaType.get("text/plain;charset=utf-8");



    /**
     * get请求
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

    /**
     * post请求
     *
     * @param url
     * @return
     * @throws IOException
     */
    public static String post(String url, MediaType mediaType, String param) throws IOException {
        RequestBody requestBody = RequestBody.create(mediaType,param);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        Response response = client.newCall(request).execute();
        String body = response.body().string();
        log.info("请求地址:"+url);
        log.info("请求结果:"+body);
        return body;
    }


}
