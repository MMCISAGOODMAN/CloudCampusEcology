package demo.common.enums;

import org.springframework.util.StringUtils;

/**
 * @ClassName DeleteFlag
 * @Description TODO
 * @Author mamingcong
 * @Date 2020/4/21 14:17
 * @Version 1.0
 */
public enum DeleteFlag {

    ON("1", "有效"),
    OFF("2", "无效");
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

    private DeleteFlag(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static DeleteFlag get(String code) {
        if (StringUtils.hasLength(code)) {
            for (DeleteFlag element : DeleteFlag.values()) {
                if (element.getCode().equals(code)) {
                    return element;
                }
            }
        }
        return null;
    }
}
