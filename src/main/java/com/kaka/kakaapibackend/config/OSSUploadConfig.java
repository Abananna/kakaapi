package com.kaka.kakaapibackend.config;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author kaka
 */
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
@Data
public class OSSUploadConfig {

    private String endpoint;

    private String accessKeyId;

    private String accessKeySecret;

    private String bucketName;

    private String maxSize;

    private String prefix;

    /**
     * 连接初始化
     * @return ：ossClient
     */
    @Bean
    public OSSClient createOssClient() {
        return (OSSClient) new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
    }

}
