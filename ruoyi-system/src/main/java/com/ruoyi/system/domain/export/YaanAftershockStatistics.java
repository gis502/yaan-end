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
@TableName("yaan_aftershock_statistics")
@ColumnWidth(20)
public class YaanAftershockStatistics {

    @ExcelIgnore
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ExcelProperty({"震情灾情", "地震标识"})
    @TableField(value = "earthquake_id")
    private String earthquakeId;

    @ExcelProperty({"震情灾情", "地震名称"})
    @TableField(value = "earthquake")
    private String earthquake;

    @ExcelProperty(value = {"震情灾情", "震区"})
    @TableField(value = "earthquake_area")
    private String earthquakeArea;

    @ExcelProperty(value = {"震情灾情", "统计截止时间"})
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    @TableField(value = "filling_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date fillingTime;

    @ExcelProperty({"震情灾情", "余震次数累计"})
    @TableField(value = "aftershock_count")
    private Integer aftershockCount;

    @ExcelProperty({"震情灾情", "3.0-3.9级"})
    @TableField(value = "magnitude_3_0_to_3_9")
    private Integer magnitude30To39;

    @ExcelProperty({"震情灾情", "4.0-4.9级"})
    @TableField(value = "magnitude_4_0_to_4_9")
    private Integer magnitude40To49;

    @ExcelProperty({"震情灾情", "5.0-5.9级"})
    @TableField(value = "magnitude_5_0_to_5_9")
    private Integer magnitude50To59;

    @ExcelIgnore
    @TableField(value = "insert_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime insertTime;




    @ExcelProperty(value = {"震情灾情", "地震时间"})
    @TableField(value = "earthquake_time")
    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp earthquakeTime;


}
