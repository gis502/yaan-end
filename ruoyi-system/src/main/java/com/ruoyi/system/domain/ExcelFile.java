package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 导入导出文件表实体类
 */
@Data
@TableName("excel_file")
public class ExcelFile {
    /**
     * 主键
     */
    @TableId("id")
    private Integer id;

    /**
     * 文件名称
     */
    @TableField("file_name")
    private String fileName;
    /**
     * 导表可选字段
     */
    @TableField("file_column")
    private String fileColumn;
}
