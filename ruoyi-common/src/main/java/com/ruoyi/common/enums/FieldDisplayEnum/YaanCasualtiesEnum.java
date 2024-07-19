package com.ruoyi.common.enums.FieldDisplayEnum;

import com.ruoyi.common.enums.BaseFieldDisplayEnum;

public enum YaanCasualtiesEnum implements BaseFieldDisplayEnum {
    EARTHQUAKE_ID("earthquakeId", "地震标识"),
    EARTHQUAKE("seismicZoneId", "震区标识"),
    INSERT_TIME("insertTime", "统计截止时间"),
    NEW_DEATHS("newDeaths", "新增遇难（人）"),
    NEW_INJURIES("newInjuries", "新增受伤（人）"),
    NEW_MISSING("newMissing", "新增失踪（人）"),
    TOTAL_DEATHS("totalDeaths", "累计遇难（人）"),
    TOTAL_INJURIES("totalInjuries", "累计受伤（人）"),
    TOTAL_MISSING("totalMissing", "累计失踪（人）")
    ;
    ;
    private final String field;  // 数据库字段
    private final String name;

    YaanCasualtiesEnum(String field, String name) {
        this.field = field;
        this.name = name;
    }

    @Override
    public String getField() {
        return field;
    }

    @Override
    public String getName() {
        return name;
    }
}
