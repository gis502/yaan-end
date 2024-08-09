package com.ruoyi.system.domain.export;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 震后生成-地震灾情信息-人员伤亡表（用户上传数据）
 */
@Data
@TableName(value = "casualty_report")
public class CasualtyReport {
    /**
     * 唯一标识UUID
     */
    @TableId(value = "uuid", type = IdType.INPUT)
    private Object uuid;

    /**
     * 地震标识，标识地震事件的唯一标识符
     */
    @TableField(value = "earthquake_identifier")
    private String earthquakeIdentifier;

    /**
     * 地震名称，地震的描述性名称
     */
    @TableField(value = "earthquake_name")
    private String earthquakeName;

    /**
     * 震区名称，受影响地区的名称
     */
    @TableField(value = "affected_area_name")
    private String affectedAreaName;

    /**
     * 系统插入时间，记录被系统创建的时间
     */
    @TableField(value = "system_insert_time")
    private Date systemInsertTime;

    /**
     * 新增遇难人数，新报告的遇难者数量
     */
    @TableField(value = "newly_deceased")
    private Integer newlyDeceased;

    /**
     * 新增失联人数，新报告的失联者数量
     */
    @TableField(value = "newly_missing")
    private Integer newlyMissing;

    /**
     * 新增受伤人数，新报告的受伤者数量
     */
    @TableField(value = "newly_injured")
    private Integer newlyInjured;

    /**
     * 累计遇难人数，所有报告的遇难者总数
     */
    @TableField(value = "total_deceased")
    private Integer totalDeceased;

    /**
     * 累计失联人数，所有报告的失联者总数
     */
    @TableField(value = "total_missing")
    private Integer totalMissing;

    /**
     * 累计受伤人数，所有报告的受伤者总数
     */
    @TableField(value = "total_injured")
    private Integer totalInjured;

    /**
     * 填报截止时间，报告提交的最终期限
     */
    @TableField(value = "submission_deadline")
    private Date submissionDeadline;

    /**
     * 地震时间，地震发生的具体时间
     */
    @TableField(value = "earthquake_time")
    private Date earthquakeTime;

    /**
     * 受灾人数，受影响的总人口数量
     */
    @TableField(value = "affected_population")
    private Integer affectedPopulation;

    /**
     * 受灾县区，受影响的县级行政区名称
     */
    @TableField(value = "affected_county_district")
    private String affectedCountyDistrict;

    /**
     * 受伤程度，伤者受伤的严重程度分类
     */
    @TableField(value = "injury_degree")
    private String injuryDegree;

    /**
     * 数量，具体的数量值（根据上下文可能指不同的事物）
     */
    @TableField(value = "quantity")
    private Integer quantity;

    /**
     * 造成原因，导致伤亡的具体原因
     */
    @TableField(value = "cause")
    private String cause;

    /**
     * 场地性质，事件发生地点的性质或特征
     */
    @TableField(value = "site_nature")
    private String siteNature;

    /**
     * 年龄，受影响者的年龄
     */
    @TableField(value = "age")
    private Integer age;

    /**
     * 性别，受影响者的性别
     */
    @TableField(value = "gender")
    private String gender;

    /**
     * 民族，受影响者的民族
     */
    @TableField(value = "ethnicity")
    private String ethnicity;

    /**
     * 伤亡类型，包括死亡、受伤、失踪等分类
     */
    @TableField(value = "casualty_type")
    private String casualtyType;

    /**
     * 死亡人数，因事件死亡的人数
     */
    @TableField(value = "death_count")
    private Integer deathCount;

    /**
     * 感染例数，因事件感染的人数
     */
    @TableField(value = "infection_count")
    private Integer infectionCount;

    /**
     * 传播途径，疾病或影响传播的方式
     */
    @TableField(value = "transmission_path")
    private String transmissionPath;

    /**
     * 中毒例数，因中毒事件影响的人数
     */
    @TableField(value = "poisoning_count")
    private Integer poisoningCount;

    /**
     * 事件编号，唯一标识事件的编号
     */
    @TableField(value = "event_id")
    private String eventId;

    /**
     * 采取措施，为应对事件所采取的措施
     */
    @TableField(value = "measures_taken")
    private String measuresTaken;

    /**
     * 疑似例数，疑似受影响的人数
     */
    @TableField(value = "suspected_count")
    private Integer suspectedCount;

    /**
     * 危重例数，情况危重的人数
     */
    @TableField(value = "critical_count")
    private Integer criticalCount;

    /**
     * 中毒人数，确认中毒的人数
     */
    @TableField(value = "poisoned_count")
    private Integer poisonedCount;

    /**
     * 转移人数，被转移至安全地点的人数
     */
    @TableField(value = "transferred_count")
    private Integer transferredCount;

    /**
     * 直接经济损失，事件导致的直接经济价值损失
     */
    @TableField(value = "direct_economic_loss")
    private BigDecimal directEconomicLoss;

    /**
     * 间接经济损失，事件导致的间接经济价值损失
     */
    @TableField(value = "indirect_economic_loss")
    private BigDecimal indirectEconomicLoss;
}