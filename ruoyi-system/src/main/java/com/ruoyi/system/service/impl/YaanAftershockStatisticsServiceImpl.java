package com.ruoyi.system.service.impl;


import cn.hutool.core.bean.BeanUtil;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.system.domain.Import.AfterShockStatistics;
import com.ruoyi.system.domain.YaanAftershockStatisticsDO;
import com.ruoyi.system.domain.bto.RequestBTO;
import com.ruoyi.system.mapper.EqListMapper;
import com.ruoyi.system.mapper.YaanAftershockStatisticsMapper;
import com.ruoyi.system.service.IYaanAftershockStatisticsService;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class YaanAftershockStatisticsServiceImpl extends ServiceImpl<YaanAftershockStatisticsMapper, YaanAftershockStatisticsDO> implements IYaanAftershockStatisticsService {

    @Resource
    private EqListMapper eqListMapper;

    @Override
    public IPage<YaanAftershockStatisticsDO> getPage(RequestBTO requestBTO) {
        Page<YaanAftershockStatisticsDO> yaanAftershockStatisticsPage = new Page<>(requestBTO.getCurrentPage(), requestBTO.getPageSize());
        LambdaQueryWrapper<YaanAftershockStatisticsDO> lambdaQueryWrapper = new QueryWrapper<YaanAftershockStatisticsDO>()
                .lambda()
                .like(YaanAftershockStatisticsDO::getEarthquakeId, requestBTO.getRequestParams())
                .or()
                .like(YaanAftershockStatisticsDO::getEarthquake, requestBTO.getRequestParams())
                .or()
                .apply("CAST(aftershock_count AS TEXT) = {0}", requestBTO.getRequestParams())
                .or()
                .apply("CAST(magnitude_3_0_to_3_9 AS TEXT) = {0}", requestBTO.getRequestParams())
                .or()
                .apply("CAST(magnitude_4_0_to_4_9 AS TEXT) = {0}", requestBTO.getRequestParams())
                .or()
                .apply("CAST(magnitude_5_0_to_5_9 AS TEXT) = {0}", requestBTO.getRequestParams())
                .or()
                .like(YaanAftershockStatisticsDO::getInsertTime, requestBTO.getRequestParams());
        return this.page(yaanAftershockStatisticsPage, lambdaQueryWrapper);
    }

    @Override
    public List<YaanAftershockStatisticsDO> exportExcelGetData(RequestBTO requestBTO) {
        Integer[] ids = requestBTO.getIds();
        List<YaanAftershockStatisticsDO> list;
        if (ids == null || ids.length == 0) {
            list = this.list().stream()
                    .sorted(Comparator.comparing(YaanAftershockStatisticsDO::getInsertTime)
                            .reversed()).collect(Collectors.toList());
        } else {
            list = this.listByIds(Arrays.asList(ids));
        }
        return list;
    }

    @Override
    public List<YaanAftershockStatisticsDO> importExcel(MultipartFile file, String userName) throws IOException {
        InputStream inputStream = file.getInputStream();
        // 读取总行数（略过表头）
        int totalRows = WorkbookFactory.create(inputStream).getSheetAt(0).getPhysicalNumberOfRows() - 4;
        inputStream.close();
        // 重新获取 InputStream
        inputStream = file.getInputStream();
        AfterShockStatisticsListener listener = new AfterShockStatisticsListener(baseMapper, totalRows, userName);
        // 读取Excel文件，从第4行开始
        EasyExcel.read(inputStream, AfterShockStatistics.class, listener).headRowNumber(2).sheet().doRead();
        // 获取解析后的数据
        List<AfterShockStatistics> list = listener.getList();
        // 将解析后的数据保存到数据库
        // 遍历解析后的数据，根据地震时间与地震名称查找eqList表中的earthquakeId
        for (AfterShockStatistics data : list) {
            // 根据地震时间与地震名称查询 earthquakeId
            String earthquakeId = eqListMapper.findEarthquakeIdByTimeAndPosition(data.getInsertTime(), data.getEarthquake());
            // 设置 earthquakeId
            data.setEarthquakeId(earthquakeId);
        }
        //集合拷贝
        List<YaanAftershockStatisticsDO> listDOs = BeanUtil.copyToList(list, YaanAftershockStatisticsDO.class);
        saveBatch(listDOs);
        return listDOs;
    }
}
