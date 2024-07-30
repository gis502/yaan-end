package com.ruoyi.system.service.impl;


import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.system.domain.EqList;
import com.ruoyi.system.domain.bto.RequestBTO;
import com.ruoyi.system.domain.export.YaanAftershockStatistics;
import com.ruoyi.system.mapper.EqListMapper;
import com.ruoyi.system.mapper.YaanAftershockStatisticsMapper;
import com.ruoyi.system.service.IYaanAftershockStatisticsService;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class YaanAftershockStatisticsServiceImpl extends ServiceImpl<YaanAftershockStatisticsMapper, YaanAftershockStatistics> implements IYaanAftershockStatisticsService {

    @Resource
    private EqListMapper eqListMapper;

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
                .apply("CAST(insert_time AS TEXT) LIKE {0}", "%" + requestBTO.getRequestParams() + "%");
        return this.page(yaanAftershockStatisticsPage, lambdaQueryWrapper);
    }

    @Override
    public List<YaanAftershockStatistics> exportExcelGetData(RequestBTO requestBTO) {
        Integer[] ids = requestBTO.getIds();
        List<YaanAftershockStatistics> list;
        if (ids == null || ids.length == 0) {
            list = this.list().stream()
                    .sorted(Comparator.comparing(YaanAftershockStatistics::getInsertTime)
                            .reversed()).collect(Collectors.toList());
        } else {
            list = this.listByIds(Arrays.asList(ids));
        }
        return list;
    }

    @Override
    public List<YaanAftershockStatistics> importExcel(MultipartFile file, String userName) throws IOException {
        InputStream inputStream = file.getInputStream();
        // 读取总行数（略过表头）
        int totalRows = WorkbookFactory.create(inputStream).getSheetAt(0).getPhysicalNumberOfRows() - 4;
        inputStream.close();
        // 重新获取 InputStream
        inputStream = file.getInputStream();
        YaanAfterShockStatisticsListener listener = new YaanAfterShockStatisticsListener(baseMapper, totalRows, userName);
        // 读取Excel文件，从第4行开始
        EasyExcel.read(inputStream, YaanAftershockStatistics.class, listener).headRowNumber(Integer.valueOf(2)).sheet().doRead();
        // 获取解析后的数据
        List<YaanAftershockStatistics> list = listener.getList();
        // 将解析后的数据保存到数据库
        // 遍历解析后的数据，根据地震时间与地震名称查找eqList表中的earthquakeId
        for (YaanAftershockStatistics data : list) {
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
