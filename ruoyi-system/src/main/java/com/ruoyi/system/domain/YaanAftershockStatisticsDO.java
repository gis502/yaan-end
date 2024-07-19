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
@TableName("yaan_aftershock_statistics")
public class YaanAftershockStatisticsDO {


    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;


    @TableField(value = "earthquake_id")
    private String earthquakeId;


    @TableField(value = "earthquake")
    private String earthquake;


    @TableField(value = "aftershock_count")
    private Integer aftershockCount;


    @TableField(value = "magnitude_3_0_to_3_9")
    private Integer magnitude30To39;


    @TableField(value = "magnitude_4_0_to_4_9")
    private Integer magnitude40To49;


    @TableField(value = "magnitude_5_0_to_5_9")
    private Integer magnitude50To59;


    @DateTimeFormat("yyyy-MM-dd HH:mm:ss")
    @TableField(value = "insert_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date insertTime;
}
