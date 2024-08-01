package com.ruoyi.system.domain.export;

import java.util.Date;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 雅安市移民安置灾害救助组表
 * @author 方
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ColumnWidth(20)
public class YaanRelocationResettlementDisasterReliefGroup {
    /**
     * 主键id
     */
    @ExcelIgnore
    private Integer id;

    /**
     * 地震标识
     */
    @ExcelProperty(value = {"移民安置灾害救助", "地震标识"})
    private String earthquakeId;

    /**
     * 震区标识
     */
    @ExcelProperty(value = {"移民安置灾害救助", "震区"})
    private String earthquakeArea;

    /**
     * 记录时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ExcelProperty(value = {"移民安置灾害救助", "记录时间"})
    private Date insertTime;

    /**
     * 启用应急避难场所（处）
     */
    @ExcelProperty(value = {"移民安置灾害救助", "启用应急避难场所（处）"})
    private Integer activatedEmergencyShelters;

    /**
     * 搭建临时安置点（处）
     */
    @ExcelProperty(value = {"移民安置灾害救助", "搭建临时安置点（处）"})
    private Integer constructedTemporaryShelters;

    /**
     * 新增转移安置（人）
     */
    @ExcelProperty(value = {"移民安置灾害救助", "新增转移安置（人）"})
    private Integer newRelocations;

    /**
     * 累计转移安置（人）
     */
    @ExcelProperty(value = {"移民安置灾害救助", "累计转移安置（人）"})
    private Integer totalRelocations;

    /**
     * 集中安置（人）
     */
    @ExcelProperty(value = {"移民安置灾害救助", "集中安置（人）"})
    private Integer centralizedResettlements;

    /**
     * 分散安置（人）
     */
    @ExcelProperty(value = {"移民安置灾害救助", "分散安置（人）"})
    private Integer distributedResettlements;

    /**
     * 地震时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ExcelProperty(value = {"移民安置灾害救助", "地震时间"})
    private Date earthquakeTime;


    /**
     * 插入时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ExcelProperty(value = {"移民安置灾害救助", "地震时间"})
    private Date fillingTime;
}
