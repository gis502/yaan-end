package com.ruoyi.system.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ruoyi.system.domain.AfterShockStatistics;
import com.ruoyi.system.mapper.AfterShockStatisticsMapper;
import com.ruoyi.system.mapper.EqListMapper;
import com.ruoyi.system.service.AfterShockStatisticsService;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Service
public class AfterShockStatisticsServiceImpl extends ServiceImpl<AfterShockStatisticsMapper, AfterShockStatistics> implements AfterShockStatisticsService {

    @Resource
    private EqListMapper eqListMapper;

    @Override
    public List<AfterShockStatistics> importExcel(MultipartFile file,String userName) throws IOException {
        InputStream inputStream = file.getInputStream();
        // 读取总行数（略过表头）
        int totalRows = WorkbookFactory.create(inputStream).getSheetAt(0).getPhysicalNumberOfRows() - 4;
        inputStream.close();
        // 重新获取 InputStream
        inputStream = file.getInputStream();
        AfterShockStatisticsListener listener = new AfterShockStatisticsListener(baseMapper,totalRows,userName);
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
            saveBatch(list);
            return list;
    }
}

