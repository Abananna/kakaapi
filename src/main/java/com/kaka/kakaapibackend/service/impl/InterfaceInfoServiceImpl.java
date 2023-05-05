package com.kaka.kakaapibackend.service.impl;
import java.util.Date;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kaka.kakaapibackend.common.ErrorCode;
import com.kaka.kakaapibackend.exception.BusinessException;
import com.kaka.kakaapibackend.service.InterfaceInfoService;
import com.kaka.kakaapibackend.mapper.InterfaceInfoMapper;
import com.kaka.kaapicommon.model.entity.InterfaceInfo;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
* @author qiaziwei
* @description 针对表【interface_info(接口信息)】的数据库操作Service实现
* @createDate 2023-04-30 20:22:25
*/
@Service
public class InterfaceInfoServiceImpl extends ServiceImpl<InterfaceInfoMapper, InterfaceInfo>
    implements InterfaceInfoService{
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
        Integer status = interfaceInfo.getStatus();
        String method = interfaceInfo.getMethod();
        Long userId = interfaceInfo.getUserId();
        Date createTime = interfaceInfo.getCreateTime();
        Date updateTime = interfaceInfo.getUpdateTime();
        Integer isDelete = interfaceInfo.getIsDelete();

        // 创建时，所有参数必须非空
        if (add) {
            if (StringUtils.isAnyBlank(description,requestHeader) || ObjectUtils.anyNull(name, url)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }

    }
}




