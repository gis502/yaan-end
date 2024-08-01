package com.ruoyi.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.system.domain.bto.RequestBTO;
import com.ruoyi.system.domain.export.YaanRelocationResettlementDisasterReliefGroup;
import com.ruoyi.system.service.YaanRelocationResettlementDisasterReliefGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.ruoyi.system.mapper.YaanRelocationResettlementDisasterReliefGroupMapper;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class YaanRelocationResettlementDisasterReliefGroupServiceImpl
        extends ServiceImpl<YaanRelocationResettlementDisasterReliefGroupMapper, YaanRelocationResettlementDisasterReliefGroup>
        implements YaanRelocationResettlementDisasterReliefGroupService {


    private YaanRelocationResettlementDisasterReliefGroupMapper yaanRelocationResettlementDisasterReliefGroupMapper;

    @Override
    public IPage<YaanRelocationResettlementDisasterReliefGroup> getPage(RequestBTO requestBTO) {
        Page<YaanRelocationResettlementDisasterReliefGroup>
                YaanRelocationResettlementDisasterReliefGroupPage =
                new Page<>(requestBTO.getCurrentPage(), requestBTO.getPageSize());

        String requestParams = requestBTO.getRequestParams();
        LambdaQueryWrapper<YaanRelocationResettlementDisasterReliefGroup> queryWrapper =
                Wrappers.lambdaQuery(YaanRelocationResettlementDisasterReliefGroup.class)
                        .like(YaanRelocationResettlementDisasterReliefGroup::getEarthquakeId, requestParams)
                        .or()
                        .like(YaanRelocationResettlementDisasterReliefGroup::getEarthquakeArea, requestParams)
                        .or()
                        .apply("CAST(insert_time AS TEXT) LIKE {0}", "%" + requestParams + "%")
                        .or()
                        .apply("CAST(activated_emergency_shelters AS TEXT) LIKE {0}", "%" + requestParams + "%")
                        .or()
                        .apply("CAST(constructed_temporary_shelters AS TEXT) LIKE {0}", "%" + requestParams + "%")
                        .or()
                        .apply("CAST(new_relocations AS TEXT) LIKE {0}", "%" + requestParams + "%")
                        .or()
                        .apply("CAST(total_relocations AS TEXT) LIKE {0}", "%" + requestParams + "%")
                        .or()
                        .apply("CAST(centralized_resettlements AS TEXT) LIKE {0}", "%" + requestParams + "%")
                        .or()
                        .apply("CAST(distributed_resettlements AS TEXT) LIKE {0}", "%" + requestParams + "%")
                        .or()
                        .apply("CAST(earthquake_time AS TEXT) LIKE {0}", "%" + requestParams + "%")
                        .or()
                        .apply("CAST(filling_time AS TEXT) LIKE {0}", "%" + requestParams + "%");

        return this.page(YaanRelocationResettlementDisasterReliefGroupPage, queryWrapper);
    }

    @Override
    public List<YaanRelocationResettlementDisasterReliefGroup> exportExcelGetData(RequestBTO requestBTO) {
        Integer[] ids = requestBTO.getIds();
        List<YaanRelocationResettlementDisasterReliefGroup> list;
        if (ids == null || ids.length == 0) {
            list = this.list().stream()
                    .sorted(Comparator.comparing(YaanRelocationResettlementDisasterReliefGroup::getInsertTime)
                            .reversed()).collect(Collectors.toList());
        } else {
            list = this.listByIds(Arrays.asList(ids));
        }
        return list;
    }
}
