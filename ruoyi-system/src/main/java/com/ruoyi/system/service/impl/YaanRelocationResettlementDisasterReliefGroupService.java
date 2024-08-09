package com.ruoyi.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruoyi.system.domain.bto.RequestBTO;
import com.ruoyi.system.domain.export.YaanCasualties;
import com.ruoyi.system.domain.export.YaanRelocationResettlementDisasterReliefGroup;

import java.util.List;

/**
 * @author 方
 */
public interface YaanRelocationResettlementDisasterReliefGroupService{

    /**
     * 分页查询
     * @param requestBTO 请求参数
     * @return 数据
     */
    IPage<YaanRelocationResettlementDisasterReliefGroup> getPage(RequestBTO requestBTO);

    /**
     * 根据id获取导出的数据
     * @param requestBTO 请求参数
     * @return 导出数据集
     */

    List<YaanRelocationResettlementDisasterReliefGroup> exportExcelGetData(RequestBTO requestBTO);
}
