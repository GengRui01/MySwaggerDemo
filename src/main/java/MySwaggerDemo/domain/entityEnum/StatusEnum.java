package MySwaggerDemo.domain.entityEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @EnumName: StatusEnum
 * @Author: GengRui
 * @Date: 2019/11/25 19:33
 */
public enum StatusEnum {
    Disable(0, "停用"),
    Enable(1, "启用");

    public Integer code;
    public String value;

    StatusEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    static Map<Integer, StatusEnum> codeMap = new HashMap<>();

    static Map<String, StatusEnum> valueMap = new HashMap<>();

    static {
        for (StatusEnum e : StatusEnum.values()) {
            codeMap.put(e.getCode(), e);
            valueMap.put(e.getValue(), e);
        }
    }

    public static StatusEnum getStatusByCode(Integer code) {
        return codeMap.get(code);
    }

    public static StatusEnum getStatusByName(String value) {
        return valueMap.get(value);
    }
}
