package com.ruoyi.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.system.domain.YaanCasualties;
import com.ruoyi.system.domain.bto.RequestBTO;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface ICasualtiesService extends IService<YaanCasualties> {
    IPage<YaanCasualties> getPage(RequestBTO requestBTO);

    List<YaanCasualties> exportExcelGetData(RequestBTO requestBTO);
}
