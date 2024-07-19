package com.ruoyi.system.domain;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@TableName("yaan_casualties")
@ColumnWidth(20)
public class YaanCasualties {
    /**
     * id
     */
    @ExcelIgnore
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * earthquake_id
     */
    @ExcelProperty({"地震标识"})
    @TableField(value = "earthquake_id")
    private String earthquakeId;

    /**
     * seismic_zone_id
     */
    @TableField(value = "seismic_zone_id")
    @ExcelProperty({"震区标识"})
    private String seismicZoneId;

    /**
     * insert_time
     */
    @ExcelProperty(value = {"震情灾情","统计截止时间"})
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    @TableField(value = "insert_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date insertTime;

    /**
     * new_deaths
     */
    @TableField(value = "new_deaths")
    @ExcelProperty(value = {"新增遇难（人）"})
    private Integer newDeaths;

    /**
     * new_missing
     */
    @TableField(value = "new_missing")
    @ExcelProperty(value = {"新增失踪（人）"})
    private Integer newMissing;

    /**
     * new_injuries
     */
    @TableField(value = "new_injuries")
    @ExcelProperty(value = {"新增受伤（人）"})
    private Integer newInjuries;

    /**
     * total_deaths
     */
    @TableField(value = "total_deaths")
    @ExcelProperty(value = {"累计遇难（人）"})
    private Integer totalDeaths;

    /**
     * total_missing
     */
    @TableField(value = "total_missing")
    @ExcelProperty(value = {"累计失踪（人）"})
    private Integer totalMissing;

    /**
     * total_injuries
     */
    @TableField(value = "total_injuries")
    @ExcelProperty(value = {"累计受伤（人）"})
    private Integer totalInjuries;
}
