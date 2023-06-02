package com.kaka.kakaapibackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaka.kaapicommon.model.entity.InterfaceInfo;

/**
* @author qiaziwei
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2023-04-30 20:22:25
*/
public interface InterfaceInfoService extends IService<InterfaceInfo> {

    void validInterfaceInfo(InterfaceInfo interfaceInfo, boolean add);

}
