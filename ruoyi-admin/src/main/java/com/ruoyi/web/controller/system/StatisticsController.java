package com.ruoyi.web.controller.system;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.system.domain.YaanAftershockStatistics;
import com.ruoyi.system.domain.bto.RequestBTO;
import com.ruoyi.system.service.impl.YaanAftershockStatisticsServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    @Resource
    private YaanAftershockStatisticsServiceImpl yaanAftershockStatisticsServiceImpl;

    @PostMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response, @RequestBody RequestBTO requestBTO) throws IOException {
        String[] fields = requestBTO.getFields();
        Integer[] ids = requestBTO.getIds();
        List<YaanAftershockStatistics> list;
        if (ids == null || ids.length == 0) {
            list = yaanAftershockStatisticsServiceImpl.list().stream().sorted(Comparator.comparing(YaanAftershockStatistics::getInsertTime).reversed()).collect(Collectors.toList());
        } else {
            list = yaanAftershockStatisticsServiceImpl.listByIds(Arrays.asList(ids));
        }
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("地震数据信息统计表", "UTF-8").replaceAll("\\+", "%20");
        response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");

        EasyExcel.write(response.getOutputStream(), YaanAftershockStatistics.class).includeColumnFiledNames(Arrays.asList(fields)).sheet("地震数据信息统计表")
                .doWrite(list);
    }

    @PostMapping("/getYaanAftershockStatistics")
    public IPage<YaanAftershockStatistics> getYaanAftershockStatistics(@RequestBody RequestBTO requestBTO) {
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
                .apply("TO_CHAR(insert_time, 'YYYY-MM-DD HH24:MI:SS') LIKE {0}", requestBTO.getRequestParams());
        return yaanAftershockStatisticsServiceImpl.page(yaanAftershockStatisticsPage, lambdaQueryWrapper);
    }


}
