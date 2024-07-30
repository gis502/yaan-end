package com.ruoyi.system.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.system.domain.EqList;
import com.ruoyi.system.domain.export.YaanCasualties;
import com.ruoyi.system.domain.bto.RequestBTO;
import com.ruoyi.system.mapper.YaanCasualtiesMapper;
import com.ruoyi.system.mapper.EqListMapper;
import com.ruoyi.system.service.IYaanCasualtiesService;
import lombok.SneakyThrows;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class YaanCasualtiesServiceImpl extends ServiceImpl<YaanCasualtiesMapper, YaanCasualties> implements IYaanCasualtiesService {

    @Resource
    private EqListMapper eqListMapper;
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
                    .like(YaanCasualties::getEarthquake, requestParams)
                    .or()
                    .apply("CAST(insert_time AS TEXT) LIKE {0}", "%" + requestParams + "%")
                    .or()
                    .apply("CAST(affected_population AS TEXT) LIKE {0}", "%" + requestParams + "%")
                    .or()
                    .apply("CAST(county_town AS TEXT) LIKE {0}", "%" + requestParams + "%")
                    .or()
                    .apply("CAST(filling_time AS TEXT) LIKE {0}", "%" + requestParams + "%")
                    .or()
                    .apply("CAST(new_deaths AS TEXT) LIKE {0}", "%" + requestParams + "%")
                    .or()
                    .apply("CAST(new_injuries AS TEXT) LIKE {0}", "%" + requestParams + "%")
                    .or()
                    .apply("CAST(earthquake_time AS TEXT) LIKE {0}", "%" + requestParams + "%")
                    .or()
                    .apply("CAST(new_missing AS TEXT) LIKE {0}", "%" + requestParams + "%")
                    .or()
                    .apply("CAST(total_deaths AS TEXT) LIKE {0}", "%" + requestParams + "%")
                    .or()
                    .apply("CAST(total_injuries AS TEXT) LIKE {0}", "%" + requestParams + "%")
                    .or()
                    .apply("CAST(total_missing AS TEXT) LIKE {0}", "%" + requestParams + "%");
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

    @SneakyThrows
    @Override
    public List<YaanCasualties> importExcel(MultipartFile file, String userName) {
        InputStream inputStream = file.getInputStream();
        // 读取总行数（略过表头）
        int totalRows = WorkbookFactory.create(inputStream).getSheetAt(0).getPhysicalNumberOfRows() - 4;
        inputStream.close();
        // 重新获取 InputStream
        inputStream = file.getInputStream();
        YaanCasualtiesListener listener = new YaanCasualtiesListener(baseMapper, totalRows, userName);
        // 读取Excel文件，从第4行开始
        EasyExcel.read(inputStream, YaanCasualties.class, listener).headRowNumber(2).sheet().doRead();
        // 获取解析后的数据
        List<YaanCasualties> list = listener.getList();
        // 将解析后的数据保存到数据库
        // 遍历解析后的数据，根据地震时间与地震名称查找eqList表中的earthquakeId
        for (YaanCasualties data : list) {
            // 根据地震时间与地震名称查询 earthquakeId
            List<EqList> earthquakeIdByTimeAndPosition = eqListMapper.findEarthquakeIdByTimeAndPosition(data.getEarthquake());
            // 设置 earthquakeId
            data.setEarthquakeId(earthquakeIdByTimeAndPosition.get(0).getEqid());
            data.setEarthquakeTime(earthquakeIdByTimeAndPosition.get(0).getTime());
            data.setInsertTime(LocalDateTime.now());
        }
        //集合拷贝
//        List<YaanAftershockStatistics> listDOs = BeanUtil.copyToList(list, YaanAftershockStatistics.class);
        saveBatch(list);
        return list;
    }
}
