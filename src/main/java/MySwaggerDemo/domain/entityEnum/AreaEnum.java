package MySwaggerDemo.domain.entityEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @EnumName: AreaEnum
 * @Author: GengRui
 * @Date: 2019/11/25 15:28
 */
public enum AreaEnum {
    Occident(1, "欧美"),
    Japan(2, "日本"),
    HongKong(3, "香港"),
    Mainland(4, "大陆"),
    other(5, "其他");

    public Integer code;
    public String value;

    AreaEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }

    static Map<Integer, AreaEnum> codeMap = new HashMap<>();

    static Map<String, AreaEnum> valueMap = new HashMap<>();

    static {
        for (AreaEnum e : AreaEnum.values()) {
            codeMap.put(e.getCode(), e);
            valueMap.put(e.getValue(), e);
        }
    }

    public static AreaEnum getAreaByCode(Integer code) {
        return codeMap.get(code);
    }

    public static AreaEnum getAreaByName(String value) {
        return valueMap.get(value);
    }
}
