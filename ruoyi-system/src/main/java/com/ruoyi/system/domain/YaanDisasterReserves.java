package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

@Data
public class YaanDisasterReserves {

    @TableId(value = "id", type = IdType.AUTO)
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
    /**
     * 雨衣（件）
     */
    private Integer raincoatsCount;

    /**
     * 雨靴（双）
     */
    private Integer rainBootsCount;

    /**
     * 其他装备数量（个）
     */
    private Integer otherSuppliesCount;

    /**
     * 地址
     */
    private String address;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 联系人
     */
    private String contactPerson;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 插入时间
     */
    private Date insertTime;

    /**
     * 点
     */
//    private Geometry point;
}
