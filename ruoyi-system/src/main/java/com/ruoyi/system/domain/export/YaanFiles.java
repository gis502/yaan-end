package com.ruoyi.system.domain.export;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 导入导出文件表实体类
 */
@Data
@TableName("yaan_files")
public class YaanFiles {
    /**
     * 主键
     */
    @TableId("file_id")
    private Integer fileId;

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

    /**
     * 导表匹配标识
     */
    @TableField("file_flag")
    private String fileFlag;
}
