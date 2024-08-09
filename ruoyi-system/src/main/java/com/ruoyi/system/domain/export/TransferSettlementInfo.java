package com.ruoyi.system.domain.export;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;
import lombok.Data;

/**
 * 震后生成-灾害现场动态信息-灾民救助信息-转移安置信息（用户上传数据）
 */
@Data
@TableName(value = "transfer_settlement_info")
public class TransferSettlementInfo {
    @TableId(value = "uuid", type = IdType.INPUT)
    private Object uuid;

    /**
     * 地震名称
     */
    @TableField(value = "earthquake_name")
    private String earthquakeName;

    /**
     * 编号
     */
    @TableField(value = "transfer_id")
    private String transferId;

    /**
     * 地震标识
     */
    @TableField(value = "earthquake_id")
    private String earthquakeId;

    /**
     * 震区名称
     */
    @TableField(value = "earthquake_area_name")
    private String earthquakeAreaName;

    /**
     * 启用应急避难场所（处）
     */
    @TableField(value = "emergency_shelters")
    private Integer emergencyShelters;

    /**
     * 搭建临时安置点（处）
     */
    @TableField(value = "temporary_shelters")
    private Integer temporaryShelters;

    /**
     * 新增转移安置（人）
     */
    @TableField(value = "newly_transferred")
    private Integer newlyTransferred;

    /**
     * 累计转移安置（人）
     */
    @TableField(value = "cumulative_transferred")
    private Integer cumulativeTransferred;

    /**
     * 集中安置（人）
     */
    @TableField(value = "centralized_settlement")
    private Integer centralizedSettlement;

    /**
     * 分散安置（人）
     */
    @TableField(value = "distributed_settlement")
    private Integer distributedSettlement;

    /**
     * 填报截止时间
     */
    @TableField(value = "reporting_deadline")
    private Date reportingDeadline;

    /**
     * 系统插入时间
     */
    @TableField(value = "system_inserttime")
    private Date systemInserttime;

    /**
     * 地震时间
     */
    @TableField(value = "earthquake_time")
    private Date earthquakeTime;
}