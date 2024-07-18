package com.ruoyi.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.system.domain.YaanAftershockStatistics;
import com.ruoyi.system.domain.bto.RequestBTO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface IYaanAftershockStatisticsService extends IService<YaanAftershockStatistics> {

    IPage<YaanAftershockStatistics> getPage(RequestBTO requestBTO);

    List<YaanAftershockStatistics> exportExcelGetData(RequestBTO requestBTO);
}
