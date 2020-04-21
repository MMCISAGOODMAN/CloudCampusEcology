package com.service.thirdparty.enums;

import org.springframework.util.StringUtils;

/**
 * @ClassName DeleteFlag
 * @Description 设备改变类型
 * @Author mamingcong
 * @Date 2020/4/21 14:17
 * @Version 1.0
 */
public enum ChangeType {

    SBMC("1", "设备名称"),
    SBLX("2", "设备类型"),
    SBCS("3", "设备厂商"),
    DJDD("4", "登记地点"),
    SSZD("5", "所属站点");
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

    private ChangeType(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static ChangeType get(String code) {
        if (StringUtils.hasLength(code)) {
            for (ChangeType element : ChangeType.values()) {
                if (element.getCode().equals(code)) {
                    return element;
                }
            }
        }
        return null;
    }
}
