package com.kaka.kakaapibackend.model.enums;

/**
 * 接口信息状态枚举
 * @author kaka
 */
public enum InterfaceInfoStatusEnum {

    ONLINE("上线", 1),
    OFFLINE("下线", 0);


    private final String status;
    private final Integer value;

    InterfaceInfoStatusEnum(String status, Integer value) {
        this.status = status;
        this.value = value;
    }

    public String getStatus() {
        return status;
    }

    public Integer getValue() {
        return value;
    }
}
