package com.kaka.kakaapibackend.model.dto.interfaceinfo;

import lombok.Data;

/**
 * 测试调用请求
 * @author kaka
 */
@Data
public class InterfaceInfoInvoke {
    /**
     * 主键
     */
    private Long id;

    /**
     * 请求参数
     * [
     *    {"name":"username", "type":"string"}
     * ]
     */
    private String userRequestParams;

    private static final long serialVersionUID = 1L;
}
