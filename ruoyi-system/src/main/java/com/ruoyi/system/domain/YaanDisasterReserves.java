package com.ruoyi.system.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class YaanDisasterReserves {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * county
     */
    @TableField(value="county")
    private String county;

    /**
     * storage_points_count
     */
    @TableField(value="storage_points_count")
    private Integer storagePointsCount;

    /**
     * total_kits_count
     */
    @TableField(value="total_kits_count")
    private Integer totalKitsCount;

    /**
     * disaster_tents_count
     */
    @TableField(value="disaster_tents_count")
    private Integer disasterTentsCount;

    /**
     * cotton_blankets_count
     */
    @TableField(value="cotton_blankets_count")
    private Integer cottonBlanketsCount;

    /**
     * other_blankets_count
     */
    @TableField(value="other_blankets_count")
    private Integer otherBlanketsCount;

    /**
     * cotton_clothes_count
     */
    @TableField(value="cotton_clothes_count")
    private Integer cottonClothesCount;

    /**
     * cotton_coats_count
     */
    @TableField(value="cotton_coats_count")
    private Integer cottonCoatsCount;

    /**
     * other_clothes_count
     */
    @TableField(value="other_clothes_count")
    private Integer otherClothesCount;

    /**
     * wool_blankets_count
     */
    @TableField(value="wool_blankets_count")
    private Integer woolBlanketsCount;

    /**
     * folding_beds_count
     */
    @TableField(value="folding_beds_count")
    private Integer foldingBedsCount;

    /**
     * bunk_beds_count
     */
    @TableField(value="bunk_beds_count")
    private Integer bunkBedsCount;

    /**
     * striped_cloth_bundles_count
     */
    @TableField(value="striped_cloth_bundles_count")
    private Integer stripedClothBundlesCount;

    /**
     * moisture_mats_count
     */
    @TableField(value="moisture_mats_count")
    private Integer moistureMatsCount;

    /**
     * generators_count
     */
    @TableField(value="generators_count")
    private Integer generatorsCount;

    /**
     * lighting_fixtures_count
     */
    @TableField(value="lighting_fixtures_count")
    private Integer lightingFixturesCount;

    /**
     * lighting_kits_count
     */
    @TableField(value="lighting_kits_count")
    private Integer lightingKitsCount;

    /**
     * flashlights_count
     */
    @TableField(value="flashlights_count")
    private Integer flashlightsCount;

    /**
     * raincoats_count
     */
    @TableField(value="raincoats_count")
    private Integer raincoatsCount;

    /**
     * rain_boots_count
     */
    @TableField(value="rain_boots_count")
    private Integer rainBootsCount;

    /**
     * other_supplies_count
     */
    @TableField(value="other_supplies_count")
    private Integer otherSuppliesCount;

    /**
     * address
     */
    @TableField(value="address")
    private String address;

    /**
     * longitude
     */
    @TableField(value="longitude")
    private String longitude;

    /**
     * latitude
     */
    @TableField(value="latitude")
    private String latitude;

    /**
     * contact_person
     */
    @TableField(value="contact_person")
    private String contactPerson;

    /**
     * contact_phone
     */
    @TableField(value="contact_phone")
    private String contactPhone;

    /**
     * insert_time
     */
    @TableField(value="insert_time")
    private Date insertTime;
}
