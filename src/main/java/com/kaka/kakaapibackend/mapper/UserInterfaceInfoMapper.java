package com.kaka.kakaapibackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kaka.kaapicommon.model.entity.UserInterfaceInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
* @author qiaziwei
* @description 针对表【user_interface_info(用户调用接口关系表)】的数据库操作Mapper
* @createDate 2023-05-03 10:06:50
* @Entity com.kaka.kakaapibackend.model.entity.UserInterfaceInfo
*/
public interface UserInterfaceInfoMapper extends BaseMapper<UserInterfaceInfo> {
    List<UserInterfaceInfo> listTopInvokeInterfaceInfo(@Param("limit") int limit);
}




