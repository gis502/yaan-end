package com.ruoyi.common.enums.FieldDisplayEnum;

import com.ruoyi.common.enums.BaseFieldDisplayEnum;

public enum YaanAftershockStatisticsEnum implements BaseFieldDisplayEnum {
    EARTHQUAKE_ID("earthquakeId", "地震标识"),
    EARTHQUAKE("earthquake", "震区"),
    AFTERSHOCK_COUNT("aftershockCount", "余震次数累计"),
    MAGNITUDE_30_TO_39("magnitude30To39", "3.0-3.9级"),
    MAGNITUDE_40_TO_49("magnitude40To49", "4.0-4.9级"),
    MAGNITUDE_50_TO_59("magnitude50To59", "5.0-5.9级"),
    INSERT_TIME("insertTime", "统计截止时间");

    private final String field;  // 数据库字段
    private final String name;   // 展示到前端的中文文字

    YaanAftershockStatisticsEnum(String field, String name) {
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
