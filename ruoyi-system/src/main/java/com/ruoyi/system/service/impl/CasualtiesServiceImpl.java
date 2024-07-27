package com.ruoyi.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.system.domain.export.YaanCasualties;
import com.ruoyi.system.domain.bto.RequestBTO;
import com.ruoyi.system.mapper.CasualtiesMapper;
import com.ruoyi.system.service.ICasualtiesService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CasualtiesServiceImpl extends ServiceImpl<CasualtiesMapper, YaanCasualties> implements ICasualtiesService {

    @Override
    public IPage<YaanCasualties> getPage(RequestBTO requestBTO) {
        // 创建分页对象
        Page<YaanCasualties> yaanCasualtiesPage = new Page<>(requestBTO.getCurrentPage(), requestBTO.getPageSize());

        // 创建查询构造器
        LambdaQueryWrapper<YaanCasualties> queryWrapper = Wrappers.lambdaQuery(YaanCasualties.class);

        // 获取请求参数
        String requestParams = requestBTO.getRequestParams();

        // 只有在 requestParams 不为空时才添加查询条件
        if (requestParams != null && !requestParams.trim().isEmpty()) {
            queryWrapper
                    .like(YaanCasualties::getEarthquakeId, requestParams)
                    .or()
                    .like(YaanCasualties::getEarthquakeArea, requestParams)
                    .or()
                    .apply("CAST(insert_time AS TEXT) LIKE {0}", "%" + requestParams + "%")
                    .or()
                    .like(YaanCasualties::getNewDeaths, requestParams)
                    .or()
                    .like(YaanCasualties::getNewInjuries, requestParams)
                    .or()
                    .like(YaanCasualties::getNewMissing, requestParams)
                    .or()
                    .like(YaanCasualties::getTotalDeaths, requestParams)
                    .or()
                    .like(YaanCasualties::getTotalInjuries, requestParams)
                    .or()
                    .like(YaanCasualties::getTotalMissing, requestParams);
        }

        return this.page(yaanCasualtiesPage, queryWrapper);
    }

    @Override
    public List<YaanCasualties> exportExcelGetData(RequestBTO requestBTO) {
        Integer[] ids = requestBTO.getIds();
        List<YaanCasualties> list;
        if (ids == null || ids.length == 0) {
            list = this.list().stream()
                    .sorted(Comparator.comparing(YaanCasualties::getInsertTime)
                            .reversed()).collect(Collectors.toList());
        } else {
            list = this.listByIds(Arrays.asList(ids));
        }
        return list;
    }
}
