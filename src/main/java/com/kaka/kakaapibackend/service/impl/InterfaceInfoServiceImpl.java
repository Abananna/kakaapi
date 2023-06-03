package com.kaka.kakaapibackend.service.impl;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaka.kaapiclientstarter.client.KaApiClient;
import com.kaka.kaapicommon.model.entity.User;
import com.kaka.kaapicommon.model.entity.UserInterfaceInfo;
import com.kaka.kakaapibackend.common.BaseResponse;
import com.kaka.kakaapibackend.common.ErrorCode;
import com.kaka.kakaapibackend.common.ResultUtils;
import com.kaka.kakaapibackend.exception.BusinessException;
import com.kaka.kakaapibackend.model.dto.interfaceinfo.InterfaceInfoInvoke;
import com.kaka.kakaapibackend.model.entity.RusticWord;
import com.kaka.kakaapibackend.model.enums.InterfaceInfoStatusEnum;
import com.kaka.kakaapibackend.service.InterfaceInfoService;
import com.kaka.kakaapibackend.mapper.InterfaceInfoMapper;
import com.kaka.kaapicommon.model.entity.InterfaceInfo;
import com.kaka.kakaapibackend.service.RusticWordService;
import com.kaka.kakaapibackend.service.UserInterfaceInfoService;
import com.kaka.kakaapibackend.service.UserService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

/**
* @author qiaziwei
* @description 针对表【interface_info(接口信息)】的数据库操作Service实现
* @createDate 2023-04-30 20:22:25
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo> implements InterfaceInfoService{


    @Override
    public void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add) {
        if (interfaceInfo == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }

        String name = interfaceInfo.getName();
        String description = interfaceInfo.getDescription();
        String url = interfaceInfo.getUrl();
        String requestHeader = interfaceInfo.getRequestHeader();
        String responseHeader = interfaceInfo.getResponseHeader();
        String method = interfaceInfo.getMethod();
        String requestParams = interfaceInfo.getRequestParams();

        List<String> neededParams = Arrays.asList(name, description, url, requestHeader, responseHeader, method, requestParams);
        //参数必须非空
        if (StringUtils.isAnyBlank(name, description, url, requestHeader, responseHeader, method, requestParams) || ObjectUtils.anyNull(neededParams)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR,"参数不能为空");
        }
        //method需要在常用方法内
        if(!isContainsMethod(method)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求方法不支持");
        }


    }

    private boolean isContainsMethod(String method) {
        List<String> methodList = Arrays.asList("GET","POST","PUT","DELETE");
        return methodList.contains(method.toUpperCase());
    }
}




