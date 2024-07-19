package com.ruoyi.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.system.domain.AfterShockStatistics;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AfterShockStatisticsService extends IService<AfterShockStatistics> {

    List<AfterShockStatistics> importExcel(MultipartFile file,String userName) throws IOException;
}
