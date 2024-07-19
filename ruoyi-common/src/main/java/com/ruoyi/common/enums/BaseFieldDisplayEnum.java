package com.ruoyi.common.enums;

import java.util.LinkedHashMap;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public interface BaseFieldDisplayEnum {

    String getField();

    String getName();

    /**
     * 将枚举转换为有序的 Map，其中 key 为 field，value 为 name
     *
     * @param <T>      枚举类型
     * @param enumType 枚举类的 Class 对象
     * @return 枚举常量对应的有序 Map
     */
    static <T extends BaseFieldDisplayEnum> Map<String, String> toMap(Class<T> enumType) {
        return Arrays.stream(enumType.getEnumConstants())
                .collect(Collectors.toMap(
                        BaseFieldDisplayEnum::getField,
                        BaseFieldDisplayEnum::getName,
                        (existing, replacement) -> existing, // 合并函数，如果有重复的 key，则保留第一个
                        LinkedHashMap::new // 使用 LinkedHashMap 以保持插入顺序
                ));


    }
}
