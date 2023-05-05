package com.kaka.kakaapibackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kaka.kaapicommon.model.entity.UserInterfaceInfo;

import java.util.List;

/**
 * @author kaka
 */
public interface UserInterfaceInfoService extends IService<UserInterfaceInfo> {
    void validUserInterfaceInfo(UserInterfaceInfo userinterfaceInfo, boolean add);

    boolean invokeCount(long interfaceInfoId, long userId);

    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(int limit);

}
