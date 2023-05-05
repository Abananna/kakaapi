package com.kaka.kakaapibackend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kaka.kakaapibackend.common.ErrorCode;
import com.kaka.kakaapibackend.exception.BusinessException;
import com.kaka.kakaapibackend.mapper.UserMapper;
import com.kaka.kaapicommon.model.entity.User;
import com.kaka.kaapicommon.service.InnerGetSecretKey;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;

import javax.annotation.Resource;

/**
 * @author kaka
 */

@DubboService
public class InnerGetSecretKeyImpl implements InnerGetSecretKey {

    @Resource
    UserMapper userMapper;
    @Override
    public User getUserByKey(String accessKey) {
        if (StringUtils.isBlank(accessKey)) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("accessKey",accessKey);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        return user;
    }
}
