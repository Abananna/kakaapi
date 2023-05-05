package com.kaka.kakaapibackend.provider;

import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author kaka
 */

@DubboService
public class InvokeCountServiceImpl implements InvokeCountService {

    @Override
    public String sayHello() {
        return "hello world";
    }
}
