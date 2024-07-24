package com.ruoyi.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.system.domain.Import.AfterShockStatistics;
import com.ruoyi.system.domain.YaanAftershockStatisticsDO;
import com.ruoyi.system.domain.export.YaanAftershockStatistics;
import com.ruoyi.system.domain.bto.RequestBTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IYaanAftershockStatisticsService extends IService<YaanAftershockStatistics> {

    IPage<YaanAftershockStatistics> getPage(RequestBTO requestBTO);

    List<YaanAftershockStatistics> exportExcelGetData(RequestBTO requestBTO);

    List<YaanAftershockStatistics> importExcel(MultipartFile file, String userName) throws IOException;
}
