package com.ruoyi.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.system.domain.export.YaanCasualties;
import com.ruoyi.system.domain.bto.RequestBTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IYaanCasualtiesService extends IService<YaanCasualties> {
    IPage<YaanCasualties> getPage(RequestBTO requestBTO);

    List<YaanCasualties> exportExcelGetData(RequestBTO requestBTO);

    List<YaanCasualties>  importExcel1(MultipartFile file, String userName);
}
