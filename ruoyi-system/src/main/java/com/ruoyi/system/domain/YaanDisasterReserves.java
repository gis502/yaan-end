package com.ruoyi.system.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 生活类救灾物资储备情况统计表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class YaanDisasterReserves {
    private Integer id;

    /**
    * 县（区）
    */
    private String county;

    /**
    * 储备库点数量（个）
    */
    private Integer storagePointsCount;

    /**
    * 合计总件套数
    */
    private Integer totalKitsCount;

    /**
    * 救灾帐篷（顶）
    */
    private Integer disasterTentsCount;

    /**
    * 棉被（床）
    */
    private Integer cottonBlanketsCount;

    /**
    * 其他被子（床）
    */
    private Integer otherBlanketsCount;

    /**
    * 棉衣裤（套）
    */
    private Integer cottonClothesCount;

    /**
    * 棉大衣（件）
    */
    private Integer cottonCoatsCount;

    /**
    * 其他衣物（套、件）
    */
    private Integer otherClothesCount;

    /**
    * 毛毯（床）
    */
    private Integer woolBlanketsCount;

    /**
    * 折叠床（张）
    */
    private Integer foldingBedsCount;

    /**
    * 高低床（套）
    */
    private Integer bunkBedsCount;

    /**
    * 彩条布（包）
    */
    private Integer stripedClothBundlesCount;

    /**
    * 防潮垫（张）
    */
    private Integer moistureMatsCount;

    /**
    * 发电机（台）
    */
    private Integer generatorsCount;

    /**
    * 照明灯具（个）
    */
    private Integer lightingFixturesCount;

    /**
    * 照明灯组（套）
    */
    private Integer lightingKitsCount;

    /**
    * 手电筒（支）
    */
    private Integer flashlightsCount;

    private Integer raincoatsCount;

    private Integer rainBootsCount;

    private Integer otherSuppliesCount;

    private String address;

    private String longitude;

    private String latitude;

    private String contactPerson;

    private String contactPhone;

    private Date insertTime;
}
