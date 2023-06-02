package com.kaka.kakaapibackend.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaka.kaapicommon.model.entity.InterfaceInfo;
import com.kaka.kaapicommon.model.entity.UserInterfaceInfo;
import com.kaka.kakaapibackend.common.ErrorCode;
import com.kaka.kakaapibackend.exception.BusinessException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author kaka
 */

@SpringBootTest()
public class ValidTest {

    @Resource
    InterfaceInfoService interfaceInfoService;

    @Resource
    UserInterfaceInfoService userInterfaceInfoService;

    @Test
    void testValidInterfaceInfo() {

        InterfaceInfo interfaceInfo = new InterfaceInfo();
        interfaceInfo.setName("abab");
        interfaceInfo.setDescription("abab is an interface");
        interfaceInfo.setUrl("http://localhost:8080");
        interfaceInfo.setRequestHeader("header");
        interfaceInfo.setRequestParams("{'username':'kaka'}");
        interfaceInfo.setResponseHeader("ok");
        interfaceInfo.setMethod("get");

        interfaceInfoService.validInterfaceInfo(interfaceInfo,true);

    }

    @Test
    void testGetLeftNum() {
        QueryWrapper<UserInterfaceInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("interfaceInfoId", 1);
        queryWrapper.eq("userId",3);
        UserInterfaceInfo userInterfaceInfo = userInterfaceInfoService.getOne(queryWrapper);
        if (userInterfaceInfo.getLeftNum() <= 0) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR, "调用次数不足");
        }
        System.out.println("res = "+ userInterfaceInfo.getLeftNum());
    }
}
