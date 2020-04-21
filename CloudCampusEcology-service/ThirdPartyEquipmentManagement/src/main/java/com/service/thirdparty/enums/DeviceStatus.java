package com.service.thirdparty.enums;

import org.springframework.util.StringUtils;

/**
 * @ClassName DeviceStatus
 * @Description 设备状态
 * @Author mamingcong
 * @Date 2020/4/21 14:17
 * @Version 1.0
 */
public enum DeviceStatus {

    CWLJ("1", "从未连接"),
    JCSB("2", "检测设备"),
    LJCG("3", "连接成功"),
    LJSB("4", "连接失败");
    private String code;

    private String description;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private DeviceStatus(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static DeviceStatus get(String code) {
        if (StringUtils.hasLength(code)) {
            for (DeviceStatus element : DeviceStatus.values()) {
                if (element.getCode().equals(code)) {
                    return element;
                }
            }
        }
        return null;
    }
}
