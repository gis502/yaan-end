package com.ruoyi.web.controller.system;

import com.alibaba.excel.EasyExcel;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.system.domain.export.YaanAftershockStatistics;
import com.ruoyi.system.domain.export.YaanCasualties;
import com.ruoyi.system.domain.bto.RequestBTO;
import com.ruoyi.system.service.IYaanCasualtiesService;
import com.ruoyi.system.service.impl.YaanAftershockStatisticsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticsController {
    private final IYaanCasualtiesService iCasualtiesService;
    private final YaanAftershockStatisticsServiceImpl yaanAftershockStatisticsServiceImpl;

    @PostMapping("/getData")
    public AjaxResult getYaanCasualties(@RequestBody RequestBTO requestBTO) {
        String flag = requestBTO.getFlag();
        switch (flag) {
            case "1":
                return AjaxResult.success(yaanAftershockStatisticsServiceImpl.getPage(requestBTO));
            case "2":
                return AjaxResult.success(iCasualtiesService.getPage(requestBTO));
            default:
                throw new ServiceException("系统执行异常请练习管理员");

        }

    }

    @PostMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response, @RequestBody RequestBTO RequestBTO) throws IOException {
        String flag = RequestBTO.getFlag();
        Class<?> clazz = null;
        List<?> dataList = null;
        switch (flag) {
            case "1":
                clazz = YaanAftershockStatistics.class;
                dataList = yaanAftershockStatisticsServiceImpl.exportExcelGetData(RequestBTO);
                break;
            case "2":
                clazz = YaanCasualties.class;
                dataList = iCasualtiesService.exportExcelGetData(RequestBTO);
                break;
            default:
                throw new ServiceException("系统执行异常请练习管理员");

        }
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("地震数据信息统计表", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");

        EasyExcel.write(response.getOutputStream(), clazz)
                .includeColumnFiledNames(Arrays.asList(RequestBTO.getFields()))
                .sheet("地震数据信息统计表")
                .doWrite(dataList);
    }

}
