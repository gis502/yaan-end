package com.ruoyi.system.domain.Import;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@NoArgsConstructor
@TableName("yaan_aftershock_statistics")
public class AfterShockStatistics {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    @TableField(value = "earthquake_id")
    private String earthquakeId;
    @TableField(value = "earthquake")
    @ExcelProperty(value = "地震名称")
    private String earthquake;
    @TableField(value = "aftershock_count")
    @ExcelProperty(value = "余震次数累计")
    private Integer aftershockCount;
    @TableField(value = "magnitude_3_0_to_3_9")
    @ExcelProperty(value = "3.0-3.9级")
    private Integer magnitude30To39;
    @TableField(value = "magnitude_4_0_to_4_9")
    @ExcelProperty(value = "4.0-4.9级")
    private Integer magnitude40To49;
    @TableField(value = "magnitude_5_0_to_5_9")
    @ExcelProperty(value = "5.0-5.9级")
    private Integer magnitude50To59;
    @TableField(value = "insert_time")
    @ExcelProperty(value = "地震时间")
    private String insertTime;
}
