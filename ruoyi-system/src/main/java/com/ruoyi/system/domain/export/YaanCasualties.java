package com.ruoyi.system.domain.export;

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

import java.sql.Timestamp;
import java.time.LocalDateTime;
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
    @ExcelProperty({"人员伤亡", "地震标识"})
    @TableField(value = "earthquake_id")
    private String earthquakeId;

    /**
     * earthquake_area
     */
    @TableField(value = "earthquake_area")
    @ExcelProperty({"人员伤亡", "震区"})
    private String earthquakeArea;

    @TableField(value = "earthquake")
    @ExcelProperty({"人员伤亡", "地震名称"})
    private String earthquake;

    @TableField(value = "affected_population")
    @ExcelProperty({"人员伤亡", "受灾人数累积"})
    private Integer affectedPopulation;

    @TableField(value = "county_town")
    @ExcelProperty({"人员伤亡", "受灾县区数量"})
    private Integer countyTown;

    /**
     * filling_time
     */
    @ExcelProperty(value = {"人员伤亡", "统计截止时间"})
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    @TableField(value = "filling_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date fillingTime;

    @ExcelIgnore
    @TableField(value = "insert_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime insertTime;

    @ExcelProperty(value = {"人员伤亡", "地震时间"})
    @TableField(value = "earthquake_time")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp earthquakeTime;
    /**
     * new_deaths
     */
    @TableField(value = "new_deaths")
    @ExcelProperty(value = {"人员伤亡", "新增遇难（人）"})
    private Integer newDeaths;

    /**
     * new_missing
     */
    @TableField(value = "new_missing")
    @ExcelProperty(value = {"人员伤亡", "新增失联（人）"})
    private Integer newMissing;

    /**
     * new_injuries
     */
    @TableField(value = "new_injuries")
    @ExcelProperty(value = {"人员伤亡", "新增受伤（人）"})
    private Integer newInjuries;

    /**
     * total_deaths
     */
    @TableField(value = "total_deaths")
    @ExcelProperty(value = {"人员伤亡", "累计遇难（人）"})
    private Integer totalDeaths;

    /**
     * total_missing
     */
    @TableField(value = "total_missing")
    @ExcelProperty(value = {"人员伤亡", "累计失联（人）"})
    private Integer totalMissing;

    /**
     * total_injuries
     */
    @TableField(value = "total_injuries")
    @ExcelProperty(value = {"人员伤亡", "累计受伤（人）"})
    private Integer totalInjuries;
}

