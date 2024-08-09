package com.ruoyi.system.domain;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class YaanDisasterSupplies {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 县（区）
     */
    private String county;

    /**
     * 合计总件套数
     */
    private Integer totalItems;

    /**
     * 红外探测仪
     */
    private Integer infraredDetectors;

    /**
     * 光学探测仪(蛇眼)
     */
    private Integer opticalDetectors;

    /**
     * 液压扩张钳
     */
    private Integer hydraulicSpreaders;

    /**
     * 液压剪切钳
     */
    private Integer hydraulicCutters;

    /**
     * 凿岩机
     */
    private Integer rockDrills;

    /**
     * 撬棍（把）
     */
    private Integer crowbars;

    /**
     * 钢筋速断器
     */
    private Integer rebarCutters;

    /**
     * 手动液压千斤顶
     */
    private Integer hydraulicJacks;

    /**
     * 发光棒
     */
    private Integer lightSticks;

    /**
     * 油料（升）
     */
    private BigDecimal fuelLiters;

    /**
     * 抗拉索
     */
    private Integer tensileRopeMeters;

    /**
     * 救援绳（米）
     */
    private Integer rescueRopesMeters;

    /**
     * 抛绳器
     */
    private Integer ropeThrowers;

    /**
     * 折叠梯（个）
     */
    private Integer foldingLadders;

    /**
     * 锹/镐/钩/叉/锤
     */
    private Integer shovelsPicksHooksForksHammers;

    /**
     * 折叠铲（把）
     */
    private Integer foldingShovels;

    /**
     * 口哨（个）
     */
    private Integer whistles;

    /**
     * 头盔（顶）
     */
    private Integer helmets;

    /**
     * 雨鞋（双）
     */
    private Integer rainBoots;

    /**
     * 手套（双）
     */
    private Integer gloves;

    /**
     * 救生缆索（米）
     */
    private Integer lifelinesMeters;

    /**
     * 排水泵（台）
     */
    private Integer drainagePumps;

    /**
     * 风力灭火机（个）
     */
    private Integer fireBlowers;

    /**
     * 铁锹（把）
     */
    private Integer ironShovels;

    /**
     * 救生衣（件）
     */
    private Integer lifeJackets;

    /**
     * 救生圈（个）
     */
    private Integer lifeRings;

    /**
     * 警示带（米）
     */
    private Integer warningTapesMeters;

    /**
     * 对讲机（台）
     */
    private Integer walkieTalkies;

    /**
     * 扩音器（个）
     */
    private Integer megaphones;

    /**
     * 锣（个）
     */
    private Integer gongs;

    /**
     * 头灯（个）
     */
    private Integer headlamps;

    /**
     * 手提照明灯（个）
     */
    private Integer portableLights;

    /**
     * 医疗急救箱
     */
    private Integer medicalKits;

    /**
     * 挖掘机
     */
    private Integer excavators;

    /**
     * 装载机（推土机）
     */
    private Integer loaders;

    /**
     * 抽水泵
     */
    private Integer waterPumps;

    /**
     * 接力水泵
     */
    private Integer relayPumps;

    /**
     * 移动水囊（个）
     */
    private Integer mobileWaterBags;

    /**
     * 背负式喷水灭火抢
     */
    private Integer backpackFireSprayers;

    /**
     * 油锯（个）
     */
    private Integer chainsaws;

    /**
     * 水带（米）
     */
    private Integer hosesMeters;

    /**
     * 消防水车
     */
    private Integer fireTrucks;

    /**
     * 其他
     */
    private String otherSupplies;

    /**
     * 地址
     */
    private String address;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 纬度
     */
    private BigDecimal latitude;

    /**
     * 联系人
     */
    private String contactPerson;

    /**
     * 联系电话
     */
    private String contactPhone;

    /**
     * 点
     */
//    private Geometry point;

}
