package com.kaka.kakaapibackend.model.vo;

import com.kaka.kaapicommon.model.entity.InterfaceInfo;
import lombok.Data;

/**
 * 接口信息封装视图
 * @author kaka
 */

@Data
public class InterfaceInfoVO extends InterfaceInfo {

    /**
     * 调用次数
     */
    private Integer totalNum;

    private static final long serialVersionUID = 1L;
}
