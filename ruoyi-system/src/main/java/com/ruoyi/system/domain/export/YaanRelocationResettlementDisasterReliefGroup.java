package com.ruoyi.system.domain.export;

import java.util.Date;
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
public class YaanRelocationResettlementDisasterReliefGroup {
    /**
    * 主键id
    */
    private Integer id;

    /**
    * 地震标识
    */
    private String earthquakeId;

    /**
    * 震区标识
    */
    private String seismicZoneId;

    /**
    * 记录时间
    */
    private Date insertTime;

    /**
    * 启用应急避难场所（处）
    */
    private Integer activatedEmergencyShelters;

    /**
    * 搭建临时安置点（处）
    */
    private Integer constructedTemporaryShelters;

    /**
    * 新增转移安置（人）
    */
    private Integer newRelocations;

    /**
    * 累计转移安置（人）
    */
    private Integer totalRelocations;

    /**
    * 集中安置（人）
    */
    private Integer centralizedResettlements;

    /**
    * 分散安置（人）
    */
    private Integer distributedResettlements;
}
