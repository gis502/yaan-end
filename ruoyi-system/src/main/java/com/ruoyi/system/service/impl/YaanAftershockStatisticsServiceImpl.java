package com.ruoyi.system.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.system.domain.YaanAftershockStatistics;
import com.ruoyi.system.domain.bto.RequestBTO;
import com.ruoyi.system.mapper.YaanAftershockStatisticsMapper;
import com.ruoyi.system.service.IYaanAftershockStatisticsService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class YaanAftershockStatisticsServiceImpl extends ServiceImpl<YaanAftershockStatisticsMapper, YaanAftershockStatistics> implements IYaanAftershockStatisticsService {

    @Override
    public IPage<YaanAftershockStatistics> getPage(RequestBTO requestBTO) {
        Page<YaanAftershockStatistics> yaanAftershockStatisticsPage = new Page<>(requestBTO.getCurrentPage(), requestBTO.getPageSize());
        LambdaQueryWrapper<YaanAftershockStatistics> lambdaQueryWrapper = new QueryWrapper<YaanAftershockStatistics>()
                .lambda()
                .like(YaanAftershockStatistics::getEarthquakeId, requestBTO.getRequestParams())
                .or()
                .like(YaanAftershockStatistics::getEarthquake, requestBTO.getRequestParams())
                .or()
                .apply("CAST(aftershock_count AS TEXT) = {0}", requestBTO.getRequestParams())
                .or()
                .apply("CAST(magnitude_3_0_to_3_9 AS TEXT) = {0}", requestBTO.getRequestParams())
                .or()
                .apply("CAST(magnitude_4_0_to_4_9 AS TEXT) = {0}", requestBTO.getRequestParams())
                .or()
                .apply("CAST(magnitude_5_0_to_5_9 AS TEXT) = {0}", requestBTO.getRequestParams())
                .or()
                .apply("TO_CHAR(insert_time, 'YYYY-MM-DD HH24:MI:SS') LIKE {0}", requestBTO.getRequestParams());
        return this.page(yaanAftershockStatisticsPage, lambdaQueryWrapper);
    }

    @Override
    public List<YaanAftershockStatistics> exportExcelGetData( RequestBTO requestBTO) {
        Integer[] ids = requestBTO.getIds();
        List<YaanAftershockStatistics> list;
        if (ids == null || ids.length == 0){
            list = this.list().stream()
                    .sorted(Comparator.comparing(YaanAftershockStatistics::getInsertTime)
                            .reversed()).collect(Collectors.toList());
        }else{
            list = this.listByIds(Arrays.asList(ids));
        }
        return list;
    }
}
