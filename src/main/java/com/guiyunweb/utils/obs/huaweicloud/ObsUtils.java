package com.guiyunweb.utils.obs.huaweicloud;

import com.obs.services.ObsClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

@Component
@ConfigurationProperties(prefix = "obs.huawei")
public class ObsUtils {

    static String endPoint;
    static String ak;
    static String sk;

    public static void upload(InputStream inputStream,String file) throws IOException {
        ObsClient obsClient = new ObsClient(ak, sk, endPoint);
        obsClient.putObject("guiyunweb.blog", file, inputStream);
        obsClient.close();
    }


    public String getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    public String getAk() {
        return ak;
    }

    public void setAk(String ak) {
        this.ak = ak;
    }

    public String getSk() {
        return sk;
    }

    public void setSk(String sk) {
        this.sk = sk;
    }
}

